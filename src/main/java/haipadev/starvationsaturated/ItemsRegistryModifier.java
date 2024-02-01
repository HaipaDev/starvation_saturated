package haipadev.starvationsaturated;

import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import haipadev.starvationsaturated.mixin.ItemAccessor;
import haipadev.starvationsaturated.api.ItemValues;
import haipadev.starvationsaturated.api.ItemValuesMap;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class ItemsRegistryModifier {
    private static final ItemValuesMap foodItemsValuesMap = new ItemValuesMap();
    public static void init() {
        for (Identifier itemId : Registries.ITEM.getIds()) {
            Item item = Registries.ITEM.get(itemId);
            if (item.isFood()) {
                int unmodifiedStackSize = item.getMaxCount();
                foodItemsValuesMap.addItem(item, unmodifiedStackSize);
            }
        }
    }
    public static void iterateRegisteredItems() {
        for(Identifier itemId : Registries.ITEM.getIds()) {
            Item item = Registries.ITEM.get(itemId);
            if(item.isFood()){
                ItemValues itemValues = foodItemsValuesMap.getItemValues(item);
                if (itemValues != null) {
                    int stackSize=64;
                    if (ModConfigHelper.INSTANCE!=null && HungerManagerHelper.INSTANCE.getDifficulty()!=null &&
                            ModConfigHelper.INSTANCE.getFoodStackSizeOverride(HungerManagerHelper.INSTANCE.getDifficulty()) > 0) {
                        stackSize=ModConfigHelper.INSTANCE.getFoodStackSizeOverride(HungerManagerHelper.INSTANCE.getDifficulty());
                        itemValues.setModifiedStackSize(stackSize);
                    }else{
                        stackSize=itemValues.getUnmodifiedStackSize();
                    }
                    ((ItemAccessor)item).setMaxCount(stackSize);
//                    System.out.println("default: "+itemValues.getUnmodifiedStackSize()+" | cur: "+stackSize);
                }
            }
        }
    }
}
