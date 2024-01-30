package haipadev.starvationsaturated.mixin.client;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import squeek.appleskin.api.event.FoodValuesEvent;
import squeek.appleskin.api.food.FoodValues;

@Mixin(value = FoodValuesEvent.class,remap=false)
public class AppleSkin_FoodValuesEventMixin {
    @Inject(method="<init>",at=@At("TAIL"))
    public void starvationsaturated$debug(PlayerEntity player, ItemStack itemStack, FoodValues defaultFoodValues, FoodValues modifiedFoodValues, CallbackInfo ci){
//        System.out.println("default: "+defaultFoodValues.saturationModifier);
//        System.out.println("modif: "+modifiedFoodValues.saturationModifier);
    }
}