package io.github.lieonlion.enderite.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class EnderitePlatedElytraItem extends ElytraItem implements FabricElytraItem {
	private final Multimap<EntityAttribute, EntityAttributeModifier> defaultModifiers;
	private final int defense;

		public EnderitePlatedElytraItem (int defense, Item.Settings settings) {
		super(settings);
		DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
		ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
		this.defense = defense;
		builder.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier("Armor modifier", (double)this.defense, EntityAttributeModifier.Operation.ADDITION));

		this.defaultModifiers = builder.build();
	}

	public static boolean isUsable(ItemStack stack) {
		return stack.getDamage() < stack.getMaxDamage() - 1;
	}

	public boolean canRepair(ItemStack toRepair, ItemStack stack) {
		return stack.getItem() == ItemsInit.ENDERITE_INGOT;
	}

	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		return true;
	}

	public boolean flightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.world.isClient && (flightTicks + 1) % 25 == 0) {
			stack.damage(1, entity, e -> ((LivingEntity) e).sendEquipmentBreakStatus(EquipmentSlot.CHEST));
		}
		return isUsable(stack);
	}

	public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
		if (slot == EquipmentSlot.CHEST) {
			return this.defaultModifiers;
		}
		return super.getAttributeModifiers(slot);
	}

	public int getDefense() {
		return this.defense;
	}
}