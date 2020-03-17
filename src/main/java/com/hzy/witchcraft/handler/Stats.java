package com.hzy.witchcraft.handler;

import net.minecraft.stats.IStatFormatter;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public class Stats {
	public static final ResourceLocation INTERACT_WITH_FILTER= registerCustom("interact_with_filter", IStatFormatter.DEFAULT);

	private static ResourceLocation registerCustom(String key, IStatFormatter formatter) {
	      ResourceLocation resourcelocation = new ResourceLocation(key);
	      Registry.register(Registry.CUSTOM_STAT, key, resourcelocation);
	      return resourcelocation;
	}

	  
}
