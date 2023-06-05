package io.github.lieonlion.enderite.render;

import io.github.lieonlion.enderite.Enderite;
import io.github.lieonlion.enderite.config.Configs;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class EnderitePlatedElytraRenderer <T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private static final Identifier ELYTRA = new Identifier(Enderite.MODID, "textures/entity/enderite_plated_elytra.png");
    private static final Identifier RECOLOUR = new Identifier(Enderite.MODID, "textures/entity/enderite_plated_elytra_recolour.png");
    private final ElytraEntityModel<T> elytra;

    public EnderitePlatedElytraRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader) {
        super(context);
        this.elytra = new ElytraEntityModel(loader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.isOf(ItemsInit.ENDERITE_PLATED_ELYTRA)) {
            Identifier identifier4;
            if (livingEntity instanceof AbstractClientPlayerEntity) {
                AbstractClientPlayerEntity abstractClientPlayerEntity = (AbstractClientPlayerEntity) livingEntity;
                if (abstractClientPlayerEntity.canRenderElytraTexture()
                        && abstractClientPlayerEntity.getElytraTexture() != null) {
                    identifier4 = abstractClientPlayerEntity.getElytraTexture();
                } else if (abstractClientPlayerEntity.canRenderCapeTexture()
                        && abstractClientPlayerEntity.getCapeTexture() != null
                        && abstractClientPlayerEntity.isPartVisible(PlayerModelPart.CAPE) && Configs.ALLOW_CAPE_TEXTURE) {
                    identifier4 = abstractClientPlayerEntity.getCapeTexture();
                } else if (Configs.RECOLOUR_ELYTRA) {
                    identifier4 = RECOLOUR;
                } else {
                    identifier4 = ELYTRA;
                }
            } else if (Configs.RECOLOUR_ELYTRA) {
                identifier4 = RECOLOUR;
            } else {
                identifier4 = ELYTRA;
            }

            matrixStack.push();
            matrixStack.translate(0.0, 0.0, 0.125);
            ((EntityModel) this.getContextModel()).copyStateTo(this.elytra);
            this.elytra.setAngles(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider,
                    this.elytra.getLayer(identifier4), false, itemStack.hasGlint());
            this.elytra.render(matrixStack, vertexConsumer, i,
                    OverlayTexture.DEFAULT_UV, 1.0f,
                    1.0f, 1.0f, 1.0f);
            matrixStack.pop();
        }
    }
}
