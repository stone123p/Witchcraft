package com.hzy.witchcraft.proxies;

import com.hzy.witchcraft.container.ContainerTypes;
import com.hzy.witchcraft.screen.FilterScreen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.world.World;

public class ClientProxy implements IProxy {

	@Override
	public void init() {
		ScreenManager.registerFactory(ContainerTypes.FILTER.get(),  FilterScreen::new);
	}

	@Override
	public World getClientWorld() {
        return Minecraft.getInstance().world;
	
	}

	@Override
	public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
	}

}
