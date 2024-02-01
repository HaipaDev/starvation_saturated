package haipadev.starvationsaturated.api;

import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemValuesMap {
    private final Map<Item, ItemValues> itemValuesMap = new HashMap<>();

    public void addItem(Item item, int unmodifiedStackSize) {
        ItemValues itemValues = new ItemValues(item, unmodifiedStackSize);
        itemValuesMap.put(item, itemValues);
    }

    public ItemValues getItemValues(Item item) {
        return itemValuesMap.get(item);
    }

    public Map<Item, ItemValues> getAllItemValues() {
        return itemValuesMap;
    }
}