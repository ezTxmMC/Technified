package com.nyfplexstudios.technified.item;

import com.nyfplexstudios.technified.Technified;
import lombok.Getter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Getter
public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Technified.MODID);

    private final DeferredItem<Item> technicalCore;
    private final DeferredItem<Item> techniteRaw;
    private final DeferredItem<Item> techniteIngot;
    private final DeferredItem<BlockItem> techniteOre;
    private final DeferredItem<BlockItem> deepslateTechniteOre;
    private final DeferredItem<BlockItem> techniteBlock;

    public ModItems(IEventBus eventBus) {
        this.technicalCore = ITEMS.register("technical_core", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
        this.techniteRaw = ITEMS.register("technite_raw", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
        this.techniteIngot = ITEMS.register("technite_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
        this.techniteOre = ITEMS.register("technite_ore", () -> new BlockItem(Technified.getModBlocks().getTechniteOre().get(), new BlockItem.Properties()));
        this.deepslateTechniteOre = ITEMS.register("deepslate_technite_block", () -> new BlockItem(Technified.getModBlocks().getDeepslateTechniteOre().get(), new BlockItem.Properties()));
        this.techniteBlock = ITEMS.register("technite_block", () -> new BlockItem(Technified.getModBlocks().getTechniteBlock().get(), new BlockItem.Properties()));
        ITEMS.register(eventBus);
    }
}
