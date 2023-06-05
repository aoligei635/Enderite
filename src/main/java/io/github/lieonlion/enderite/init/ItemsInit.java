package io.github.lieonlion.enderite.init;

import io.github.lieonlion.enderite.Enderite;
import io.github.lieonlion.enderite.item.EnderitePlatedElytraItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ItemsInit {

    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item RAW_ENDERITE = registerItem("raw_enderite",
            new Item(new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_FRAGMENT = registerItem("enderite_fragment",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword",
            new SwordItem(ToolMaterialsInit.ENDERITE, 2, -2.4f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel",
            new ShovelItem(ToolMaterialsInit.ENDERITE, 0.5f, -3f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
            new PickaxeItem(ToolMaterialsInit.ENDERITE, 0, -2.8f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_AXE = registerItem("enderite_axe",
            new AxeItem(ToolMaterialsInit.ENDERITE, 4, -3f,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe",
            new HoeItem(ToolMaterialsInit.ENDERITE, -6, 0f,
                    new FabricItemSettings().fireproof()));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.HELMET,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings().fireproof()));
    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots",
            new ArmorItem(ArmorMaterialsInit.ENDERITE, ArmorItem.Type.BOOTS,
                    new FabricItemSettings().fireproof()));

    public static final Item OBSIDIAN_INFUSED_ENDERITE_INGOT = registerItem("obsidian_infused_enderite_ingot",
            new Item(new FabricItemSettings().fireproof()));

    public static final Item OBSIDIAN_INFUSED_ENDERITE_SWORD = registerItem("obsidian_infused_enderite_sword",
            new SwordItem(ToolMaterialsInit.ENDERITE, 3, -2.4f,
                    new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_SHOVEL = registerItem("obsidian_infused_enderite_shovel",
            new ShovelItem(ToolMaterialsInit.ENDERITE, 1.5f, -3f,
                    new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_PICKAXE = registerItem("obsidian_infused_enderite_pickaxe",
            new PickaxeItem(ToolMaterialsInit.ENDERITE, 1, -2.8f,
                    new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_AXE = registerItem("obsidian_infused_enderite_axe",
            new AxeItem(ToolMaterialsInit.ENDERITE, 5, -3f,
                    new FabricItemSettings().fireproof()));
    public static final Item OBSIDIAN_INFUSED_ENDERITE_HOE = registerItem("obsidian_infused_enderite_hoe",
            new HoeItem(ToolMaterialsInit.ENDERITE, -6, 1f,
                    new FabricItemSettings().fireproof()));

    public static final Item ENDERITE_PLATED_ELYTRA = registerItem("enderite_plated_elytra",
            new EnderitePlatedElytraItem(3, new FabricItemSettings().maxDamage(648).rarity(Rarity.RARE).fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Enderite.MODID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_ENDERITE);
        addToItemGroup(ItemGroups.INGREDIENTS, ENDERITE_FRAGMENT);
        addToItemGroup(ItemGroups.INGREDIENTS, ENDERITE_INGOT);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_PLATED_ELYTRA);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_SHOVEL);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_PICKAXE);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_AXE);
        addToItemGroup(ItemGroups.TOOLS, ENDERITE_HOE);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_SWORD);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_HELMET);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_CHESTPLATE);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_LEGGINGS);
        addToItemGroup(ItemGroups.COMBAT, ENDERITE_BOOTS);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_SHOVEL);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_PICKAXE);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_AXE);
        addToItemGroup(ItemGroups.TOOLS, OBSIDIAN_INFUSED_ENDERITE_HOE);
        addToItemGroup(ItemGroups.COMBAT, OBSIDIAN_INFUSED_ENDERITE_SWORD);
    } private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerItems() {
        Enderite.LOGGER.info("Loading Items for " + Enderite.MODID);
        addItemsToItemGroup();
    }
}