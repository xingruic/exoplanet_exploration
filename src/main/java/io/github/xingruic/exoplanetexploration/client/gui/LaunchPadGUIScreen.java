package io.github.xingruic.exoplanetexploration.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import io.github.xingruic.exoplanetexploration.world.inventory.LaunchPadGUIMenu;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaunchPadGUIScreen extends AbstractContainerScreen<LaunchPadGUIMenu> {
	private final static HashMap<String, Object> guistate = LaunchPadGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox tp_dimension;
	EditBox tp_coords;

	public LaunchPadGUIScreen(LaunchPadGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("exoplanet_exploration:textures/screens/launch_pad_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		tp_dimension.render(guiGraphics, mouseX, mouseY, partialTicks);
		tp_coords.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 18, this.topPos + 39, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 54, this.topPos + 39, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 90, this.topPos + 39, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 126, this.topPos + 39, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 162, this.topPos + 39, 0, 0, 15, 22, 15, 22);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (tp_dimension.isFocused())
			return tp_dimension.keyPressed(key, b, c);
		if (tp_coords.isFocused())
			return tp_coords.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String tp_dimensionValue = tp_dimension.getValue();
		String tp_coordsValue = tp_coords.getValue();
		super.resize(minecraft, width, height);
		tp_dimension.setValue(tp_dimensionValue);
		tp_coords.setValue(tp_coordsValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.exoplanet_exploration.launch_pad_gui.label_launch_pad"), 6, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.exoplanet_exploration.launch_pad_gui.label_dimension"), 9, 93, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		tp_dimension = new EditBox(this.font, this.leftPos + 64, this.topPos + 94, 118, 18, Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_dimension")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_dimension").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_dimension").getString());
				else
					setSuggestion(null);
			}
		};
		tp_dimension.setMaxLength(32767);
		tp_dimension.setSuggestion(Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_dimension").getString());
		guistate.put("text:tp_dimension", tp_dimension);
		this.addWidget(this.tp_dimension);
		tp_coords = new EditBox(this.font, this.leftPos + 64, this.topPos + 121, 118, 18, Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_coords")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_coords").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos, boolean flag) {
				super.moveCursorTo(pos, flag);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_coords").getString());
				else
					setSuggestion(null);
			}
		};
		tp_coords.setMaxLength(32767);
		tp_coords.setSuggestion(Component.translatable("gui.exoplanet_exploration.launch_pad_gui.tp_coords").getString());
		guistate.put("text:tp_coords", tp_coords);
		this.addWidget(this.tp_coords);
	}
}
