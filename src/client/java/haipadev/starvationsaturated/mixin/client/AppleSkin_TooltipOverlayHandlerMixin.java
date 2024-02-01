package haipadev.starvationsaturated.mixin.client;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;

import squeek.appleskin.client.TooltipOverlayHandler;

@Mixin(value=TooltipOverlayHandler.class,remap=false)
public class AppleSkin_TooltipOverlayHandlerMixin {
    /**
     * @author HaipaDev
     * @reason Shift saturation back up when it is the only bar visible
     */
    @ModifyVariable(method = "onRenderTooltip", at = @At(value = "INVOKE", target = "Lsqueek/appleskin/api/food/FoodValues;getSaturationIncrement()F"), ordinal=4, allow=1)
    private int modifyYPosition(int y, DrawContext context, TooltipOverlayHandler.FoodOverlay foodOverlay, int toolTipX, int toolTipY, int tooltipZ, TextRenderer textRenderer) {
        if (getHungerBars(foodOverlay)<=0) {
            return y - 10;
        }
        return y;
//        if (!callShouldRenderHungerBars(foodOverlay)) {
//            return y;
//        }
//        return y-10;
    }
    @Unique
    private int getHungerBars(TooltipOverlayHandler.FoodOverlay foodOverlay){
        return ((AppleSkin_TooltipFoodOverlayAccessor)foodOverlay).getHungerBars();
    }
//    @Unique
//    private boolean callShouldRenderHungerBars(TooltipOverlayHandler.FoodOverlay foodOverlay){
//        return ((AppleSkin_TooltipFoodOverlayInterface)foodOverlay).callShouldRenderHungerBars();
//    }
}