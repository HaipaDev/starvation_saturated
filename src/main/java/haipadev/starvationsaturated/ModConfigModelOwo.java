package haipadev.starvationsaturated;

import blue.endless.jankson.Comment;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Nest;
import io.wispforest.owo.config.annotation.SectionHeader;

//@Modmenu(modId = "starvationsaturated")
@Modmenu(modId = "starvationsaturated", uiModelId = "my_ui_model")
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

    public static class ThisIsNested {
        public boolean aNestedValue = false;
        public int anotherNestedValue = 42;
    }
}
