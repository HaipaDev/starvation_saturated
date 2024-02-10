package haipadev.starvationsaturated;

import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.ModConfig;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import haipadev.starvationsaturated.ModConfigOwo;

import java.util.HashMap;

public class StarvationSaturated implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("starvationsaturated");

	public static final ModConfigOwo CONFIG = ModConfigOwo.createAndLoad();
	@Override
	public void onInitialize() {
		ItemsRegistryModifier.init();
		ModConfigHelper.init();
		HungerManagerHelper.init();
		if(StarvationSaturated.CONFIG.itemValues()==null){
			System.out.println("Trying to set itemValues list");
			StarvationSaturated.CONFIG.itemValues(ItemsRegistryModifier.SetModifiedFoodItemsValuesInitialMCRegistry().getAllItemValues());
		}
		LOGGER.info("Starvation Saturated loaded - saturate your starvation journey today");
	}
}