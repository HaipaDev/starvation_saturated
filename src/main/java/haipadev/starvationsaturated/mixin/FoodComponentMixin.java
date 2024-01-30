package haipadev.starvationsaturated.mixin;

import haipadev.starvationsaturated.ModConfig;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.item.FoodComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(FoodComponent.class)
public class FoodComponentMixin {
    /**
     * @author haipadev
     * @reason Make foods always edible
     */
    @Overwrite
    public boolean isAlwaysEdible(){return ModConfigHelper.INSTANCE.getIsFoodAlwaysEdible(HungerManagerHelper.INSTANCE.getDifficulty());}
    /**
     * @author haipadev
     * @reason Make foods quicker to eat
     */
    @Overwrite
    public boolean isSnack(){return ModConfigHelper.INSTANCE.getIsFoodSnack(HungerManagerHelper.INSTANCE.getDifficulty());}
}