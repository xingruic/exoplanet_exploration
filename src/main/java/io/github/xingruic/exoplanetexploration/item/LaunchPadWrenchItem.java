
package io.github.xingruic.exoplanetexploration.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class LaunchPadWrenchItem extends Item {
	public LaunchPadWrenchItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}
}
