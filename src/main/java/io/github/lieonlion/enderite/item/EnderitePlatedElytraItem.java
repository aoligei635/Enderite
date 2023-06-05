package io.github.lieonlion.enderite.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.DispenserBlock;

public class EnderitePlatedElytraItem extends ElytraItem {
	private final Multimap<Attribute, AttributeModifier> defaultModifiers;
	private final int defense;

		public EnderitePlatedElytraItem (int defense, Properties properties) {
		super(properties);
		DispenserBlock.registerBehavior(this, ArmorItem.DISPENSE_ITEM_BEHAVIOR);
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		this.defense = defense;
		builder.put(Attributes.ARMOR, new AttributeModifier("Armor modifier", (double)this.defense, AttributeModifier.Operation.ADDITION));

		this.defaultModifiers = builder.build();
	}

	public static boolean isUseable(ItemStack stack) {
		return stack.getDamageValue() < stack.getMaxDamage() - 1;
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack stack) {
		return stack.getItem() == ItemsInit.ENDERITE_INGOT.get();
	}

	@Override
	public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
		return EnderitePlatedElytraItem.isUseable(stack);
	}

	@Override
	public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
		if (!entity.level.isClientSide && (flightTicks + 1) % 40 == 0) {
			stack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
		}
		return true;
	}

	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
		return slot == EquipmentSlot.CHEST ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
	}

	public int getDefense() {
		return this.defense;
	}
}