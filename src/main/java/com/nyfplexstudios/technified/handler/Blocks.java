package com.nyfplexstudios.technified.handler;

import com.nyfplexstudios.technified.Technified;
import lombok.Getter;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Getter
public class Blocks {
    private final DeferredRegister.Blocks blocks;
    private final DeferredBlock<Block> techniteOre;
    private final DeferredBlock<Block> deepslateTechniteOre;
    private final DeferredBlock<Block> techniteBlock;

    public Blocks(DeferredRegister.Blocks blocks) {
        this.blocks = blocks;
        this.techniteOre = registerBlock("technite_ore", () -> new Block(BlockBehaviour.Properties.of()
                .destroyTime(3.0F)
                .explosionResistance(10.0F)
                .sound(SoundType.STONE)
                .lightLevel((state) -> 0)
                .requiresCorrectToolForDrops()));
        this.deepslateTechniteOre = registerBlock("deepslate_technite_ore", () -> new Block(BlockBehaviour.Properties.of()
                .destroyTime(3.0F)
                .explosionResistance(10.0F)
                .sound(SoundType.STONE)
                .lightLevel((state) -> 0)
                .requiresCorrectToolForDrops()));
        this.techniteBlock = registerBlock("technite_block", () -> new Block(BlockBehaviour.Properties.of()
                .destroyTime(4.0F)
                .explosionResistance(10.0F)
                .sound(SoundType.STONE)
                .lightLevel((state) -> 0)
                .requiresCorrectToolForDrops()));
    }

    private DeferredBlock<Block> registerBlock(String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = this.blocks.register(name, block);
        Technified.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }
}
