package net.tslat.aoa3.item.weapon.bow;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tslat.aoa3.entity.projectiles.arrow.EntityHollyArrow;
import net.tslat.aoa3.utils.EntityUtil;
import net.tslat.aoa3.utils.StringUtil;

import java.util.List;

public class RunicBow extends BaseBow {
	public RunicBow(double damage, float drawSpeedMultiplier, int durability) {
		super(damage, drawSpeedMultiplier, durability);
		setUnlocalizedName("RunicBow");
		setRegistryName("aoa3:runic_bow");
	}

	@Override
	public void doImpactEffect(EntityHollyArrow arrow, Entity target, Entity shooter) {
		if (shooter instanceof EntityLivingBase)
			EntityUtil.healEntity((EntityLivingBase)shooter, 3);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(StringUtil.getColourLocaleString("item.RunicBow.desc.1", TextFormatting.DARK_GREEN));
		super.addInformation(stack, world, tooltip, flag);
	}
}