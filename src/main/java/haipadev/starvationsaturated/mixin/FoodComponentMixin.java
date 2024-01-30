package haipadev.starvationsaturated.mixin;

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
    public boolean isAlwaysEdible(){return true;}
    /**
     * @author haipadev
     * @reason Make foods quicker to eat
     */
    @Overwrite
    public boolean isSnack(){return true;}
}