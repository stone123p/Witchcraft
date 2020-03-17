package com.hzy.witchcraft.items;

import com.hzy.witchcraft.Witchcraft.WitchcraftItemGroup;

import net.minecraft.item.Item;

public class MaterialBottle extends Item {

	public MaterialBottle() {
		super(new Item.Properties().group(WitchcraftItemGroup.instance).maxStackSize(1));
		
	}

}
