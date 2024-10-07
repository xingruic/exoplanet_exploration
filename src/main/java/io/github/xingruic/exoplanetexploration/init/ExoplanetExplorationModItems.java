
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.xingruic.exoplanetexploration.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import io.github.xingruic.exoplanetexploration.item.LaunchPadWrenchItem;
import io.github.xingruic.exoplanetexploration.ExoplanetExplorationMod;

public class ExoplanetExplorationModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ExoplanetExplorationMod.MODID);
	public static final DeferredItem<Item> LAUNCH_PAD = block(ExoplanetExplorationModBlocks.LAUNCH_PAD);
	public static final DeferredItem<Item> LAUNCH_PAD_WRENCH = REGISTRY.register("launch_pad_wrench", LaunchPadWrenchItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
