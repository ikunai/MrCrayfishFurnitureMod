package com.mrcrayfish.furniture.blocks;

import java.util.List;

import com.mrcrayfish.furniture.util.CollisionHelper;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMantelPiece extends BlockFurniture 
{
	private static final AxisAlignedBB BOUNDING_BOX_NORTH = CollisionHelper.getBlockBounds(EnumFacing.NORTH, 0.625, 0.0, -0.5, 1.0, 1.4, 1.5);
	private static final AxisAlignedBB BOUNDING_BOX_EAST = CollisionHelper.getBlockBounds(EnumFacing.EAST, 0.625, 0.0, -0.5, 1.0, 1.4, 1.5);
	private static final AxisAlignedBB BOUNDING_BOX_SOUTH = CollisionHelper.getBlockBounds(EnumFacing.SOUTH, 0.625, 0.0, -0.5, 1.0, 1.4, 1.5);
	private static final AxisAlignedBB BOUNDING_BOX_WEST = CollisionHelper.getBlockBounds(EnumFacing.WEST, 0.625, 0.0, -0.5, 1.0, 1.4, 1.5);
	private static final AxisAlignedBB[] BOUNDING_BOX = { BOUNDING_BOX_SOUTH, BOUNDING_BOX_WEST, BOUNDING_BOX_NORTH, BOUNDING_BOX_EAST };
	
	public BlockMantelPiece(Material materialIn) 
	{
		super(materialIn);
		this.setHardness(1.0F);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		EnumFacing facing = state.getValue(FACING);
		return BOUNDING_BOX[facing.getHorizontalIndex()];
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB axisAligned, List<AxisAlignedBB> axisAlignedList, Entity collidingEntity) 
	{
		EnumFacing facing = state.getValue(FACING);
		super.addCollisionBoxToList(pos, axisAligned, axisAlignedList, BOUNDING_BOX[facing.getHorizontalIndex()]);
	}

}
