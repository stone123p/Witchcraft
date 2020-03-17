package com.hzy.witchcraft.items;

import com.hzy.witchcraft.Witchcraft.WitchcraftItemGroup;

import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;

import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class DistilledBottle extends Item {

	public DistilledBottle() {
		super(new Item.Properties().group(WitchcraftItemGroup.instance));
		this.setRegistryName("distilled_bottle");
		
	}
	
	

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		 ItemStack itemstack = playerIn.getHeldItem(handIn);
	     RayTraceResult raytraceresult = rayTrace(worldIn, playerIn,  RayTraceContext.FluidMode.SOURCE_ONLY );
         BlockPos blockpos = ((BlockRayTraceResult)raytraceresult).getPos();
	     if(worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
	    	 worldIn.playSound(playerIn, playerIn.func_226277_ct_(), playerIn.func_226278_cu_(), playerIn.func_226281_cx_(), SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.NEUTRAL, 1.0F, 1.0F);
             return ActionResult.func_226248_a_(this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(WItems.FullDistilledBottle)));
             
	     }
	  
	    	  
	     return ActionResult.func_226250_c_(itemstack);
		
	}

	protected ItemStack turnBottleIntoItem(ItemStack p_185061_1_, PlayerEntity player, ItemStack stack) {
	      p_185061_1_.shrink(1);
	      player.addStat(Stats.ITEM_USED.get(this));
	      if (p_185061_1_.isEmpty()) {
	         return stack;
	      } else {
	         if (!player.inventory.addItemStackToInventory(stack)) {
	            player.dropItem(stack, false);
	         }

	         return p_185061_1_;
	      }
	   }
}
