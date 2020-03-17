package com.hzy.witchcraft.screen;

import com.hzy.witchcraft.container.FilterContainer;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FilterScreen extends ContainerScreen<FilterContainer>{
	
	public FilterScreen(FilterContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}
	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		super.render(mouseX, mouseY, partialTicks);
		this.renderBackground();
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	private final ResourceLocation FILTER_GUI_TEXTURES = new ResourceLocation("witchcraft:textures/guis/alchemy_table.png");
	
	
	

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		  RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
	      this.minecraft.getTextureManager().bindTexture(this.FILTER_GUI_TEXTURES);
	      int i = this.guiLeft;
	      int j = this.guiTop;
	      this.blit(i, j, 0, 0, this.xSize, this.ySize);
	}

}
