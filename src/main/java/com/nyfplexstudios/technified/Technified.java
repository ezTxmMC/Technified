package com.nyfplexstudios.technified;

import com.mojang.logging.LogUtils;
import com.nyfplexstudios.technified.handler.DataGenerators;
import com.nyfplexstudios.technified.handler.ItemTabs;
import com.nyfplexstudios.technified.handler.Items;
import lombok.Getter;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

import java.util.Random;

@Mod(Technified.MODID)
public class Technified {
    public static final String MODID = "technified";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    @Getter private static Items items;
    @Getter private static ItemTabs itemTabs;


    public Technified(IEventBus modEventBus, ModContainer modContainer) {
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        items = new Items(ITEMS);
        itemTabs = new ItemTabs(CREATIVE_MODE_TABS);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(DataGenerators::gatherData);
    }

    @SubscribeEvent
    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ModList.get().getModContainerById(MODID).ifPresent(modContainer -> {
                LOGGER.info("Setup {} on version {}", modContainer.getModId(), modContainer.getModInfo().getVersion());
            });
        });
    }
}
