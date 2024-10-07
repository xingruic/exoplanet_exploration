
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.xingruic.exoplanetexploration.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import io.github.xingruic.exoplanetexploration.client.gui.LaunchPadPlayerGUIScreen;
import io.github.xingruic.exoplanetexploration.client.gui.LaunchPadGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExoplanetExplorationModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ExoplanetExplorationModMenus.LAUNCH_PAD_GUI.get(), LaunchPadGUIScreen::new);
		event.register(ExoplanetExplorationModMenus.LAUNCH_PAD_PLAYER_GUI.get(), LaunchPadPlayerGUIScreen::new);
	}
}
