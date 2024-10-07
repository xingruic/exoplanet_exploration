package io.github.xingruic.exoplanetexploration.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

import io.github.xingruic.exoplanetexploration.world.inventory.LaunchPadPlayerGUIMenu;
import io.github.xingruic.exoplanetexploration.world.inventory.LaunchPadGUIMenu;
import io.github.xingruic.exoplanetexploration.init.ExoplanetExplorationModItems;

public class LaunchPadOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("lpad_item_display_iter");
			if (_so == null)
				_so = _sc.addObjective("lpad_item_display_iter", ObjectiveCriteria.DUMMY, Component.literal("lpad_item_display_iter"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(5);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("lpad_level_complete");
			if (_so == null)
				_so = _sc.addObjective("lpad_level_complete", ObjectiveCriteria.DUMMY, Component.literal("lpad_level_complete"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set(0);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("lpad_x");
			if (_so == null)
				_so = _sc.addObjective("lpad_x", ObjectiveCriteria.DUMMY, Component.literal("lpad_x"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) x);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("lpad_y");
			if (_so == null)
				_so = _sc.addObjective("lpad_y", ObjectiveCriteria.DUMMY, Component.literal("lpad_y"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) y);
		}
		{
			Entity _ent = entity;
			Scoreboard _sc = _ent.level().getScoreboard();
			Objective _so = _sc.getObjective("lpad_z");
			if (_so == null)
				_so = _sc.addObjective("lpad_z", ObjectiveCriteria.DUMMY, Component.literal("lpad_z"), ObjectiveCriteria.RenderType.INTEGER, true, null);
			_sc.getOrCreatePlayerScore(ScoreHolder.forNameOnly(_ent.getScoreboardName()), _so).set((int) z);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ExoplanetExplorationModItems.LAUNCH_PAD_WRENCH.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("LaunchPadGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new LaunchPadGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("LaunchPadPlayerGUI");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new LaunchPadPlayerGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
