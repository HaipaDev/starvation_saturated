package haipadev.starvationsaturated;

import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.ModConfig;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import haipadev.starvationsaturated.ModConfigOwo;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class StarvationSaturated implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("starvationsaturated");

//	public static final ModConfigOwo CONFIG = ModConfigOwo.createAndLoad();
	public static ModConfigOwo CONFIG;
	@Override
	public void onInitialize() {
		CONFIG = ModConfigOwo.createAndLoad();
//		System.out.println(StarvationSaturated.CONFIG.itemValues());

		ItemsRegistryModifier.init();
//		ModConfig.init();
		ModConfigHelper.init();
		HungerManagerHelper.init();
		System.out.println(StarvationSaturated.CONFIG.itemValues());
		if(StarvationSaturated.CONFIG.itemValues()==null || StarvationSaturated.CONFIG.itemValues().isEmpty()){
			System.out.println("Trying to set itemValues list");
			StarvationSaturated.CONFIG.itemValues(ItemsRegistryModifier.SetModifiedFoodItemsValuesInitialMCRegistry().getAllItemValues());
		}else{
			System.out.println("CONFIG NOT NULL");
			System.out.println(StarvationSaturated.CONFIG.itemValues().get(Identifier.of("minecraft","potato")).modifiedStackSize());
		}
		ItemsRegistryModifier.applyModifiedValuesFromConfig();
		StarvationSaturated.CONFIG.subscribeToItemValues(value -> {ItemsRegistryModifier.applyModifiedValuesFromConfig();});
		LOGGER.info("Starvation Saturated loaded - saturate your starvation journey today");
	}
}