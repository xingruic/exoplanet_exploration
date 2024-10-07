package io.github.xingruic.exoplanetexploration.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import io.github.xingruic.exoplanetexploration.world.inventory.LaunchPadPlayerGUIMenu;
import io.github.xingruic.exoplanetexploration.procedures.LaunchPadPlayerGUIDisplayButtonProcedure;
import io.github.xingruic.exoplanetexploration.network.LaunchPadPlayerGUIButtonMessage;

import com.mojang.blaze3d.systems.RenderSystem;

public class LaunchPadPlayerGUIScreen extends AbstractContainerScreen<LaunchPadPlayerGUIMenu> {
	private final static HashMap<String, Object> guistate = LaunchPadPlayerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_launch_button;

	public LaunchPadPlayerGUIScreen(LaunchPadPlayerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 230;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("exoplanet_exploration:textures/screens/launch_pad_player_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 18, this.topPos + 48, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 54, this.topPos + 48, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 90, this.topPos + 48, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 126, this.topPos + 48, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/gui_arrow.png"), this.leftPos + 162, this.topPos + 48, 0, 0, 15, 22, 15, 22);

		guiGraphics.blit(ResourceLocation.parse("exoplanet_exploration:textures/screens/launch_button_pressed.png"), this.leftPos + 90, this.topPos + 120, 0, 0, 16, 17, 16, 17);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.exoplanet_exploration.launch_pad_player_gui.label_launch_pad"), 7, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_launch_button = new ImageButton(this.leftPos + 90, this.topPos + 120, 16, 17,
				new WidgetSprites(ResourceLocation.parse("exoplanet_exploration:textures/screens/launch_button.png"), ResourceLocation.parse("exoplanet_exploration:textures/screens/launch_button.png")), e -> {
					if (LaunchPadPlayerGUIDisplayButtonProcedure.execute(world, entity)) {
						PacketDistributor.sendToServer(new LaunchPadPlayerGUIButtonMessage(0, x, y, z));
						LaunchPadPlayerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (LaunchPadPlayerGUIDisplayButtonProcedure.execute(world, entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_launch_button", imagebutton_launch_button);
		this.addRenderableWidget(imagebutton_launch_button);
	}
}
