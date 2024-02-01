package haipadev.starvationsaturated.mixin;

import haipadev.starvationsaturated.ModConfig;
import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.minecraft.item.FoodComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoodComponent.class)
public class FoodComponentMixin {
    @Shadow
    private boolean alwaysEdible;
    @Shadow
    private boolean snack;
    /**
     * @author haipadev
     * @reason Make foods always edible
     */
    @Overwrite
    public boolean isAlwaysEdible(){
        if(ModConfigHelper.INSTANCE.getIsFoodAlwaysEdible(HungerManagerHelper.INSTANCE.getDifficulty())){return true;}
        return alwaysEdible;
    }
    /**
     * @author haipadev
     * @reason Make foods quicker to eat
     */
    @Overwrite
    public boolean isSnack(){
        if(ModConfigHelper.INSTANCE.getIsFoodSnack(HungerManagerHelper.INSTANCE.getDifficulty())){return true;}
        return snack;
    }
}