package io.github.lieonlion.enderite.init;

import io.github.lieonlion.enderite.Enderite;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class BlocksInit {

    public static final Block ENDERITE_BLOCK = registerBlock("enderite_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.MAGENTA).strength(60, 1300).requiresTool()), ItemGroups.BUILDING_BLOCKS);
    public static final Block ENDERITE_ORE = registerBlock("enderite_ore",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.MAGENTA).strength(35, 1000).requiresTool()), ItemGroups.BUILDING_BLOCKS);
    public static final Block OBSIDIAN_INFUSED_ENDERITE_BLOCK = registerBlock("obsidian_infused_enderite_block",
            new Block(FabricBlockSettings.of(Material.METAL, MapColor.MAGENTA).strength(75, 1400).requiresTool()), ItemGroups.BUILDING_BLOCKS);


    public static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Enderite.MODID, name), block);
    } public static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Enderite.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerBlocks() {
        Enderite.LOGGER.info("Loading Blocks for " + Enderite.MODID);
    }
}
