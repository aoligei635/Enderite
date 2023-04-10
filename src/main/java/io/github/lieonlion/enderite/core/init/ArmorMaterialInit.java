package io.github.lieonlion.enderite.core.init;

import java.util.function.Supplier;

import io.github.lieonlion.enderite.Enderite;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class ArmorMaterialInit implements ArmorMaterial {
	public static final ArmorMaterial ENDERITE = new ArmorMaterialInit(25, 49, new int[] {4, 7, 9, 4}, 0.1f, 4, Enderite.MODID + ":enderite", SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(ItemInit.ENDERITE_INGOT.get()));
	
	private static final int[] health = new int[]{13, 15, 16, 11};
	private final int enchantability;
    private final int durabilityMultiplier;
    private final int[] damageReduction;
    private final float knockbackResistance, toughness;
    private final String name;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairMaterial;

    public ArmorMaterialInit(int enchantability, int durabilityMultiplier, int[] damageReduction, float knockbackResistance, float toughness, String name, SoundEvent equipSound, Supplier<Ingredient> repairMaterial) {
        this.enchantability = enchantability;
        this.durabilityMultiplier = durabilityMultiplier;
        this.damageReduction = damageReduction;
        this.knockbackResistance = knockbackResistance;
        this.toughness = toughness;
        this.name = name;
        this.equipSound = equipSound;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.damageReduction[slot.getIndex()];
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return health[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}