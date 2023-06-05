package io.github.lieonlion.enderite.config;

import com.mojang.datafixers.util.Pair;
import io.github.lieonlion.enderite.Enderite;

public class Configs {
    public static SimpleConfig CONFIG;
    private static ConfigProvider configs;

    public static boolean END_CITY_LOOT;
    public static boolean ALLOW_CAPE_TEXTURE;
    public static boolean RECOLOUR_ELYTRA;

    public static void registerConfigs() {
        configs = new ConfigProvider();
        createConfigs();
        CONFIG = SimpleConfig.of(Enderite.MODID + "-config").provider(configs).request();
        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("enderite.end.city.loot", true), "boolean");
        configs.addKeyValuePair(new Pair<>("allow.cape.texture", true), "boolean");
        configs.addKeyValuePair(new Pair<>("recolour.elytra", false), "boolean");
    }

    private static void assignConfigs() {
        ALLOW_CAPE_TEXTURE = CONFIG.getOrDefault("enderite.end.city.loot", true);
        ALLOW_CAPE_TEXTURE = CONFIG.getOrDefault("allow.cape.texture", true);
        RECOLOUR_ELYTRA = CONFIG.getOrDefault("recolour.elytra", false);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}