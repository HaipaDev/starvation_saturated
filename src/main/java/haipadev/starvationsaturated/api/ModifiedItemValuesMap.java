package haipadev.starvationsaturated.api;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModifiedItemValuesMap {
    private final Map<Identifier, ModifiedItemValues> itemValuesMap = new HashMap<>();

    public void addItemValues(Identifier itemId, int unmodifiedStackSize) {
        ModifiedItemValues itemValues = new ModifiedItemValues(unmodifiedStackSize);
        itemValuesMap.put(itemId, itemValues);
    }

    public ModifiedItemValues getItemValues(Identifier itemId) {
        return itemValuesMap.get(itemId);
    }

    public Map<Identifier, ModifiedItemValues> getAllItemValues() {
        System.out.println("Food Item Values Map length: " + itemValuesMap.size());
        return itemValuesMap;
    }
}