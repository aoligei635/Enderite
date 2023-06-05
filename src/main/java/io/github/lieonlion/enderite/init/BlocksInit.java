package io.github.lieonlion.enderite.init;

import io.github.lieonlion.enderite.Enderite;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlocksInit {
	private BlocksInit() {}
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Enderite.MODID);

	public static final RegistryObject<Block> ENDERITE_BLOCK = BLOCKS.register("enderite_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(60, 1300)));
	public static final RegistryObject<Block> ENDERITE_ORE = BLOCKS.register("enderite_ore", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(35, 1000)));
	public static final RegistryObject<Block> OBSIDIAN_INFUSED_ENDERITE_BLOCK = BLOCKS.register("obsidian_infused_enderite_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(75, 1400)));
}