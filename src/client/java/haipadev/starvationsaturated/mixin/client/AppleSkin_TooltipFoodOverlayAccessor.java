package haipadev.starvationsaturated.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import squeek.appleskin.client.TooltipOverlayHandler.FoodOverlay;

@Mixin(value=FoodOverlay.class,remap=false)
public interface AppleSkin_TooltipFoodOverlayAccessor {
//    @Invoker boolean callShouldRenderHungerBars();
    @Accessor int getHungerBars();
}
