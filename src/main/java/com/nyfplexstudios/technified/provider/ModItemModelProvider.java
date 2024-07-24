package com.nyfplexstudios.technified.provider;

import com.nyfplexstudios.technified.Technified;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Technified.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(Technified.getItems().getTechnicalCore().get());
        item(Technified.getItems().getTechniteRaw().get());
        item(Technified.getItems().getTechniteIngot().get());
    }

    private void item(Item item) {
        getBuilder(getItemName(item)).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "item/" + getItemName(item));
    }

    private String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(Technified.MODID + ":", "");
    }
}
