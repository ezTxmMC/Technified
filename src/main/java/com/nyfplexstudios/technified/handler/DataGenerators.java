package com.nyfplexstudios.technified.handler;

import com.nyfplexstudios.technified.Technified;
import com.nyfplexstudios.technified.provider.ModItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {

    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator dataGenerator = event.getGenerator();
            PackOutput packOutput = dataGenerator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            dataGenerator.addProvider(true, new ModItemModelProvider(packOutput, existingFileHelper));
        } catch (RuntimeException e) {
            Technified.LOGGER.error("Failed to gather data", e);
        }
    }
}
