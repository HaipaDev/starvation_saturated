package haipadev.starvationsaturated.api;

import net.minecraft.item.Item;

public class ItemValues {
    private final Item item;
    private final int unmodifiedStackSize;
    private int modifiedStackSize;

    public ItemValues(Item item, int unmodifiedStackSize) {
        this.item = item;
        this.unmodifiedStackSize = unmodifiedStackSize;
        this.modifiedStackSize = unmodifiedStackSize;
    }

    public Item getItem() {
        return item;
    }

    public int getUnmodifiedStackSize() {
        return unmodifiedStackSize;
    }

    public int getModifiedStackSize() {
        return unmodifiedStackSize;
    }

    public void setModifiedStackSize(int modifiedStackSize) {
        this.modifiedStackSize = modifiedStackSize;
    }
}