package io.github.lieonlion.enderite.core.world;

import com.google.common.base.Suppliers;

import io.github.lieonlion.enderite.Enderite;
import io.github.lieonlion.enderite.core.init.BlockInit;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ConfiguredFeatureInit {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Enderite.MODID);

    private static final Supplier<List<OreConfiguration.TargetBlockState>> ENDERITE_ORE = Suppliers.memoize(() ->
            List.of(
                    OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), BlockInit.ENDERITE_ORE.get().defaultBlockState())
            )
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> ENDERITE_ORE_CON = CONFIGURED_FEATURES.register("enderite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ENDERITE_ORE.get(), 3)));
}