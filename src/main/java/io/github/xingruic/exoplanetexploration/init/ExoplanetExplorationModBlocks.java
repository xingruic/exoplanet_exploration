
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package io.github.xingruic.exoplanetexploration.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import io.github.xingruic.exoplanetexploration.block.LaunchPadBlock;
import io.github.xingruic.exoplanetexploration.ExoplanetExplorationMod;

public class ExoplanetExplorationModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(ExoplanetExplorationMod.MODID);
	public static final DeferredBlock<Block> LAUNCH_PAD = REGISTRY.register("launch_pad", LaunchPadBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
