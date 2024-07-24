package com.nyfplexstudios.technified.handler;

import com.nyfplexstudios.technified.Technified;
import lombok.Getter;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Getter
public class ItemTabs {
    private final DeferredHolder<CreativeModeTab, CreativeModeTab> mainTab;

    public ItemTabs(DeferredRegister<CreativeModeTab> creativeModeTabs) {
        this.mainTab = creativeModeTabs.register("main_tab", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.technified"))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> Technified.getItems().getTechnicalCore().get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(Technified.getItems().getTechnicalCore().get());
                    output.accept(Technified.getItems().getTechniteRaw().get());
                    output.accept(Technified.getItems().getTechniteIngot().get());
                }).build());
    }
}
