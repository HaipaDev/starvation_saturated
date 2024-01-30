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
    @Comment("Skip check for PEACEFUL that gives free hunger regeneration")
    public boolean enablePeacefulHunger = true;
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues peacefulHugerValues = new DifficultyBasedHungerValues(
            true,
            true,
            20,
            5,
            20,
            20,
            false,
            true,
            0,
            0,
            true,
            99,
            1,
            1,
            80,
            1
    );
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues easyHugerValues = new DifficultyBasedHungerValues(
            true,
            true,
            20,
            5,
            20,
            20,
            false,
            true,
            0,
            0,
            true,
            99,
            1,
            2,
            80,
            1
    );
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues normalHugerValues = new DifficultyBasedHungerValues(
            true,
            true,
            20,
            0,
            20,
            20,
            false,
            true,
            0,
            0,
            true,
            99,
            1,
            3,
            80,
            1
    );
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues hardHungerValues = new DifficultyBasedHungerValues(
            true,
            true,
            18,
            0,
            20,
            20,
            false,
            true,
            0,
            0,
            true,
            99,
            1,
            4,
            80,
            1
    );

    public static class DifficultyBasedHungerValues {
        @ConfigEntry.Gui.Tooltip()
        @Comment("Makes food always edible")
        public boolean isFoodAlwaysEdible = true;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Makes food faster to eat")
        public boolean isFoodSnack = true;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of hunger you start with on respawn")
        public int hungerStart = 20;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of saturation you start with on respawn")
        public float saturationStart;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The max amount of hunger you can have after eating")
        public int hungerCapOnAdd;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The overall max amount of saturation you can have after eating")
        public float saturationCapOnAdd;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Vanilla behaviour of capping saturation to hunger")
        public boolean capSaturationToHunger;

        @ConfigEntry.Gui.Tooltip()
        @Comment("If true, saturation is capped to the difference of player health (maxHealth - currentHealth), overrides previous settings")
        public boolean capSaturationToMissingHealth;
        @ConfigEntry.Gui.Tooltip()
        @Comment("An override cap, letting saturation go above the difference of player health")
        public float capSaturationToMissingHealthOverride;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of ticks it takes to fast-heal, 0 means instant (vanilla is 10)")
        public int saturationHealRate;
        @ConfigEntry.Gui.Tooltip()
        @Comment("('Try') Take saturation only when healing, other actions take hunger")
        public boolean tryTakeSaturationOnlyWhenHealing;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Hunger level for slow regen (99 is 'basically off', vanilla is 18)")
        public int hungerSlowRegenOverride;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Hunger level for fast regen (1 so its not gonna weirdly heal you with leftover saturation, vanilla is 20)")
        public int hungerFastRegenOverride;

        @ConfigEntry.Gui.Tooltip()
        @Comment("How much starvation damage to deal")
        public int starveDamage;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How fast starvation damage occurs")
        public int starveDamageRate;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How low should you get before starvation stops taking effect")
        public int dealStarveDamageTill;

        public DifficultyBasedHungerValues(
                boolean isFoodAlwaysEdible,
                boolean isFoodSnack,
                int hungerStart,
                float saturationStart,
                int hungerCapOnAdd,
                float saturationCapOnAdd,
                boolean capSaturationToHunger,
                boolean capSaturationToMissingHealth,
                int capSaturationToMissingHealthOverride,
                int saturationHealRate,
                boolean tryTakeSaturationOnlyWhenHealing,
                int hungerSlowRegenOverride,
                int hungerFastRegenOverride,
                int starveDamage,
                int starveDamageRate,
                int dealStarveDamageTill
        ) {
            this.isFoodAlwaysEdible = isFoodAlwaysEdible;
            this.isFoodSnack = isFoodSnack;
            this.hungerStart = hungerStart;
            this.saturationStart = saturationStart;
            this.hungerCapOnAdd = hungerCapOnAdd;
            this.saturationCapOnAdd = saturationCapOnAdd;
            this.capSaturationToHunger = capSaturationToHunger;
            this.capSaturationToMissingHealth = capSaturationToMissingHealth;
            this.capSaturationToMissingHealthOverride = capSaturationToMissingHealthOverride;
            this.saturationHealRate = saturationHealRate;
            this.tryTakeSaturationOnlyWhenHealing = tryTakeSaturationOnlyWhenHealing;
            this.hungerSlowRegenOverride = hungerSlowRegenOverride;
            this.hungerFastRegenOverride = hungerFastRegenOverride;
            this.starveDamage = starveDamage;
            this.starveDamageRate = starveDamageRate;
            this.dealStarveDamageTill = dealStarveDamageTill;
        }
    }
}