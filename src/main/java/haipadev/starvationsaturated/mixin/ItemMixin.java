package haipadev.starvationsaturated.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Item.class)
public abstract class ItemMixin {
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
}