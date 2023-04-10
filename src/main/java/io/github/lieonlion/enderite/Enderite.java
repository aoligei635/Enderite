package io.github.lieonlion.enderite;

import io.github.lieonlion.enderite.core.init.BlockInit;
import io.github.lieonlion.enderite.core.init.ItemInit;
import io.github.lieonlion.enderite.core.world.ConfiguredFeatureInit;
import io.github.lieonlion.enderite.core.world.PlacedFeatureInit;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Enderite.MODID)
public class Enderite {
	public static final String MODID = "lolenderite";
	public Enderite() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		ConfiguredFeatureInit.CONFIGURED_FEATURES.register(bus);
		PlacedFeatureInit.PLACED_FEATURES.register(bus);
	}
}