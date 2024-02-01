package haipadev.starvationsaturated.mixin;

import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Item.Settings.class)
public class ItemSettingsMixin {
    /// ONLY WORKS WITH RESTART SINCE ITS ON REGISTRATION OF THE ITEM
//    @Inject(method = "food", at = @At(value = "RETURN"))
//    private void starvationsaturated$overrideFoodStackSize(FoodComponent foodComponent, CallbackInfoReturnable<Item.Settings> cir) {
//        if(ModConfigHelper.INSTANCE!=null && HungerManagerHelper.INSTANCE.getDifficulty()!=null) {
//            if (ModConfigHelper.INSTANCE.getFoodStackSizeOverride(HungerManagerHelper.INSTANCE.getDifficulty()) > 0) {
//                if (foodComponent != null) {
//                    ((ItemSettingsAccessor) this).setMaxCount(ModConfigHelper.INSTANCE.getFoodStackSizeOverride(HungerManagerHelper.INSTANCE.getDifficulty()));
//                }
//            }
//        }
//    }
}
