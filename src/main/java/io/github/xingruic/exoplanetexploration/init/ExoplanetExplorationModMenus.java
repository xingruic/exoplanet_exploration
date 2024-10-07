
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package io.github.xingruic.exoplanetexploration.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import io.github.xingruic.exoplanetexploration.world.inventory.LaunchPadPlayerGUIMenu;
import io.github.xingruic.exoplanetexploration.world.inventory.LaunchPadGUIMenu;
import io.github.xingruic.exoplanetexploration.ExoplanetExplorationMod;

public class ExoplanetExplorationModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, ExoplanetExplorationMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<LaunchPadGUIMenu>> LAUNCH_PAD_GUI = REGISTRY.register("launch_pad_gui", () -> IMenuTypeExtension.create(LaunchPadGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LaunchPadPlayerGUIMenu>> LAUNCH_PAD_PLAYER_GUI = REGISTRY.register("launch_pad_player_gui", () -> IMenuTypeExtension.create(LaunchPadPlayerGUIMenu::new));
}
