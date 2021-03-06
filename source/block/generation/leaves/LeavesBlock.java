package net.tslat.aoa3.block.generation.leaves;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tslat.aoa3.advent.AdventOfAscension;
import net.tslat.aoa3.common.registration.CreativeTabsRegister;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LeavesBlock extends BlockLeaves {
	public LeavesBlock(String name, String registryName) {
		super();
		AdventOfAscension.proxy.setFancyLeaves(this);
		setUnlocalizedName(name);
		setRegistryName("aoa3:" + registryName);
		setCreativeTab(CreativeTabsRegister.generationBlocksTab);
		setSoundType(SoundType.PLANT);
		Blocks.FIRE.setFireInfo(this, 30, 60);
		setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, false));
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		if (placer != null)
			return getDefaultState().withProperty(DECAYABLE, false);

		return getDefaultState();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, DECAYABLE, CHECK_DECAY);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(Item.getItemFromBlock(this));
	}

	@Nonnull
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		if (!state.getValue(DECAYABLE))
			i |= 4;

		if (state.getValue(CHECK_DECAY))
			i |= 8;

		return i;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return super.getRenderType(state);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DECAYABLE, (meta & 4) == 0).withProperty(CHECK_DECAY, (meta & 8) > 0);
	}

	@Override
	public BlockPlanks.EnumType getWoodType(int meta) {
		return null;
	}

	@Nonnull
	@Override
	public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		List<ItemStack> drops = new ArrayList<ItemStack>();

		drops.add(new ItemStack(this, 1));
		return drops;
	}
}
