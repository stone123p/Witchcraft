package com.hzy.witchcraft.blocks;

import com.hzy.witchcraft.Witchcraft;import com.hzy.witchcraft.Witchcraft.WitchcraftItemGroup;
import com.hzy.witchcraft.tileentity.FilterTileEntity;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.tileentity.TileEntityType.Builder;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid= Witchcraft.MOD_ID,bus=Bus.MOD)
@ObjectHolder(Witchcraft.MOD_ID)
public class WBlocks {
	public class FilterTileEntityType {

	}
	@ObjectHolder(Witchcraft.MOD_ID+":tripod")
	public static final Block Tripod  =new Tripod();
	
	@ObjectHolder(Witchcraft.MOD_ID+":filter")
	public static final Block Filter  =new Filter();

	
	
	


	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		
		event.getRegistry().register(Tripod.setRegistryName("tripod"));
		event.getRegistry().register(Filter.setRegistryName("filter"));
	}

	

	public static void setBlocksRnderType() {
		RenderTypeLookup.setRenderLayer(Tripod, RenderType.func_228643_e_());
		RenderTypeLookup.setRenderLayer(Filter, RenderType.func_228643_e_());

		
		
	}
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new BlockItem(Tripod,new Item.Properties().group(WitchcraftItemGroup.instance)).setRegistryName("tripod"));
		event.getRegistry().register(new BlockItem(Filter,new Item.Properties().group(WitchcraftItemGroup.instance)).setRegistryName("filter"));

	}
}
