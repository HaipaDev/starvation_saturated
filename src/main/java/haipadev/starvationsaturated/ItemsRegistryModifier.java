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
        SetupDefaultModifications();
        applyModifiedValuesToMap();
        iterateFoodValuesMap();
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
    public static void SetupDefaultModifications(){
        SetModifiedFoodItemValues("minecraft:potato",1);
    }

    public static void iterateFoodValuesMap() {
        for (Map.Entry<Identifier, ItemValues> entry : foodItemsValuesMap.getAllItemValues().entrySet()) {
            Identifier itemId = entry.getKey();
            Item item = Registries.ITEM.get(itemId);
            ItemValues foodItemsValues = entry.getValue();
            System.out.println(itemId+" | Modified Stack Size: " + foodItemsValues.getModifiedStackSize());
            ((ItemAccessor) item).setMaxCount(foodItemsValues.getModifiedStackSize());
        }
    }

    public static void applyModifiedValuesFromConfig() {
        if(StarvationSaturated.CONFIG.itemValues()!=null){
            if(!StarvationSaturated.CONFIG.itemValues().isEmpty()){
                System.out.println("SETTING MODIFIED FOOD VALUES MAP FROM CONFIG");
                modifiedItemValuesMap = new ModifiedItemValuesMap(StarvationSaturated.CONFIG.itemValues());
            }
        }
        applyModifiedValuesToMap();
        iterateFoodValuesMap();
    }
    public static void applyModifiedValuesToMap() {
        for (Map.Entry<Identifier, ModifiedItemValues> entry : modifiedItemValuesMap.getAllItemValues().entrySet()) {
            Identifier itemId=entry.getKey();
            ModifiedItemValues modifiedItemValues = entry.getValue();
            ItemValues itemValues = foodItemsValuesMap.getItemValues(itemId);
            itemValues.setModifiedStackSize(modifiedItemValues.modifiedStackSize());
        }
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
    public static void SetModifiedFoodItemValues(String id, int stackSize){
        if(modifiedItemValuesMap.getItemValues(Identifier.of(id.split(":")[0],id.split(":")[1]))!=null){
            modifiedItemValuesMap.getItemValues(Identifier.of(id.split(":")[0],id.split(":")[1])).setModifiedStackSize(stackSize);
        }else{
            modifiedItemValuesMap.addItemValues(Identifier.of(id.split(":")[0],id.split(":")[1]),stackSize);
        }
    }
}