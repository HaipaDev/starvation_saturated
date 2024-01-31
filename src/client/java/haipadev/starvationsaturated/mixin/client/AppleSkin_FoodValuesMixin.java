package haipadev.starvationsaturated.mixin.client;

import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import squeek.appleskin.api.food.FoodValues;
import squeek.appleskin.client.TooltipOverlayHandler;

@Mixin(value=FoodValues.class,remap=false)
public class AppleSkin_FoodValuesMixin {
    @Shadow
    public float saturationModifier;
    /**
     * @author HaipaDev
     * @reason To align with the new hunger system of not being capped by hunger and not acting as a multiplier
     */
    @Overwrite
    public float getSaturationIncrement() {
        return saturationModifier;
    }
}