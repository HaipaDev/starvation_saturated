package haipadev.starvationsaturated.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import squeek.appleskin.api.food.FoodValues;
import squeek.appleskin.helpers.FoodHelper;

@Debug(export = true)
@Mixin(value= FoodHelper.class,remap=false)
public class AppleSkin_FoodHelperMixin {
    /**
     * @author haipadev
     * @reason Uncap saturation calculation from hunger
     */
    @Redirect(method = "getEstimatedHealthIncrement(Lnet/minecraft/item/ItemStack;Lsqueek/appleskin/api/food/FoodValues;Lnet/minecraft/entity/player/PlayerEntity;)F",
            at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F"),allow=1)
    private static float starvationsaturated$uncapSaturationFromHunger(float a, float b, @Local HungerManager stats, @Local FoodValues modifiedFoodValues) {
        return Math.min(a, 20);
    }

    /**
     * @author haipadev
     * @reason Replace first check for 18 hunger
     */
    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(Lnet/minecraft/item/ItemStack;Lsqueek/appleskin/api/food/FoodValues;Lnet/minecraft/entity/player/PlayerEntity;)F",
            at = @At(value = "CONSTANT", args = "floatValue=18.0F",ordinal = 0))
    private static float starvationsaturated$replaceInitialCheckFor18FoodLevelToShowHealthRegen(float original){
        return 0;
    }
    /**
     * @author haipadev
     * @reason Replace hunger with saturation in check
     */
//    @ModifyArg(method = "getEstimatedHealthIncrement(Lnet/minecraft/item/ItemStack;Lsqueek/appleskin/api/food/FoodValues;Lnet/minecraft/entity/player/PlayerEntity;)F",
//            at=@At(value="INVOKE", target="Lsqueek/appleskin/helpers/FoodHelper;getEstimatedHealthIncrement(IFF)F"), index=0)
//    private static int starvationsaturated$replaceHungerWithSaturation(int foodLevel,float saturationLevel,float exhaustionLevel){
//        System.out.println("foodLevel: "+foodLevel);
//        System.out.println("saturationLevel: "+saturationLevel);
//        return (int)saturationLevel;
//    }
    @Inject(method = "getEstimatedHealthIncrement(Lnet/minecraft/item/ItemStack;Lsqueek/appleskin/api/food/FoodValues;Lnet/minecraft/entity/player/PlayerEntity;)F",
            at=@At(value="TAIL")
    )
    private static void starvationsaturated$debug(ItemStack itemStack, FoodValues modifiedFoodValues, PlayerEntity player, CallbackInfoReturnable<Float> cir, @Local float healthIncrement){
        System.out.println("healthIncrement: "+healthIncrement);
    }
    /**
     * @author haipadev
     * @reason Replace second check in loop with 0
     */
    // FIX INFINITE LOOP
//    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(IFF)F", at = @At(value = "CONSTANT", args = "intValue=18",ordinal = 0))
//    private static int starvationsaturated$replace18FoodLevelToShowHealthRegen2(int original){
//        return 0;
//    }
//    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(IFF)F", at = @At(value = "CONSTANT", args = "intValue=20",ordinal = 0))
//    private static int starvationsaturated$replace20ForFastRegen(int original){
//        return 2;
//    }
    /**
     * @author haipadev
     * @reason Replace second check for hunger above 18, we dont regen like that
     */
    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(IFF)F",
            at = @At(value = "CONSTANT", args = "intValue=18",ordinal = 1))
    private static int starvationsaturated$replaceSecondCheckFor18FoodLevelToShowSlowHealthRegen(int original){
        return 99;
    }
}
