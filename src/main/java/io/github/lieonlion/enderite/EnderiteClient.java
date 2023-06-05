package io.github.lieonlion.enderite;

import io.github.lieonlion.enderite.init.ItemsInit;
import io.github.lieonlion.enderite.item.EnderitePlatedElytraItem;
import io.github.lieonlion.enderite.render.EnderitePlatedElytraRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

public class EnderiteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelPredicateProviderRegistry.register(ItemsInit.ENDERITE_PLATED_ELYTRA.asItem(),
                new Identifier(Enderite.MODID, "broken"),
                (itemStack, clientWorld, livingEntity, seed) -> {
                    return EnderitePlatedElytraItem.isUsable(itemStack) ? 0.0F : 1.0F;
        });
        LivingEntityFeatureRendererRegistrationCallback.EVENT
                .register((entityType, entityRenderer, registrationHelper, context) -> {
                    registrationHelper
                            .register(new EnderitePlatedElytraRenderer<>(entityRenderer,
                                    context.getModelLoader()));
                });
        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register((player) -> this.allowCapeRender(player));
    }

    private static final boolean allowCapeRender(AbstractClientPlayerEntity player) {
        return !(player.getEquippedStack(EquipmentSlot.CHEST).isOf(ItemsInit.ENDERITE_PLATED_ELYTRA));
    }
}