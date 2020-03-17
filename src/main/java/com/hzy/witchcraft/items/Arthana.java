package com.hzy.witchcraft.items;

import com.hzy.witchcraft.Witchcraft.WitchcraftItemGroup;

import net.minecraft.item.Item;

public class Arthana extends Item {

	public Arthana() {
		super(new Item.Properties().group(WitchcraftItemGroup.instance));
		this.setRegistryName("arthana");
	}

}
