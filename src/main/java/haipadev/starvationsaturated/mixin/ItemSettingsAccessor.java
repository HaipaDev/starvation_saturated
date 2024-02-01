package haipadev.starvationsaturated.mixin;

import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import squeek.appleskin.client.TooltipOverlayHandler;

@Mixin(value = Item.Settings.class,remap=false)
public interface ItemSettingsAccessor {
    @Accessor
    int getMaxCount();
    @Accessor
    abstract void setMaxCount(int i);
}
