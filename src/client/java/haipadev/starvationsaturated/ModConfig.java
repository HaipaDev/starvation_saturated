package haipadev.starvationsaturated;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "starvationsaturated")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static haipadev.starvationsaturated.ModConfig INSTANCE;

    public static void init() {
        AutoConfig.register(haipadev.starvationsaturated.ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(haipadev.starvationsaturated.ModConfig.class).getConfig();
    }

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, saturation is capped to the difference of player health (maxHealth - currentHealth)")
    public boolean test = true;
}
