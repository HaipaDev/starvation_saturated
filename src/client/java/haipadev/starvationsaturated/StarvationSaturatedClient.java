package haipadev.starvationsaturated;

import haipadev.starvationsaturated.helpers.ModConfigHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Util;

public class StarvationSaturatedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		//ClientTickEvents.END_CLIENT_TICK.register(this::clientTick);
	}
//
//	private void clientTick(MinecraftClient client) {
//		if (Util.getMeasuringTimeMs() % 20 == 0) {
//			// Check every second (20 ticks) if AppleSkin is loaded
//			if (isAppleSkinLoaded()) {
//				AppleSkinEventHandler.registerAppleSkinEvent();
//			}
//		}
//	}
//
//	private boolean isAppleSkinLoaded() {
//		return FabricLoader.getInstance().isModLoaded("appleskin");
//	}
}