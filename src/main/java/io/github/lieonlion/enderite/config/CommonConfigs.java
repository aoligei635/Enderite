package io.github.lieonlion.enderite.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> END_CITY_LOOT;

    static {
        BUILDER.push("Config for Enderite");

            BUILDER.push("Enderite Misc");
            END_CITY_LOOT = BUILDER.comment("Allow Enderite items to generate in End City Chests - default | true")
                    .define("Enderite in End City Loot", true);
            BUILDER.pop();

        SPEC = BUILDER.build();
    }
}