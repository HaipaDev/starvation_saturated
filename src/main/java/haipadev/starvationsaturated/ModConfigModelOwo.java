package haipadev.starvationsaturated;

import blue.endless.jankson.Comment;
import haipadev.starvationsaturated.api.ItemValues;
import haipadev.starvationsaturated.api.ModifiedItemValues;
import haipadev.starvationsaturated.api.ModifiedItemValuesMap;
import io.wispforest.owo.config.annotation.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

//@Modmenu(modId = "starvationsaturated")
//@Modmenu(modId = "starvationsaturated", uiModelId = "starvationsaturated:my_ui_model")
@Config(name = "starvationsaturated", wrapperName = "ModConfigOwo")
public class ModConfigModelOwo {
    @Comment("test")
    public int anIntOption = 16;
    public boolean aBooleanToggle = false;
    @SectionHeader("test2")
    public Choices anEnumOption = Choices.ANOTHER_CHOICE;

    public enum Choices {
        A_CHOICE, ANOTHER_CHOICE;
    }

    @Nest
    public ThisIsNested nestedObject = new ThisIsNested();
    @SectionHeader("itemValues")
    @Hook
    public Map<Identifier, ModifiedItemValues> itemValues=null;// = ItemsRegistryModifier.foodItemsValuesMap.getAllItemValues();

    public static class ThisIsNested {
        public boolean aNestedValue = false;
        public int anotherNestedValue = 42;
    }
}
