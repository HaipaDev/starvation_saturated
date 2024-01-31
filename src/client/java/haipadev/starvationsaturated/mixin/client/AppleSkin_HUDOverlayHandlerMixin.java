package haipadev.starvationsaturated.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import squeek.appleskin.api.food.FoodValues;
import squeek.appleskin.client.HUDOverlayHandler;

@Mixin(value=HUDOverlayHandler.class)
public class AppleSkin_HUDOverlayHandlerMixin {
    /**
     * @author haipadev
     * @reason Cap saturation gained overlay to config accordingly
     */
    @ModifyArg(method = "onRender", at = @At(value = "INVOKE", target="Lsqueek/appleskin/client/HUDOverlayHandler;drawSaturationOverlay(Lsqueek/appleskin/api/event/HUDOverlayEvent$Saturation;Lnet/minecraft/client/MinecraftClient;FF)V",ordinal=1),
            index=2)
    private float starvationsaturated$uncapSaturationOverlayFromHunger(float saturationGained, @Local FoodValues modifiedFoodValues, @Local PlayerEntity player, @Local HungerManager stats){
        if(ModConfigHelper.INSTANCE.getCapSaturationToMissingHealth(HungerManagerHelper.INSTANCE.getDifficulty())){
            if(player!=null) {
                float playerHealthDif=player.getMaxHealth()-player.getHealth();
//                System.out.println("playerHealthDif: "+playerHealthDif);
//                System.out.println("override: "+ModConfigHelper.INSTANCE.getCapSaturationToMissingHealthOverride(HungerManagerHelper.INSTANCE.getDifficulty()));
                float actualCap=Math.max(
                        playerHealthDif,
                        ModConfigHelper.INSTANCE.getCapSaturationToMissingHealthOverride(HungerManagerHelper.INSTANCE.getDifficulty())
                );
//                System.out.println("getSaturationLevel(): "+stats.getSaturationLevel());
//                System.out.println("actualCap: "+actualCap);
                return actualCap - stats.getSaturationLevel();
            }
        }

        if(ModConfigHelper.INSTANCE.getCapSaturationToHunger(HungerManagerHelper.INSTANCE.getDifficulty())){return saturationGained;}

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
     * @reason Disable check for 18 hunger for calculating estimated health
     */
    @ModifyExpressionValue(method = "shouldShowEstimatedHealth", at= @At(value = "CONSTANT", args = "intValue=18"), allow=1)
    private int starvationsaturated$ignoreCheckFor18Health(int i) {
        return 99;
    }

    /**
     * @author haipadev
     * @reason Make hunger shake actually happen like in vanilla - hunger below 0 ?
     */
    @Redirect(method = "generateBarOffsets", at=@At(value= "INVOKE",target = "Lnet/minecraft/entity/player/HungerManager;getSaturationLevel()F"))
    private float starvationsaturated$ignoreShakeCheckForSaturation(HungerManager hungerManager) {
        return hungerManager.getFoodLevel();
    }
}
