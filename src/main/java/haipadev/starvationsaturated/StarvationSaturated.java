package haipadev.starvationsaturated;

import haipadev.starvationsaturated.helpers.HungerManagerHelper;
import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarvationSaturated implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("starvationsaturated");

	@Override
	public void onInitialize() {
		ModConfig.init();
		ModConfigHelper.init();
		HungerManagerHelper.init();
		LOGGER.info("Starvation Saturated loaded");
	}
}