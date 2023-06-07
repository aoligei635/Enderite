package io.github.lieonlion.enderite;

import com.mojang.logging.LogUtils;
import io.github.lieonlion.enderite.config.ClientConfigs;
import io.github.lieonlion.enderite.config.CommonConfigs;
import io.github.lieonlion.enderite.init.BlocksInit;
import io.github.lieonlion.enderite.init.ItemsInit;
import io.github.lieonlion.enderite.render.EnderitePlatedElytraLayer;
import io.github.lieonlion.enderite.item.EnderitePlatedElytraItem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Enderite.MODID)
public class Enderite {
    public static final String MODID = "lolenderite";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final ResourceLocation END_CITY_TREASURE_INJECTION_LOCATION = new ResourceLocation(MODID, "inject/chests/end_city_treasure");

    public Enderite() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemsInit.register(modEventBus);
        BlocksInit.BLOCKS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfigs.SPEC, MODID + "-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfigs.SPEC, MODID + "-common.toml");
    }

    @SubscribeEvent
    public void loadLootTables(LootTableLoadEvent event) {
        if (event.getName().equals(BuiltInLootTables.END_CITY_TREASURE) && CommonConfigs.END_CITY_LOOT.get()) {
            event.getTable().addPool(LootPool.lootPool()
                    .add(LootTableReference.lootTableReference(Enderite.END_CITY_TREASURE_INJECTION_LOCATION))
                    .name(Enderite.MODID + "_injection").build());
        }
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ItemsInit.ENDERITE_BLOCK_ITEM);
            event.accept(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_BLOCK_ITEM);
        }
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ItemsInit.ENDERITE_ORE_ITEM);
        }
        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemsInit.ENDERITE_PLATED_ELYTRA);
            event.accept(ItemsInit.ENDERITE_SHOVEL);
            event.accept(ItemsInit.ENDERITE_PICKAXE);
            event.accept(ItemsInit.ENDERITE_AXE);
            event.accept(ItemsInit.ENDERITE_HOE);
            event.accept(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_SHOVEL);
            event.accept(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_PICKAXE);
            event.accept(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_AXE);
            event.accept(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_HOE);
        }
        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ItemsInit.ENDERITE_SWORD);
            event.accept(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_SWORD);
            event.accept(ItemsInit.ENDERITE_HELMET);
            event.accept(ItemsInit.ENDERITE_CHESTPLATE);
            event.accept(ItemsInit.ENDERITE_LEGGINGS);
            event.accept(ItemsInit.ENDERITE_BOOTS);
        }
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemsInit.RAW_ENDERITE);
            event.accept(ItemsInit.ENDERITE_FRAGMENT);
            event.accept(ItemsInit.ENDERITE_INGOT);
            event.accept(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_INGOT);
        }
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegistryEventsClient {
        @SubscribeEvent
        public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
            ItemProperties.register(ItemsInit.ENDERITE_PLATED_ELYTRA.get(), new ResourceLocation(Enderite.MODID, "broken"),
                    (itemStack, clientWorld, livingEntity, seed) -> EnderitePlatedElytraItem.isUseable(itemStack) ? 0 : 1);
        }

        @SubscribeEvent(priority = EventPriority.LOW)
        public static void renderPlayer(final EntityRenderersEvent.AddLayers event) {
            LivingEntityRenderer<AbstractClientPlayer, EntityModel<AbstractClientPlayer>> renderer = event.getSkin("default");
            EnderitePlatedElytraLayer<AbstractClientPlayer, EntityModel<AbstractClientPlayer>> layer = new EnderitePlatedElytraLayer<>(
                    renderer, event.getEntityModels());
            if (renderer != null) {
                renderer.addLayer(layer);
            }

            renderer = event.getSkin("slim");
            layer = new EnderitePlatedElytraLayer<>(renderer, event.getEntityModels());
            if (renderer != null) {
                renderer.addLayer(layer);
            }

            addEntityLayer(event, EntityType.ARMOR_STAND);
            addEntityLayer(event, EntityType.ZOMBIE);
            addEntityLayer(event, EntityType.ZOMBIE_VILLAGER);
            addEntityLayer(event, EntityType.SKELETON);
            addEntityLayer(event, EntityType.HUSK);
            addEntityLayer(event, EntityType.STRAY);
            addEntityLayer(event, EntityType.WITHER_SKELETON);
            addEntityLayer(event, EntityType.DROWNED);
            addEntityLayer(event, EntityType.PIGLIN);
            addEntityLayer(event, EntityType.PIGLIN_BRUTE);
            addEntityLayer(event, EntityType.ZOMBIFIED_PIGLIN);
        }

        private static <T extends LivingEntity, M extends EntityModel<T>, R extends LivingEntityRenderer<T, M>> void addEntityLayer(
                EntityRenderersEvent.AddLayers evt, EntityType<? extends T> entityType) {
            R renderer = evt.getRenderer(entityType);

            if (renderer != null) {
                renderer.addLayer(new EnderitePlatedElytraLayer<>(renderer, evt.getEntityModels()));
            }
        }
    }
}