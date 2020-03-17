package com.hzy.witchcraft.tileentity;

import com.hzy.witchcraft.Witchcraft;
import com.hzy.witchcraft.blocks.WBlocks;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypes {
	public static final DeferredRegister<TileEntityType<?>>TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES,Witchcraft.MOD_ID);
	
	public static final RegistryObject<TileEntityType<FilterTileEntity>> FILTER = TILE_ENTITY_TYPES.register("filter",()->TileEntityType.Builder.create(FilterTileEntity::new, WBlocks.Filter).build(null));

	



	

	
}
