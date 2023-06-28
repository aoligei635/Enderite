package io.github.lieonlion.enderite.init;

import io.github.lieonlion.enderite.Enderite;
import io.github.lieonlion.enderite.item.EnderiteHelmetItem;
import io.github.lieonlion.enderite.item.EnderitePlatedElytraItem;
import io.github.lieonlion.enderite.item.EnderiteSmithingTemplateItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemsInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Enderite.MODID);

    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> RAW_ENDERITE = ITEMS.register("raw_enderite", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_FRAGMENT = ITEMS.register("enderite_fragment", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> ENDERITE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("enderite_upgrade_smithing_template", () -> EnderiteSmithingTemplateItem.createEnderiteUpgrade());
    public static final RegistryObject<BlockItem> ENDERITE_BLOCK_ITEM = ITEMS.register("enderite_block", () -> new BlockItem(BlocksInit.ENDERITE_BLOCK.get(), new Item.Properties().fireResistant()));
    public static final RegistryObject<BlockItem> ENDERITE_ORE_ITEM = ITEMS.register("enderite_ore", () -> new BlockItem(BlocksInit.ENDERITE_ORE.get(), new Item.Properties().fireResistant()));
    public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> new SwordItem(ToolMaterialsInit.ENDERITE, 2, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> new ShovelItem(ToolMaterialsInit.ENDERITE, 0.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> new PickaxeItem(ToolMaterialsInit.ENDERITE, 0, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> new AxeItem(ToolMaterialsInit.ENDERITE, 4, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> new HoeItem(ToolMaterialsInit.ENDERITE, -6, 0f, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> new EnderiteHelmetItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings", () -> new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant()));
    public static final RegistryObject<ArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> OBSIDIAN_INFUSED_ENDERITE_INGOT = ITEMS.register("obsidian_infused_enderite_ingot", () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<BlockItem> OBSIDIAN_INFUSED_ENDERITE_BLOCK_ITEM = ITEMS.register("obsidian_infused_enderite_block", () -> new BlockItem(BlocksInit.OBSIDIAN_INFUSED_ENDERITE_BLOCK.get(), new Item.Properties().fireResistant()));
    public static final RegistryObject<SwordItem> OBSIDIAN_INFUSED_ENDERITE_SWORD = ITEMS.register("obsidian_infused_enderite_sword", () -> new SwordItem(ToolMaterialsInit.OBSIDIAN_INFUSED, 3, -2.4f, new Item.Properties().fireResistant()));
    public static final RegistryObject<ShovelItem> OBSIDIAN_INFUSED_ENDERITE_SHOVEL = ITEMS.register("obsidian_infused_enderite_shovel", () -> new ShovelItem(ToolMaterialsInit.OBSIDIAN_INFUSED, 1.5f, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<PickaxeItem> OBSIDIAN_INFUSED_ENDERITE_PICKAXE = ITEMS.register("obsidian_infused_enderite_pickaxe", () -> new PickaxeItem(ToolMaterialsInit.OBSIDIAN_INFUSED, 1, -2.8f, new Item.Properties().fireResistant()));
    public static final RegistryObject<AxeItem> OBSIDIAN_INFUSED_ENDERITE_AXE = ITEMS.register("obsidian_infused_enderite_axe", () -> new AxeItem(ToolMaterialsInit.OBSIDIAN_INFUSED, 5, -3f, new Item.Properties().fireResistant()));
    public static final RegistryObject<HoeItem> OBSIDIAN_INFUSED_ENDERITE_HOE = ITEMS.register("obsidian_infused_enderite_hoe", () -> new HoeItem(ToolMaterialsInit.OBSIDIAN_INFUSED, -6, 1f, new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ENDERITE_PLATED_ELYTRA = ITEMS.register("enderite_plated_elytra",
            () -> new EnderitePlatedElytraItem(3 ,new Item.Properties().durability(648).rarity(Rarity.RARE).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}