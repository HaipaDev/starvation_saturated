package haipadev.starvationsaturated.api;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ItemValuesMap {
    private final Map<Identifier, ItemValues> itemValuesMap = new HashMap<>();

    public void addItemValues(Identifier itemId, int unmodifiedStackSize) {
        ItemValues itemValues = new ItemValues(unmodifiedStackSize);
        itemValuesMap.put(itemId, itemValues);
    }

    public ItemValues getItemValues(Identifier itemId) {
        return itemValuesMap.get(itemId);
    }

    public Map<Identifier, ItemValues> getAllItemValues() {
        System.out.println("Food Item Values Map length: " + itemValuesMap.size());
        return itemValuesMap;
    }
}