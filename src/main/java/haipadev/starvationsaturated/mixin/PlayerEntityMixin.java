package haipadev.starvationsaturated.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import haipadev.starvationsaturated.ModConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Debug(export = true)
@Mixin(value= PlayerEntity.class,remap=false)
public abstract class PlayerEntityMixin {
    /**
     * @author haipadev
     * @reason Ignore check for regenerating hunger in peaceful
     */
    @ModifyExpressionValue(method = "tickMovement", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getDifficulty()Lnet/minecraft/world/Difficulty;"),allow=1)
    private Difficulty starvationsaturated$peacefulCheck(Difficulty original) {
        if(original==Difficulty.PEACEFUL && ModConfig.INSTANCE.peacefulHugerValues.enablePeacefulHunger){return Difficulty.NORMAL;}
        return original;
    }
}
