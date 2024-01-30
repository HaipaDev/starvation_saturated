package haipadev.starvationsaturated;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import org.spongepowered.asm.mixin.Unique;

@Config(name = "starvationsaturated")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static haipadev.starvationsaturated.ModConfig INSTANCE;

    public static void init() {
        AutoConfig.register(haipadev.starvationsaturated.ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(haipadev.starvationsaturated.ModConfig.class).getConfig();
    }

    @ConfigEntry.Gui.Tooltip()
    @Comment("The amount of hunger you start with on respawn")
    public int hungerStart = 20;
    @ConfigEntry.Gui.Tooltip()
    @Comment("The amount of saturation you start with on respawn")
    public int saturationStart = 0;

    @ConfigEntry.Gui.Tooltip()
    @Comment("The max amount of hunger you can have after eating")
    public int hungerCapOnAdd = 20;
    @ConfigEntry.Gui.Tooltip()
    @Comment("The overall max amount of saturation you can have after eating")
    public int saturationCapOnAdd = 20;
    @ConfigEntry.Gui.Tooltip()
    @Comment("Vanilla behaviour of capping saturation to hunger")
    public boolean capSaturationToHunger = false;

    @ConfigEntry.Gui.Tooltip()
    @Comment("If true, saturation is capped to the difference of player health (maxHealth - currentHealth), overrides previous settings")
    public boolean capSaturationToMissingHealth = true;

    @ConfigEntry.Gui.Tooltip()
    @Comment("An override cap, letting saturation go above the difference of player health")
    public float capSaturationToMissingHealthOverride = 0;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Hunger level for slow regen (99 is 'basically off', vanilla is 18)")
    public int hungerSlowRegenOverride = 99;

    @ConfigEntry.Gui.Tooltip()
    @Comment("Hunger level for fast regen (1 so its not gonna weirdly heal you with leftover saturation, vanilla is 20)")
    public int hungerFastRegenOverride = 1;

    @ConfigEntry.Gui.CollapsibleObject
    public PeacefulHugerValues peacefulHugerValues=new PeacefulHugerValues();
    public static class PeacefulHugerValues {// extends DifficultyHungerValues {
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of ticks it takes to fast-heal, 0 means instant (vanilla is 10)")
        public int saturationHealRate = 0;
        @ConfigEntry.Gui.Tooltip()
        @Comment("('Try') Take saturation only when healing, other actions take hunger")
        public boolean tryTakeSaturationOnlyWhenHealing = true;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Skip check for PEACEFUL that gives free hunger regeneration")
        public boolean enablePeacefulHunger = true;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How much starvation dmg to deal")
        public int starveDamage = 1;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How fast starvation dmg occurs")
        public int starveDamageRate = 80;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How low should you get before starvation stops taking effect")
        public int dealStarveDamageTill = 1;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public EasyHugerValues easyHugerValues=new EasyHugerValues();
    public static class EasyHugerValues {
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of ticks it takes to fast-heal, 0 means instant (vanilla is 10)")
        public int saturationHealRate = 0;
        @ConfigEntry.Gui.Tooltip()
        @Comment("('Try') Take saturation only when healing, other actions take hunger")
        public boolean tryTakeSaturationOnlyWhenHealing = true;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How much starvation dmg to deal")
        public int starveDamage = 2;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How fast starvation dmg occurs")
        public int starveDamageRate = 80;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How low should you get before starvation stops taking effect (vanilla is 10)")
        public int dealStarveDamageTill = 0;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public NormalHugerValues normalHugerValues=new NormalHugerValues();
    public static class NormalHugerValues {
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of ticks it takes to fast-heal, 0 means instant (vanilla is 10)")
        public int saturationHealRate = 0;
        @ConfigEntry.Gui.Tooltip()
        @Comment("('Try') Take saturation only when healing, other actions take hunger")
        public boolean tryTakeSaturationOnlyWhenHealing = true;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How much starvation dmg to deal")
        public int starveDamage = 3;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How fast starvation dmg occurs")
        public int starveDamageRate = 80;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How low should you get before starvation stops taking effect (vanilla is 1)")
        public int dealStarveDamageTill = 0;
    }

    @ConfigEntry.Gui.CollapsibleObject
    public HardHungerValues hardHungerValues=new HardHungerValues();
    public static class HardHungerValues {
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of ticks it takes to fast-heal, 0 means instant (vanilla is 10)")
        public int saturationHealRate = 0;
        @ConfigEntry.Gui.Tooltip()
        @Comment("('Try') Take saturation only when healing, other actions take hunger")
        public boolean tryTakeSaturationOnlyWhenHealing = true;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How much starvation dmg to deal")
        public int starveDamage = 4;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How fast starvation dmg occurs")
        public int starveDamageRate = 80;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How low should you get before starvation stops taking effect")
        public int dealStarveDamageTill = 0;
    }
}