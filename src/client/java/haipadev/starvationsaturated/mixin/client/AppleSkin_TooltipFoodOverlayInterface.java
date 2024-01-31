package haipadev.starvationsaturated.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import squeek.appleskin.client.TooltipOverlayHandler.FoodOverlay;

@Mixin(value=FoodOverlay.class,remap=false)
public interface AppleSkin_TooltipFoodOverlayInterface {
//    @Invoker boolean callShouldRenderHungerBars();
    @Accessor int getHungerBars();
}
