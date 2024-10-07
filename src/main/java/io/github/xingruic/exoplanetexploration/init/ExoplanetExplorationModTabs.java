
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.xingruic.exoplanetexploration.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import io.github.xingruic.exoplanetexploration.ExoplanetExplorationMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ExoplanetExplorationModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExoplanetExplorationMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {

			tabData.accept(ExoplanetExplorationModBlocks.LAUNCH_PAD.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(ExoplanetExplorationModItems.LAUNCH_PAD_WRENCH.get());

		}
	}
}
