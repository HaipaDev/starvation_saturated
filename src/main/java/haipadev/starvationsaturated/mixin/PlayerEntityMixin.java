package haipadev.starvationsaturated.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import haipadev.starvationsaturated.ModConfig;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    /**
     * @author haipadev
     * @reason Ignore check for regenerating hunger in peaceful
     */
    @ModifyExpressionValue(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getDifficulty()Lnet/minecraft/world/Difficulty;"),allow=1)
    private Difficulty starvationsaturated$peacefulCheck(Difficulty original) {
        if(original==Difficulty.PEACEFUL && ModConfig.INSTANCE.enablePeacefulHunger){return Difficulty.NORMAL;}
        return original;
    }
    /**
     * @author haipadev
     * @reason Configure how much exhaustion sprinting takes
     */
    @ModifyExpressionValue(method = "increaseTravelMotionStats", at = @At(value = "CONSTANT", args = "floatValue=0.1F"), slice=@Slice(
      from=@At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;isSprinting()Z", ordinal = 0)
    ))
    private float starvationsaturated$exhaustionForSprint(float original){
        return ModConfigHelper.INSTANCE.getSprintExhaustion(HungerManagerHelper.INSTANCE.getDifficulty());
    }
    /**
     * @author haipadev
     * @reason Configure how much exhaustion sprint jumping takes
     */
    @ModifyExpressionValue(method = "jump", at = @At(value = "CONSTANT", args = "floatValue=0.2F"))
    private float starvationsaturated$exhaustionForSprintJumping(float original){
        return ModConfigHelper.INSTANCE.getSprintJumpExhaustion(HungerManagerHelper.INSTANCE.getDifficulty());
    }
    /**
     * @author haipadev
     * @reason Configure how much exhaustion jumping takes
     */
    @ModifyExpressionValue(method = "jump", at = @At(value = "CONSTANT", args = "floatValue=0.05F"))
    private float starvationsaturated$exhaustionForJumping(float original){
        return ModConfigHelper.INSTANCE.getJumpExhaustion(HungerManagerHelper.INSTANCE.getDifficulty());
    }
}
