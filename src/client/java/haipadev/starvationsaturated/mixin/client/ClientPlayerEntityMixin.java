package haipadev.starvationsaturated.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.authlib.GameProfile;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value=ClientPlayerEntity.class)
public class ClientPlayerEntityMixin extends AbstractClientPlayerEntity {
    public ClientPlayerEntityMixin(ClientWorld world, GameProfile profile) {
        super(world, profile);
    }

    /**
     * @author haipadev
     * @reason Configure when sprinting is allowed
     */
    @ModifyExpressionValue(method="canSprint",at= @At(value = "CONSTANT", args = "floatValue=6.0F"))
    private float starvationsaturated$overrideHungerForSprint(float original){
        return (getHungerManager().getSaturationLevel() >= ModConfigHelper.INSTANCE.getSaturationForSprint(HungerManagerHelper.INSTANCE.getDifficulty())
                && getHungerManager().getFoodLevel() >= ModConfigHelper.INSTANCE.getHungerForSprint(HungerManagerHelper.INSTANCE.getDifficulty()))
        ? 0 : 99;
    }
}
