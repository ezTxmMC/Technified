package com.nyfplexstudios.technified;

import com.mojang.logging.LogUtils;
import com.nyfplexstudios.technified.block.ModBlocks;
import com.nyfplexstudios.technified.item.ModItemTabs;
import com.nyfplexstudios.technified.item.ModItems;
import lombok.Getter;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;

@Mod(Technified.MODID)
public class Technified {
    public static final String MODID = "technified";
    public static final Logger LOGGER = LogUtils.getLogger();

    @Getter private static ModBlocks modBlocks;
    @Getter private static ModItems modItems;
    @Getter private static ModItemTabs modItemTabs;

    public Technified(IEventBus eventBus, ModContainer container) {
        modBlocks = new ModBlocks(eventBus);
        modItems = new ModItems(eventBus);
        modItemTabs = new ModItemTabs(eventBus);
    }
}
