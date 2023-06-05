package io.github.lieonlion.enderite;

import io.github.lieonlion.enderite.config.Configs;
import io.github.lieonlion.enderite.init.BlocksInit;
import io.github.lieonlion.enderite.init.ItemsInit;
import io.github.lieonlion.enderite.world.gen.WorldGenerationInit;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootTables;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Enderite implements ModInitializer {
	public static final String MODID = "lolenderite";
	public static final Logger LOGGER = LoggerFactory.getLogger("lolenderite");
	public static final Identifier END_CITY_TREASURE_INJECTION_LOCATION = new Identifier(MODID, "inject/chests/end_city_treasure");

	@Override
	public void onInitialize() {
		Configs.registerConfigs();
		ItemsInit.registerItems();
		BlocksInit.registerBlocks();
		WorldGenerationInit.generateModWorldGen();
		LOGGER.info(MODID + " has loaded");

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (id.equals(LootTables.END_CITY_TREASURE_CHEST) && Configs.END_CITY_LOOT) {
				var pools = List.of(lootManager.getTable(Enderite.END_CITY_TREASURE_INJECTION_LOCATION).pools);
				tableBuilder.pools(pools);
			}
		});
	}
}