package haipadev.starvationsaturated.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import squeek.appleskin.helpers.FoodHelper;

@Mixin(value=FoodHelper.class,remap=false)
public class AppleSkin_FoodHelperMixin {
    /**
     * @author haipadev
     * @reason Uncap saturation calculation from hunger
     */
    @Redirect(method = "getEstimatedHealthIncrement(Lnet/minecraft/item/ItemStack;Lsqueek/appleskin/api/food/FoodValues;Lnet/minecraft/entity/player/PlayerEntity;)F",
            at = @At(value = "INVOKE", target = "Ljava/lang/Math;min(FF)F"),allow=1,remap = true)
    private static float starvationsaturated$uncapSaturationFromHunger(float a, float b) {
        if (ModConfigHelper.INSTANCE.getCapSaturationToHunger(HungerManagerHelper.INSTANCE.getDifficulty())) {
            return Math.min(a, b);
        }
        return Math.min(a, ModConfigHelper.INSTANCE.getSaturationCapOnAdd(HungerManagerHelper.INSTANCE.getDifficulty()));
    }

    /**
     * @author haipadev
     * @reason Replace first check for 18 hunger to start calculating regen
     */
    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(Lnet/minecraft/item/ItemStack;Lsqueek/appleskin/api/food/FoodValues;Lnet/minecraft/entity/player/PlayerEntity;)F",
            at = @At(value = "CONSTANT", args = "floatValue=18.0F",ordinal = 0))
    private static float starvationsaturated$replaceInitialCheckFor18FoodLevelToShowHealthRegen(float original){
        return 1;
    }

    /**
     * @author haipadev
     * @reason Replace check in loop for slow-heal
     */
    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(IFF)F", at = {
            @At(value = "CONSTANT", args = "intValue=18",ordinal = 0)
    })
    private static int starvationsaturated$replace18FoodLevelToShowSlowHealthRegen(int original, int hungerLevel, float saturationLevel, float exhaustionLevel){
        return saturationLevel > 0 ? 1 : 99; // If saturationLevel > 0 return 1 so it checks true (when above 1 hunger), else return 99 so its "always" false
    }
    /**
     * @author haipadev
     * @reason Replace check in loop for fast-heal
     */
    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(IFF)F", at = {
            @At(value = "CONSTANT", args = "intValue=20",ordinal = 0)
    })
    private static int starvationsaturated$replace20FoodLevelToShowFastHealthRegen(int original, int hungerLevel, float saturationLevel, float exhaustionLevel){
        boolean bl = hungerLevel > ModConfigHelper.INSTANCE.getHungerFastRegenOverride(HungerManagerHelper.INSTANCE.getDifficulty());
        return bl && saturationLevel > 0 ? 1 : 99; // If saturationLevel > 0 return 1 so it checks true (when above 1 hunger), else return 99 so its "always" false
    }
    /**
     * @author haipadev
     * @reason Replace second check for hunger above 18, we dont regen like that
     */
    @ModifyExpressionValue(method = "getEstimatedHealthIncrement(IFF)F",
            at = @At(value = "CONSTANT", args = "intValue=18",ordinal = 1))
    private static int starvationsaturated$replaceSecondCheckFor18FoodLevelToShowSlowHealthRegen(int original){
        return ModConfigHelper.INSTANCE.getHungerSlowRegenOverride(HungerManagerHelper.INSTANCE.getDifficulty());
    }
}
