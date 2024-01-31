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
    @Comment("Skip check for PEACEFUL that gives free hunger regeneration")
    public boolean enablePeacefulHunger = true;
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues peacefulHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(true)
            .hungerStart(20)
            .saturationStart(5)
            .hungerCapOnAdd(20)
            .saturationCapOnAdd(20)
            .capSaturationToHunger(false)
            .capSaturationToMissingHealth(false)
            .capSaturationToMissingHealthOverride(0)
            .hungerSlowRegenOverride(99)
            .hungerFastRegenOverride(1)
            .hungerSlowHealRate(80)
            .saturationFastHealRate(0)
            .tryTakeSaturationOnlyWhenHealing(true)
            .starveDamage(1)
            .starveDamageRate(80)
            .dealStarveDamageTill(1)
            .build();
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues easyHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(true)
            .hungerStart(20)
            .saturationStart(5)
            .hungerCapOnAdd(20)
            .saturationCapOnAdd(20)
            .capSaturationToHunger(false)
            .capSaturationToMissingHealth(true)
            .capSaturationToMissingHealthOverride(6)
            .hungerSlowRegenOverride(99)
            .hungerFastRegenOverride(1)
            .hungerSlowHealRate(80)
            .saturationFastHealRate(0)
            .tryTakeSaturationOnlyWhenHealing(true)
            .starveDamage(2)
            .starveDamageRate(80)
            .dealStarveDamageTill(0)
            .build();
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues normalHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(true)
            .hungerStart(20)
            .saturationStart(0)
            .hungerCapOnAdd(20)
            .saturationCapOnAdd(20)
            .capSaturationToHunger(false)
            .capSaturationToMissingHealth(true)
            .capSaturationToMissingHealthOverride(0)
            .hungerSlowRegenOverride(99)
            .hungerFastRegenOverride(1)
            .hungerSlowHealRate(80)
            .saturationFastHealRate(0)
            .tryTakeSaturationOnlyWhenHealing(true)
            .starveDamage(3)
            .starveDamageRate(80)
            .dealStarveDamageTill(0)
            .build();
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues hardHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(false)
            .hungerStart(18)
            .saturationStart(0)
            .hungerCapOnAdd(20)
            .saturationCapOnAdd(20)
            .capSaturationToHunger(false)
            .capSaturationToMissingHealth(true)
            .capSaturationToMissingHealthOverride(0)
            .hungerSlowRegenOverride(99)
            .hungerFastRegenOverride(1)
            .hungerSlowHealRate(80)
            .saturationFastHealRate(0)
            .tryTakeSaturationOnlyWhenHealing(true)
            .starveDamage(4)
            .starveDamageRate(80)
            .dealStarveDamageTill(0)
            .build();


    public static class DifficultyBasedHungerValues {
        @ConfigEntry.Gui.Tooltip()
        @Comment("Allows you to eat food even when full")
        public boolean isFoodAlwaysEdible;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Makes food faster to eat")
        public boolean isFoodSnack;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of hunger you start with on respawn")
        public int hungerStart;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of saturation you start with on respawn")
        public float saturationStart;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The overall max amount of hunger you can have (after eating, commands etc will override this)")
        public int hungerCapOnAdd;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The overall max amount of saturation you can have (after eating, commands etc will override this)")
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
        @Comment("Hunger level for slow regen [hunger based in vanilla] (99 is 'basically off', vanilla is 18)")
        public int hungerSlowRegenOverride;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Hunger level for fast regen [saturation based calculation] (1 so its not gonna weirdly heal you with leftover saturation, vanilla is 20)")
        public int hungerFastRegenOverride;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of ticks it takes to 'slow-heal', 0 means instant")
        public int hungerSlowHealRate;
        @ConfigEntry.Gui.Tooltip()
        @Comment("The amount of ticks it takes to 'fast-heal', 0 means instant")
        public int saturationFastHealRate;
        @ConfigEntry.Gui.Tooltip()
        @Comment("('Try') Take saturation only when healing, other actions take hunger")
        public boolean tryTakeSaturationOnlyWhenHealing;

        @ConfigEntry.Gui.Tooltip()
        @Comment("How much starvation damage to deal")
        public int starveDamage;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How fast starvation damage occurs")
        public int starveDamageRate;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How low should you get before starvation stops taking effect")
        public int dealStarveDamageTill;

        private DifficultyBasedHungerValues() {}

        // Builder class
        public static class Builder {
            private DifficultyBasedHungerValues values;

            public Builder() {
                this.values = new DifficultyBasedHungerValues();
            }

            public Builder isFoodAlwaysEdible(boolean isFoodAlwaysEdible) {
                values.isFoodAlwaysEdible = isFoodAlwaysEdible;
                return this;
            }

            public Builder isFoodSnack(boolean isFoodSnack) {
                values.isFoodSnack = isFoodSnack;
                return this;
            }

            public Builder hungerStart(int hungerStart) {
                values.hungerStart = hungerStart;
                return this;
            }

            public Builder saturationStart(float saturationStart) {
                values.saturationStart = saturationStart;
                return this;
            }

            public Builder hungerCapOnAdd(int hungerCapOnAdd) {
                values.hungerCapOnAdd = hungerCapOnAdd;
                return this;
            }

            public Builder saturationCapOnAdd(float saturationCapOnAdd) {
                values.saturationCapOnAdd = saturationCapOnAdd;
                return this;
            }

            public Builder capSaturationToHunger(boolean capSaturationToHunger) {
                values.capSaturationToHunger = capSaturationToHunger;
                return this;
            }

            public Builder capSaturationToMissingHealth(boolean capSaturationToMissingHealth) {
                values.capSaturationToMissingHealth = capSaturationToMissingHealth;
                return this;
            }

            public Builder capSaturationToMissingHealthOverride(float capSaturationToMissingHealthOverride) {
                values.capSaturationToMissingHealthOverride = capSaturationToMissingHealthOverride;
                return this;
            }

            public Builder hungerSlowRegenOverride(int hungerSlowRegenOverride) {
                values.hungerSlowRegenOverride = hungerSlowRegenOverride;
                return this;
            }

            public Builder hungerFastRegenOverride(int hungerFastRegenOverride) {
                values.hungerFastRegenOverride = hungerFastRegenOverride;
                return this;
            }

            public Builder hungerSlowHealRate(int hungerSlowHealRate) {
                values.hungerSlowHealRate = hungerSlowHealRate;
                return this;
            }

            public Builder saturationFastHealRate(int saturationFastHealRate) {
                values.saturationFastHealRate = saturationFastHealRate;
                return this;
            }

            public Builder tryTakeSaturationOnlyWhenHealing(boolean tryTakeSaturationOnlyWhenHealing) {
                values.tryTakeSaturationOnlyWhenHealing = tryTakeSaturationOnlyWhenHealing;
                return this;
            }

            public Builder starveDamage(int starveDamage) {
                values.starveDamage = starveDamage;
                return this;
            }

            public Builder starveDamageRate(int starveDamageRate) {
                values.starveDamageRate = starveDamageRate;
                return this;
            }

            public Builder dealStarveDamageTill(int dealStarveDamageTill) {
                values.dealStarveDamageTill = dealStarveDamageTill;
                return this;
            }

            public DifficultyBasedHungerValues build() {
                return values;
            }
        }

        // Builder method
        public static Builder builder() {
            return new Builder();
        }
    }
}