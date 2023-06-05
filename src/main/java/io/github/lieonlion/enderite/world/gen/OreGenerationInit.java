package io.github.lieonlion.enderite.world.gen;

import io.github.lieonlion.enderite.world.PlacedFeatureInit;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class OreGenerationInit {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES, PlacedFeatureInit.ENDERITE_ORE_PLACED_KEY);
    }
}