package haipadev.starvationsaturated.api;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ModifiedItemValuesMap {
    private final Map<Identifier, ModifiedItemValues> itemValuesMap;

    public ModifiedItemValuesMap(Map<Identifier, ModifiedItemValues> itemValuesMap) {
        this.itemValuesMap = new HashMap<>(itemValuesMap);
    }

    public ModifiedItemValuesMap() {
        this.itemValuesMap = new HashMap<>();
    }

    public void addItemValues(Identifier itemId, int modifiedStackSize) {
        ModifiedItemValues itemValues = new ModifiedItemValues(modifiedStackSize);
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