package haipadev.starvationsaturated.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Item.class)
public abstract class ItemMixin {
//    protected ItemMixin(int maxCount) {
//        this.maxCount = maxCount;
//    }

    @Shadow
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        return null;
    }

    @Inject(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/TypedActionResult;consume(Ljava/lang/Object;)Lnet/minecraft/util/TypedActionResult;"),allow=1)
    private void starvationsaturated$overrideConsume(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir){
        if(ModConfigHelper.INSTANCE.getIsFoodInstaUse(HungerManagerHelper.INSTANCE.getDifficulty())){finishUsing(user.getStackInHand(hand),world,user);}
    }
    @ModifyExpressionValue(method = "getMaxUseTime", at = @At(value = "CONSTANT", args = "intValue=32"))
    private int starvationsaturated$overrideConsumeDefaultTime(int original){
        return ModConfigHelper.INSTANCE.getConsumeDefaultTime(HungerManagerHelper.INSTANCE.getDifficulty());
    }
    @ModifyExpressionValue(method = "getMaxUseTime", at = @At(value = "CONSTANT", args = "intValue=16"))
    private int starvationsaturated$overrideConsumeSnackTime(int original){
        return ModConfigHelper.INSTANCE.getConsumeSnackTime(HungerManagerHelper.INSTANCE.getDifficulty());
    }

    @Shadow
    public FoodComponent getFoodComponent() {
        return null;
    }
    @Shadow public Item asItem(){
        return null;
    }

//    @Unique
//    private int getMaxCountAccessor(Item item){
//        return ((ItemAccessor)item).getMaxCount();
//    }

    /**
     * @author HaipaDev
     * @reason Override food stack sizes when configured
     */
//    @Overwrite
//    public final int getMaxCount(){
//        if(getFoodComponent()!=null) {
//            if(ModConfigHelper.INSTANCE!=null && HungerManagerHelper.INSTANCE.getDifficulty()!=null) {
//                if (ModConfigHelper.INSTANCE.getFoodStackSizeOverride(HungerManagerHelper.INSTANCE.getDifficulty()) > 0) {
//                    return ModConfigHelper.INSTANCE.getFoodStackSizeOverride(HungerManagerHelper.INSTANCE.getDifficulty());
//                }
//            }
//        }
//        return ((ItemAccessor)asItem()).getMaxCount();
//    }
//    @Inject(method = "getMaxCount", at=@At("HEAD"))
//    public final void getMaxCount(CallbackInfoReturnable<Integer> cir){
//        if(getFoodComponent()!=null) {
//            return 0;
//        }
//        return getMaxCountAccessor(item);
//    }
//    @Shadow
//    public boolean isFood() {
//        return false;
//    }
//    @Shadow
//    private final int maxCount;
//    @Redirect(method="getMaxCount", at=@At("HEAD"))
//    public final int starvationsaturated$overrideGetMaxCount(CallbackInfoReturnable<Integer> cir){
//        return isFood() ? 1 : maxCount;
//    }
//    @Mixin(Item.Settings.class)
//    public static class SettingsMixin {
//        @ModifyArg(method = "maxCount", at = @At(value = "CONSTANT", args = "intValue=16"), index = 0)
//        private int starvationsaturated$overrideConsumeSnackTime(int original) {
//            return ModConfigHelper.INSTANCE.getConsumeSnackTime(HungerManagerHelper.INSTANCE.getDifficulty());
//        }
//    }
}