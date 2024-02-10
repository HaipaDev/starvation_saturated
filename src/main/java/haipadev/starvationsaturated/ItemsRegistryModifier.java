package haipadev.starvationsaturated;

import haipadev.starvationsaturated.ModConfigOwo;
import haipadev.starvationsaturated.api.ModifiedItemValues;
import haipadev.starvationsaturated.api.ModifiedItemValuesMap;
import haipadev.starvationsaturated.mixin.ItemAccessor;
import haipadev.starvationsaturated.api.ItemValues;
import haipadev.starvationsaturated.api.ItemValuesMap;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ItemsRegistryModifier {
    public ItemsRegistryModifier() {
    }

    public static ItemsRegistryModifier INSTANCE;
    public static final ItemValuesMap foodItemsValuesMap = new ItemValuesMap();
    public static ModifiedItemValuesMap modifiedItemValuesMap = new ModifiedItemValuesMap();

    public static void init() {
        if (INSTANCE == null) {
            INSTANCE = new ItemsRegistryModifier();
        }
        iterateMinecraftRegistry();
        System.out.println("Food Item Values Map setup.");
    }

    public static void iterateMinecraftRegistry() {
        for (Identifier itemId : Registries.ITEM.getIds()) {
            Item item = Registries.ITEM.get(itemId);
            if(item.isFood()){
                foodItemsValuesMap.addItemValues(itemId,item.getMaxCount());
                modifiedItemValuesMap.addItemValues(itemId,item.getMaxCount());
            }
        }
    }

    public static void iterateRegisteredItems() {
        for (Map.Entry<Identifier, ItemValues> entry : foodItemsValuesMap.getAllItemValues().entrySet()) {
            Identifier itemId = entry.getKey();
            Item item = Registries.ITEM.get(itemId);
            ItemValues foodItemsValues = entry.getValue();
            System.out.println("Item: "+item.getTranslationKey()+" | Modified Stack Size: " + foodItemsValues.getModifiedStackSize());
            ((ItemAccessor) item).setMaxCount(foodItemsValues.getModifiedStackSize());
        }
    }

    public static void applyModifiedValuesToMap() {
        for (Map.Entry<Identifier, ModifiedItemValues> entry : modifiedItemValuesMap.getAllItemValues().entrySet()) {
            Identifier itemId=entry.getKey();
            ModifiedItemValues modifiedItemValues = entry.getValue();
            ItemValues itemValues = foodItemsValuesMap.getItemValues(itemId);
            itemValues.setModifiedStackSize(modifiedItemValues.modifiedStackSize());
        }
//        StarvationSaturated.CONFIG.subscribeToItemValues();
    }

    public static ModifiedItemValuesMap SetModifiedFoodItemsValuesMap(ModifiedItemValuesMap valuesMap) {
        modifiedItemValuesMap=valuesMap;
        return modifiedItemValuesMap;
    }

    public static ModifiedItemValuesMap SetModifiedFoodItemsValuesInitialMCRegistry() {
        iterateMinecraftRegistry();
        return modifiedItemValuesMap;
    }

    public static ModifiedItemValuesMap GetModifiedFoodItemsValuesMap(ModifiedItemValuesMap valuesMap) {
        return modifiedItemValuesMap;
    }
}