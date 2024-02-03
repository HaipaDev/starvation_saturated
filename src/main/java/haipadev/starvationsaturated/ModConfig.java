package haipadev.starvationsaturated;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;
import me.shedaniel.autoconfig.ConfigHolder;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.api.ConfigScreen;
import me.shedaniel.clothconfig2.gui.entries.DropdownBoxEntry;
import me.shedaniel.clothconfig2.impl.builders.DropdownMenuBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

@Config(name = "starvationsaturated")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static haipadev.starvationsaturated.ModConfig INSTANCE;

    public static Item configItem = Items.APPLE;

    public static void init() {
        AutoConfig.register(haipadev.starvationsaturated.ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(haipadev.starvationsaturated.ModConfig.class).getConfig();
        AutoConfig.getConfigHolder(haipadev.starvationsaturated.ModConfig.class).registerSaveListener((holder, data) -> onConfigSaved(holder));
        AutoConfig.getConfigHolder(haipadev.starvationsaturated.ModConfig.class).registerLoadListener((holder, data) -> onConfigLoaded(holder));
    }
    private static ActionResult onConfigSaved(ConfigHolder<ModConfig> holder) {
        ItemsRegistryModifier.iterateRegisteredItems();
        return ActionResult.SUCCESS;
    }
    private static ActionResult onConfigLoaded(ConfigHolder<ModConfig> holder) {
        ItemsRegistryModifier.iterateRegisteredItems();
        return ActionResult.SUCCESS;
    }

    @ConfigEntry.Gui.Tooltip()
    @Comment("Skip check for PEACEFUL that gives free hunger regeneration")
    public boolean enablePeacefulHunger = true;
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues peacefulHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(true)
            .consumeDefaultTime(32)
            .consumeSnackTime(16)
            .isFoodInstaUse(true)
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
            .tryTakeSaturationOnlyWhenSprinting(false)
            .hungerForSprint(7)
            .saturationForSprint(0)
            .sprintExhaustion(0.1F)
            .sprintJumpExhaustion(0.2F)
            .jumpExhaustion(0.05F)
            .starveDamage(1)
            .starveDamageRate(80)
            .dealStarveDamageTill(1)
            .build();
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues easyHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(true)
            .consumeDefaultTime(32)
            .consumeSnackTime(16)
            .isFoodInstaUse(true)
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
            .tryTakeSaturationOnlyWhenSprinting(false)
            .hungerForSprint(7)
            .saturationForSprint(0)
            .sprintExhaustion(0.15F)
            .sprintJumpExhaustion(0.25F)
            .jumpExhaustion(0.1F)
            .starveDamage(2)
            .starveDamageRate(80)
            .dealStarveDamageTill(0)
            .build();
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues normalHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(true)
            .consumeDefaultTime(32)
            .consumeSnackTime(16)
            .isFoodInstaUse(false)
            .hungerStart(20)
            .saturationStart(0)
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
            .tryTakeSaturationOnlyWhenSprinting(true)
            .hungerForSprint(9)
            .saturationForSprint(8)
            .sprintExhaustion(0.5F)
            .sprintJumpExhaustion(0.6F)
            .jumpExhaustion(0.1F)
            .starveDamage(3)
            .starveDamageRate(80)
            .dealStarveDamageTill(0)
            .build();
    @ConfigEntry.Gui.CollapsibleObject
    public DifficultyBasedHungerValues hardHungerValues = DifficultyBasedHungerValues.builder()
            .isFoodAlwaysEdible(true)
            .isFoodSnack(false)
            .consumeDefaultTime(36)
            .consumeSnackTime(24)
            .isFoodInstaUse(false)
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
            .tryTakeSaturationOnlyWhenSprinting(true)
            .hungerForSprint(13)
            .saturationForSprint(0)
            .sprintExhaustion(1F)
            .sprintJumpExhaustion(1.2F)
            .jumpExhaustion(0.1F)
            .starveDamage(4)
            .starveDamageRate(80)
            .dealStarveDamageTill(0)
            .build();


    public static class DifficultyBasedHungerValues {
        @ConfigEntry.Gui.Tooltip()
        @Comment("Allows you to eat *all* foods even when full")
        public boolean isFoodAlwaysEdible;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Makes *all* foods faster to eat")
        public boolean isFoodSnack;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Amount of ticks it takes to eat a regular food (vanilla is 32)")
        public int consumeDefaultTime;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Amount of ticks it takes to eat a snack food (vanilla is 16)")
        public int consumeSnackTime;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Makes food instantly eaten like in Beta")
        public boolean isFoodInstaUse;
        @ConfigEntry.BoundedDiscrete(min=0,max=64)
        @Comment("An override value for *all* food items stack sizes (0 is vanilla)")
        public int foodStackSizeOverride;

        @ConfigEntry.Gui.PrefixText()
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

        @ConfigEntry.Gui.PrefixText()
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
        @ConfigEntry.Gui.PrefixText()
        @ConfigEntry.Gui.Tooltip()
        @Comment("('Try') Take saturation only when sprinting, other actions take hunger")
        public boolean tryTakeSaturationOnlyWhenSprinting;

        @ConfigEntry.Gui.PrefixText()
        @ConfigEntry.Gui.Tooltip()
        @Comment("Hunger required for sprint (set this to 99 or whatever to completely disable sprint, vanilla is 6 [but set to 5 because >= 5])")
        public int hungerForSprint;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Saturation level required to allow sprint")
        public float saturationForSprint;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Exhaustion take on sprint tick (vanilla is 0.1)")
        public float sprintExhaustion;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Exhaustion taken on a sprint jump (vanilla is 0.2)")
        public float sprintJumpExhaustion;
        @ConfigEntry.Gui.Tooltip()
        @Comment("Exhaustion taken on jump (vanilla is 0.05)")
        public float jumpExhaustion;

        @ConfigEntry.Gui.PrefixText()
        @ConfigEntry.Gui.Tooltip()
        @Comment("How much starvation damage to deal (vanilla is 1)")
        public int starveDamage;
        @ConfigEntry.Gui.Tooltip()
        @Comment("How fast starvation damage occurs in tick (vanilla is 80)")
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

            public Builder consumeDefaultTime(int consumeDefaultTime) {
                values.consumeDefaultTime = consumeDefaultTime;
                return this;
            }

            public Builder consumeSnackTime(int consumeSnackTime) {
                values.consumeSnackTime = consumeSnackTime;
                return this;
            }

            public Builder isFoodInstaUse(boolean isFoodInstaUse) {
                values.isFoodInstaUse = isFoodInstaUse;
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
            public Builder tryTakeSaturationOnlyWhenSprinting(boolean tryTakeSaturationOnlyWhenSprinting) {
                values.tryTakeSaturationOnlyWhenSprinting = tryTakeSaturationOnlyWhenSprinting;
                return this;
            }

            public Builder hungerForSprint(int hungerForSprint) {
                values.hungerForSprint = hungerForSprint;
                return this;
            }

            public Builder saturationForSprint(float saturationForSprint) {
                values.saturationForSprint = saturationForSprint;
                return this;
            }

            public Builder sprintJumpExhaustion(float sprintJumpExhaustion) {
                values.sprintJumpExhaustion = sprintJumpExhaustion;
                return this;
            }

            public Builder sprintExhaustion(float sprintExhaustion) {
                values.sprintExhaustion = sprintExhaustion;
                return this;
            }

            public Builder jumpExhaustion(float jumpExhaustion) {
                values.jumpExhaustion = jumpExhaustion;
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
//    public static ConfigScreen createConfigScreen() {
//        ConfigBuilder builder = ConfigBuilder.create()
//                .setTitle(Text.of("Mod Config"));
//
//        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
//
//        // Dropdown menu for item selection
////        DropdownMenuBuilder<Item> dropdownMenuBuilder = entryBuilder.startDropdownMenu("Select Item",
////                        DropdownMenuBuilder.TopCellElementBuilder.ofItemObject(configItem),
////                        DropdownMenuBuilder.CellCreatorBuilder.ofItemObject())
////                .setDefaultValue(Items.APPLE)
////                .setSelections(Registries.ITEM.stream().collect(Collectors.toSet()))
////                .setSaveConsumer(item -> configItem = item)
////                .build();
////        ConfigEntryBuilder.EnumSelectorBuilder<Item> itemDropdownBuilder = entryBuilder.startEnumSelector("Select Item", Item.class, configItem);
////        DropdownMenuBuilder<Item> itemDropdownBuilder = entryBuilder.startDropdownMenu("Select Item",
////                DropdownBoxEntry.TopCellElementBuilder.ofItemObject(configItem),
////                DropdownBoxEntry.CellCreatorBuilder.ofItemObject());
////        DropdownMenuBuilder<Item> itemDropdownBuilder = entryBuilder.startDropdownMenu(Text.of("Select Item"),
////                (DropdownBoxEntry.SelectionTopCellElement<Item>) DropdownBoxEntry.SelectionTopCellElement.(configItem, item -> item, item -> Text.of(item.getName())),
////                (DropdownBoxEntry.SelectionCellCreator<Item>) DropdownBoxEntry.SelectionCellCreator(item -> Text.of(item.getName())));
////        DropdownMenuBuilder<Item> itemDropdownBuilder = entryBuilder.startDropdownMenu(Text.of("Select Item"),
////                DropdownBoxEntry.SelectionTopCellElement(configItem, item -> item, item -> Text.of(configItem.getName())),
////                new DropdownBoxEntry.SelectionCellCreator(item -> configItem.getName()));
//        DropdownBoxEntry.SelectionTopCellElement<Item> topCellElement=;
//        DropdownBoxEntry.SelectionCellCreator<Item> cellCreator;
//        DropdownMenuBuilder<Item> itemDropdownBuilder = new DropdownMenuBuilder<Item>(Text.of("Reset"), Text.of("Field"), topCellElement, cellCreator);
//
//
//        itemDropdownBuilder
//                .setDefaultValue(Items.APPLE)
//                .setSaveConsumer(item -> configItem = item)
//                .build();
//
//        // Other config entries can be added here using entryBuilder
//
//        ConfigCategory generalCategory = builder.getOrCreateCategory(Text.of("General"));
//        generalCategory.addEntry(dropdownMenuBuilder);
//
//        return (ConfigScreen) builder.build();
//    }
}