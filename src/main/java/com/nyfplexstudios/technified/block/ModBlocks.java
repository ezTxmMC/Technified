package com.nyfplexstudios.technified.block;

import com.nyfplexstudios.technified.Technified;
import lombok.Getter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

@Getter
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Technified.MODID);

    private final DeferredBlock<Block> techniteOre;
    private final DeferredBlock<Block> deepslateTechniteOre;
    private final DeferredBlock<Block> techniteBlock;

    public ModBlocks(IEventBus eventBus) {
        this.techniteOre = BLOCKS.register("technite_ore", () -> new Block(BlockBehaviour.Properties.of()
                .destroyTime(3.0F)
                .explosionResistance(10.0F)
                .sound(SoundType.STONE)
                .lightLevel((state) -> 0)
                .requiresCorrectToolForDrops()));
        this.deepslateTechniteOre = BLOCKS.register("deepslate_technite_ore", () -> new Block(BlockBehaviour.Properties.of()
                .destroyTime(3.0F)
                .explosionResistance(10.0F)
                .sound(SoundType.STONE)
                .lightLevel((state) -> 0)
                .requiresCorrectToolForDrops()));
        this.techniteBlock = BLOCKS.register("technite_block", () -> new Block(BlockBehaviour.Properties.of()
                .destroyTime(4.0F)
                .explosionResistance(10.0F)
                .sound(SoundType.STONE)
                .lightLevel((state) -> 0)
                .requiresCorrectToolForDrops()));
        BLOCKS.register(eventBus);
    }
}
