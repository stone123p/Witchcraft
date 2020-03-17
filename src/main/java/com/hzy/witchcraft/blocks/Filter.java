package com.hzy.witchcraft.blocks;

import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.hzy.witchcraft.Witchcraft;
import com.hzy.witchcraft.handler.Stats;
import com.hzy.witchcraft.tileentity.FilterTileEntity;
import com.hzy.witchcraft.tileentity.TileEntityTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class Filter extends  Block implements ITileEntityProvider {
	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return new FilterTileEntity();
	}
	@Override
	public boolean hasTileEntity() {
		return true;
	}

	public Filter() {
		super(Block.Properties.create(Material.IRON));
		
	}
	private static final VoxelShape SHAPE=Stream.of(Block.makeCuboidShape(5, 0, 5, 11, 6, 11)).reduce((v1,v2)->{
		return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
		}).get();


	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		 TileEntity tileentity = worldIn.getTileEntity(pos);
		 return (INamedContainerProvider)(FilterTileEntity)tileentity;    
	}
	  
	@Override
	public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te,
			ItemStack stack) {
		super.harvestBlock(worldIn, player, pos, state, te, stack);
	}
	public ActionResultType func_225533_a_(BlockState blockstate, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
		  if (!world.isRemote) {
			  TileEntity tileentity = world.getTileEntity(pos);
			  System.out.println(""+tileentity);
			  if ((FilterTileEntity)tileentity instanceof INamedContainerProvider) {
				  NetworkHooks.openGui((ServerPlayerEntity)player, (INamedContainerProvider)(FilterTileEntity)tileentity,tileentity.getPos());
				  player.addStat(Stats.INTERACT_WITH_FILTER);
				 
			  }
			 
	      }
	        return ActionResultType.SUCCESS;

	   }

	
	
	

}
