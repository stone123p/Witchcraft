package com.hzy.witchcraft.container;



import com.hzy.witchcraft.Witchcraft;



import net.minecraft.inventory.container.ContainerType;

import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.extensions.IForgeContainerType;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypes {
	
	public static final DeferredRegister<ContainerType<?>>	CONTAINER_TYPES = new DeferredRegister<>(ForgeRegistries.CONTAINERS,Witchcraft.MOD_ID);
	

	public static final RegistryObject<ContainerType<FilterContainer>> FILTER = CONTAINER_TYPES.register("filter_container",()->IForgeContainerType.create((windowId, inv, data)->{
		BlockPos pos = data.readBlockPos();
		return new FilterContainer(windowId, Witchcraft.proxy.getClientWorld(), pos, inv, Witchcraft.proxy.getClientPlayer());	
	}));
}
	

