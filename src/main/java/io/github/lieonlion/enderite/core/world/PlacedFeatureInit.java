package io.github.lieonlion.enderite.core.world;

import io.github.lieonlion.enderite.Enderite;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class PlacedFeatureInit {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, Enderite.MODID);

    public static final RegistryObject<PlacedFeature> ENDERITE_ORE = PLACED_FEATURES.register("enderite_ore_placed",
            () -> new PlacedFeature(ConfiguredFeatureInit.ENDERITE_ORE_CON.getHolder().get(),
                    commonOrePlacement(2, HeightRangePlacement.triangle(
                    		VerticalAnchor.absolute(10), 
                    		VerticalAnchor.absolute(20)
                    ))));

    private static List<PlacementModifier> commonOrePlacement(int countPerChunk, PlacementModifier height) {
        return orePlacement(CountPlacement.of(countPerChunk), height);
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }
}