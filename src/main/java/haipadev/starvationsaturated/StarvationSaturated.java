package haipadev.starvationsaturated;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StarvationSaturated implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("starvationsaturated");

	@Override
	public void onInitialize() {
		LOGGER.info("Starvation Saturated loaded");
	}
}