package com.hzy.witchcraft.items;

import com.hzy.witchcraft.Witchcraft;
import com.hzy.witchcraft.Witchcraft.WitchcraftItemGroup;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
@Mod.EventBusSubscriber(modid= Witchcraft.MOD_ID,bus=Bus.MOD)
@ObjectHolder(Witchcraft.MOD_ID)
public class WItems {
	public static final Item Arthana  =new Arthana();
	public static final Item DistilledBottle =new DistilledBottle();
	public static final Item FullDistilledBottle =new Item(new Item.Properties().group(WitchcraftItemGroup.instance).maxStackSize(1)).setRegistryName("full_distilled_bottle");
	public static final Item DistilledMaterialBottle =new MaterialBottle().setRegistryName("distilled_material_bottle");
	public static final Item PotionDistilledBottle=new MaterialBottle().setRegistryName("potion_distilled_bottle");
	
	@SubscribeEvent
	public static void registerItem(final RegistryEvent.Register<Item> event) {
	
	 	event.getRegistry().register(Arthana);
		event.getRegistry().register(DistilledBottle);
		event.getRegistry().register(FullDistilledBottle);
		event.getRegistry().register(DistilledMaterialBottle);
		event.getRegistry().register(PotionDistilledBottle);
		
		
	 
	}
}
