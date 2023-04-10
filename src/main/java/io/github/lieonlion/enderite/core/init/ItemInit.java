package io.github.lieonlion.enderite.core.init;

import io.github.lieonlion.enderite.Enderite;
import io.github.lieonlion.enderite.core.item.EnderiteHelmetItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	private ItemInit() {}
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Enderite.MODID);
	
	public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant()));
	public static final RegistryObject<Item> RAW_ENDERITE = ITEMS.register("raw_enderite", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant()));
	public static final RegistryObject<Item> ENDERITE_FRAGMENT = ITEMS.register("enderite_fragment", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant()));
	public static final RegistryObject<BlockItem> ENDERITE_BLOCK_ITEM = ITEMS.register("enderite_block", () -> new BlockItem(BlockInit.ENDERITE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));
	public static final RegistryObject<BlockItem> ENDERITE_ORE_ITEM = ITEMS.register("enderite_ore", () -> new BlockItem(BlockInit.ENDERITE_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));
	public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> new SwordItem(ToolMaterialInit.ENDERITE, 2, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> new ShovelItem(ToolMaterialInit.ENDERITE, 0.5f, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
	public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> new PickaxeItem(ToolMaterialInit.ENDERITE, 0, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
	public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> new AxeItem(ToolMaterialInit.ENDERITE, 4, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
	public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> new HoeItem(ToolMaterialInit.ENDERITE, -6, 0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
	public static final RegistryObject<ArmorItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> new EnderiteHelmetItem(ArmorMaterialInit.ENDERITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> new ArmorItem(ArmorMaterialInit.ENDERITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> new ArmorItem(ArmorMaterialInit.ENDERITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> new ArmorItem(ArmorMaterialInit.ENDERITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> OBSIDIAN_INFUSED_ENDERITE_INGOT = ITEMS.register("obsidian_infused_enderite_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant()));
	public static final RegistryObject<BlockItem> OBSIDIAN_INFUSED_ENDERITE_BLOCK_ITEM = ITEMS.register("obsidian_infused_enderite_block", () -> new BlockItem(BlockInit.OBSIDIAN_INFUSED_ENDERITE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant()));
	public static final RegistryObject<SwordItem> OBSIDIAN_INFUSED_ENDERITE_SWORD = ITEMS.register("obsidian_infused_enderite_sword", () -> new SwordItem(ToolMaterialInit.OBSIDIAN_INFUSED, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<ShovelItem> OBSIDIAN_INFUSED_ENDERITE_SHOVEL = ITEMS.register("obsidian_infused_enderite_shovel", () -> new ShovelItem(ToolMaterialInit.OBSIDIAN_INFUSED, 1.5f, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
	public static final RegistryObject<PickaxeItem> OBSIDIAN_INFUSED_ENDERITE_PICKAXE = ITEMS.register("obsidian_infused_enderite_pickaxe", () -> new PickaxeItem(ToolMaterialInit.OBSIDIAN_INFUSED, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
	public static final RegistryObject<AxeItem> OBSIDIAN_INFUSED_ENDERITE_AXE = ITEMS.register("obsidian_infused_enderite_axe", () -> new AxeItem(ToolMaterialInit.OBSIDIAN_INFUSED, 5, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
	public static final RegistryObject<HoeItem> OBSIDIAN_INFUSED_ENDERITE_HOE = ITEMS.register("obsidian_infused_enderite_hoe", () -> new HoeItem(ToolMaterialInit.OBSIDIAN_INFUSED, -6, 1f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS).fireResistant()));
}