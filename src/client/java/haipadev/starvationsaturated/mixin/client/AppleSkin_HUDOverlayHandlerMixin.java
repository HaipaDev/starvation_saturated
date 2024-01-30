package haipadev.starvationsaturated.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import squeek.appleskin.api.food.FoodValues;
import squeek.appleskin.client.HUDOverlayHandler;

@Debug(export=true,print=true)
@Mixin(value=HUDOverlayHandler.class,remap=false)
public class AppleSkin_HUDOverlayHandlerMixin {
    /**
     * @author haipadev
     * @reason Uncap saturation gained overlay from hunger
     */
    @ModifyArg(method = "onRender", at = @At(value = "INVOKE", target="Lsqueek/appleskin/client/HUDOverlayHandler;drawSaturationOverlay(Lsqueek/appleskin/api/event/HUDOverlayEvent$Saturation;Lnet/minecraft/client/MinecraftClient;FF)V"),index=2)
    private float starvationsaturated$uncapSaturationOverlayFromHunger(float saturationGained, @Local FoodValues modifiedFoodValues){
        return modifiedFoodValues.getSaturationIncrement();
    }

    /**
     * @author haipadev
     * @reason Disable check for PEACEFUL
     */
    @ModifyExpressionValue(method = "shouldShowEstimatedHealth", at = @At(value = "FIELD", target="Lnet/minecraft/world/Difficulty;PEACEFUL:Lnet/minecraft/world/Difficulty;"))
    private Difficulty starvationsaturated$disableCheckForPeaceful(Difficulty original, @Local PlayerEntity player){
        if(player.getWorld().getDifficulty()==Difficulty.PEACEFUL){return Difficulty.NORMAL;}
        return Difficulty.PEACEFUL;
    }
    /**
     * @author haipadev
     * @reason Disable check for PEACEFUL
     */
    @ModifyExpressionValue(method = "shouldShowEstimatedHealth", at= @At(value = "CONSTANT", args = "intValue=18"), allow=1)
    private int starvationsaturated$ignoreCheckFor18Health(int i) {
        return 99;
    }
    /**
     * @author haipadev
     * @reason Make hunger shake actually happen like in vanilla - hunger below 0
     */
//    @ModifyExpressionValue(method = "generateBarOffsets", at= @At(value = "CONSTANT", args = "floatValue=0.0"), slice=@Slice(
//            from=@At(value="INVOKE",target="Lnet/minecraft/entity/player/PlayerEntity;getHungerManager()Lnet/minecraft/entity/player/HungerManager;")
//    ), allow=1)
//    @ModifyVariable(method = "generateBarOffsets", at= @At(value = "STORE", target = "Lnet/minecraft/entity/player/HungerManager;saturationLevel:F"), slice=@Slice(
//            from=@At(value="INVOKE",target="Lnet/minecraft/entity/player/PlayerEntity;getHungerManager()Lnet/minecraft/entity/player/HungerManager;")
//    ),ordinal = 1)
//    @ModifyVariable(method = "generateBarOffsets", at= @At(value = "STORE", ordinal = 0), slice=@Slice(
//            from=@At(value="INVOKE",target="Lnet/minecraft/entity/player/PlayerEntity;getHungerManager()Lnet/minecraft/entity/player/HungerManager;")
//    ),ordinal = 0)
//    @ModifyExpressionValue(method = "generateBarOffsets", at= @At(value = "FIELD", target = "shouldAnimatedFood"), slice=@Slice(
//            from=@At(value="INVOKE",target="Lnet/minecraft/entity/player/PlayerEntity;getHungerManager()Lnet/minecraft/entity/player/HungerManager;")
//    ))
//    private float starvationsaturated$ignoreShakeCheckForSaturation(float i, @Local HungerManager hungerManager){//@Local int foodLevel) {
////        return foodLevel;
//        return hungerManager.getFoodLevel();
//    }
    @Redirect(method = "generateBarOffsets", at=@At(value= "INVOKE",target = "Lnet/minecraft/entity/player/HungerManager;getSaturationLevel()F"))
    private float starvationsaturated$ignoreShakeCheckForSaturation(HungerManager hungerManager) {
        return hungerManager.getFoodLevel();
    }
}
