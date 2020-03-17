package com.hzy.witchcraft.container;

import com.hzy.witchcraft.blocks.WBlocks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.items.CapabilityItemHandler;


public class FilterContainer extends Container{
	protected FilterContainer(ContainerType<?> type, int id) {
		super(type, id);
	}
	public FilterContainer(int windowId,World world, BlockPos pos, PlayerInventory inv, PlayerEntity playerEntity) {
		super(ContainerTypes.FILTER.get(), windowId);
		tileEntity = world.getTileEntity(pos);
		player=playerEntity;
		tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
	}


	private TileEntity tileEntity;
	private PlayerEntity player;
	
	

	@Override
	public boolean canInteractWith(PlayerEntity player) {
		return Container.isWithinUsableDistance(IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos()), this.player, WBlocks.Filter);
	}

}
