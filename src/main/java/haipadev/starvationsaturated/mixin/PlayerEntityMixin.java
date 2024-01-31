package haipadev.starvationsaturated.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import haipadev.starvationsaturated.ModConfig;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value= PlayerEntity.class,remap=false)
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
}
