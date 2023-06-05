package io.github.lieonlion.enderite.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> ALLOW_CAPE_TEXTURE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> RECOLOUR_ELYTRA;

    static {
        BUILDER.push("Config for Enderite");

        BUILDER.push("Enderite Plated Elytra");
        ALLOW_CAPE_TEXTURE = BUILDER.comment("Allow the cape elytra texture to effect Enderite Plated Elytra - default | true")
                        .define("Allow Cape Texture", true);
        RECOLOUR_ELYTRA = BUILDER.comment("Use the recoloured vanilla texture version of Enderite Plated Elytra - default | false")
                .define("Recoloured Elytra", false);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
