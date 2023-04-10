package io.github.lieonlion.enderite.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class EnderiteHelmetItem extends ArmorItem {

	public EnderiteHelmetItem(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
		super(p_40386_, p_40387_, p_40388_);
	}
	
	@Override
	public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity){
	    return true;
	}
}