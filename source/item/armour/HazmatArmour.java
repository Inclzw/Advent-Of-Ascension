package net.tslat.aoa3.item.armour;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tslat.aoa3.library.Enums;
import net.tslat.aoa3.utils.StringUtil;

import java.util.List;

import static net.tslat.aoa3.common.registration.MaterialsRegister.ARMOURHAZMAT;

public class HazmatArmour extends AdventArmour {
	public HazmatArmour(String name, String registryName, int renderIndex, EntityEquipmentSlot slot) {
		super(ARMOURHAZMAT, name, registryName, renderIndex, slot);
	}

	@Override
	public Enums.ArmourSets setType() {
		return Enums.ArmourSets.HAZMAT;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		tooltip.add(StringUtil.getColourLocaleString("items.description.fullSetBonus", TextFormatting.GOLD));
		tooltip.add(StringUtil.getColourLocaleString("item.HazmatArmour.desc.1", TextFormatting.DARK_GREEN));
	}
}
