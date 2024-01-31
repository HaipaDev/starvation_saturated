package haipadev.starvationsaturated.mixin.client;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import squeek.appleskin.api.food.FoodValues;
import squeek.appleskin.client.TooltipOverlayHandler;

@Mixin(value= TooltipOverlayHandler.FoodOverlay.class,remap=false)
public class AppleSkin_TooltipFoodOverlayMixin {
    @Inject(method = "shouldRenderHungerBars", at = @At("HEAD"), cancellable = true)
    private void starvationsaturated$modifyShouldRenderHungerBars(CallbackInfoReturnable<Boolean> ci){
        ci.setReturnValue(true);
    }
    @Shadow
    private int saturationBars;
    @Shadow
    private float biggestSaturationIncrement;
    @Shadow
    private String saturationBarsText;
    @Shadow
    private FoodValues defaultFood;
    @Shadow
    private FoodValues modifiedFood;


    @Shadow private int hungerBars;

    /**
     * @author HaipaDev
     * @reason Stop overriding override showing 1 saturation when it is 0
     */
    @Redirect(method = "<init>", at=@At(value="FIELD", target="Lsqueek/appleskin/client/TooltipOverlayHandler$FoodOverlay;saturationBars:I", ordinal=1, opcode = Opcodes.GETFIELD))
    private int starvationsaturated$saturationBarNotZero(TooltipOverlayHandler.FoodOverlay instance) {
        return 1;
    }

    /**
     * @author HaipaDev
     * @reason Hide empty saturation
     */
    @Inject(method = "<init>", at = @At("TAIL"))
    private void starvationsaturated$onFoodOverlayInit(ItemStack itemStack, FoodValues defaultFood, FoodValues modifiedFood, PlayerEntity player, CallbackInfo ci) {
//        System.out.println("defaultFood: "+defaultFood.getSaturationIncrement());
//        System.out.println("modifiedFood: "+modifiedFood.getSaturationIncrement());
//        System.out.println("saturationBars: "+saturationBars);
        if(this.saturationBars == 0){
            this.saturationBarsText = "";
        }
    }
    /**
     * @author HaipaDev
     * @reason When either saturation or hunger is hidden shrink the height to only 9+3
     */
    @Inject(method = "getHeight", at = @At("HEAD"), cancellable = true)
    public void starvationsaturated$getHeight(CallbackInfoReturnable<Integer> cir) {
        if(this.saturationBars==0 || this.hungerBars==0) {
            cir.setReturnValue(9+3);
        }
    }
}