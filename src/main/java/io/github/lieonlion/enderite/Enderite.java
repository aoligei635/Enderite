package io.github.lieonlion.enderite;

import com.mojang.logging.LogUtils;
import io.github.lieonlion.enderite.Init.BlockInit;
import io.github.lieonlion.enderite.Init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Enderite.MODID)
public class Enderite {
    public static final String MODID = "lolenderite";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Enderite() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemInit.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ItemInit.ENDERITE_BLOCK_ITEM);
            event.accept(ItemInit.OBSIDIAN_INFUSED_ENDERITE_BLOCK_ITEM);
        }
        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ItemInit.ENDERITE_ORE_ITEM);
        }
        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ItemInit.ENDERITE_SHOVEL);
            event.accept(ItemInit.ENDERITE_PICKAXE);
            event.accept(ItemInit.ENDERITE_AXE);
            event.accept(ItemInit.ENDERITE_HOE);
            event.accept(ItemInit.OBSIDIAN_INFUSED_ENDERITE_SHOVEL);
            event.accept(ItemInit.OBSIDIAN_INFUSED_ENDERITE_PICKAXE);
            event.accept(ItemInit.OBSIDIAN_INFUSED_ENDERITE_AXE);
            event.accept(ItemInit.OBSIDIAN_INFUSED_ENDERITE_HOE);
        }
        if(event.getTab() == CreativeModeTabs.COMBAT) {
            event.accept(ItemInit.ENDERITE_SWORD);
            event.accept(ItemInit.OBSIDIAN_INFUSED_ENDERITE_SWORD);
            event.accept(ItemInit.ENDERITE_HELMET);
            event.accept(ItemInit.ENDERITE_CHESTPLATE);
            event.accept(ItemInit.ENDERITE_LEGGINGS);
            event.accept(ItemInit.ENDERITE_BOOTS);
        }
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemInit.RAW_ENDERITE);
            event.accept(ItemInit.ENDERITE_FRAGMENT);
            event.accept(ItemInit.ENDERITE_INGOT);
            event.accept(ItemInit.OBSIDIAN_INFUSED_ENDERITE_INGOT);
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}