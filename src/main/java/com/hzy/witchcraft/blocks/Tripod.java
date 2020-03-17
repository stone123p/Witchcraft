package com.hzy.witchcraft.blocks;



import java.util.stream.Stream;


import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;



public class Tripod extends Block  {
	

	public Tripod() {
		super(Block.Properties.create(Material.IRON));
		
	}
	
	private static final VoxelShape SHAPE=Stream.of(Block.makeCuboidShape(5, 0, 5, 11, 4, 11)).reduce((v1,v2)->{
			return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
			}).get();


	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	@Override
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		if(player.getHeldItem(Hand.MAIN_HAND).getItem()==Items.COAL) {
			
		}
		
	}
}
