package com.hzy.witchcraft.tileentity;

import javax.annotation.Nullable;

import com.hzy.witchcraft.container.FilterContainer;
import com.hzy.witchcraft.tileentity.TileEntityTypes;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;


public class FilterTileEntity extends TileEntity implements  ITickableTileEntity ,INamedContainerProvider{


	

	public FilterTileEntity() {
		super(TileEntityTypes.FILTER.get());
	}

	@Override
	public void tick() {
		
	}
	
	@Nullable
	@Override
	public Container createMenu(int p_createMenu_1_, PlayerInventory playerInventory, PlayerEntity playerEntity) {
		return new FilterContainer(p_createMenu_1_,world, this.pos, playerInventory, playerEntity);
		
	}



	@Override
	public ITextComponent getDisplayName() {
		return new StringTextComponent(getType().getRegistryName().getPath());
	}

	

}
