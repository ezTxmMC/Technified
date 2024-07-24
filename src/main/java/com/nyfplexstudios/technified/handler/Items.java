package com.nyfplexstudios.technified.handler;

import lombok.Getter;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Getter
public class Items {
    private final DeferredItem<Item> technicalCore;
    private final DeferredItem<Item> techniteRaw;
    private final DeferredItem<Item> techniteIngot;

    public Items(DeferredRegister.Items items) {
        this.technicalCore = items.register("technical_core", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
        this.techniteRaw = items.register("technite_raw", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
        this.techniteIngot = items.register("technite_ingot", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    }
}
