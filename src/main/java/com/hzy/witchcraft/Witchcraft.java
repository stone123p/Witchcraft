package com.hzy.witchcraft;



import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.IStatFormatter;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.hzy.witchcraft.blocks.WBlocks;
import com.hzy.witchcraft.container.ContainerTypes;
import com.hzy.witchcraft.items.WItems;
import com.hzy.witchcraft.proxies.ClientProxy;
import com.hzy.witchcraft.proxies.IProxy;
import com.hzy.witchcraft.proxies.ServerProxy;
import com.hzy.witchcraft.tileentity.TileEntityTypes;



@Mod("witchcraft")
public class Witchcraft
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID="witchcraft";
    public static Witchcraft instance;
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    
    public Witchcraft() {
    	final IEventBus modEventBus =FMLJavaModLoadingContext.get().getModEventBus();
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);
    	TileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
    	ContainerTypes.CONTAINER_TYPES.register(modEventBus);
    	
        instance = this;
        
     
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    //seting Tab
  	public static class WitchcraftItemGroup extends ItemGroup{
  		public static final WitchcraftItemGroup instance = new WitchcraftItemGroup(ItemGroup.GROUPS.length,"witchcrafttab");
		public WitchcraftItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(WItems.Arthana);
		}
  		
  	}
    private void setup(final FMLCommonSetupEvent event)
    {
    	proxy.init();
    	WBlocks.setBlocksRnderType();
    	
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
       
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    }
    
    

}
