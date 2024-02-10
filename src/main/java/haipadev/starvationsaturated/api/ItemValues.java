package haipadev.starvationsaturated.api;

import net.minecraft.item.Item;

public class ItemValues {
    private final int unmodifiedStackSize;
    private int modifiedStackSize;

    public ItemValues(int unmodifiedStackSize) {
        this.unmodifiedStackSize = unmodifiedStackSize;
        this.modifiedStackSize = unmodifiedStackSize;
    }

    public int getUnmodifiedStackSize() {
        return unmodifiedStackSize;
    }

    public int getModifiedStackSize() {
        return modifiedStackSize;
    }

    public void setModifiedStackSize(int modifiedStackSize) {
        this.modifiedStackSize = modifiedStackSize;
    }
}

