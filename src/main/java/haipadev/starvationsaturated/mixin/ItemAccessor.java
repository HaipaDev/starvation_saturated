package haipadev.starvationsaturated.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = Item.class,remap=false)
public interface ItemAccessor {
    @Accessor
    int getMaxCount();
    @Accessor
    abstract void setMaxCount(int i);
}
