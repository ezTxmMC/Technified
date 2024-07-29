package com.nyfplexstudios.technified.item;

import com.nyfplexstudios.technified.Technified;
import lombok.Getter;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Getter
public class ModItemTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Technified.MODID);

    private final DeferredHolder<CreativeModeTab, CreativeModeTab> mainTab;

    public ModItemTabs(IEventBus eventBus) {
        this.mainTab = CREATIVE_MODE_TABS.register("main_tab", () -> CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.technified"))
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon(() -> Technified.getModItems().getTechnicalCore().get().getDefaultInstance())
                .displayItems((parameters, output) -> {
                    output.accept(Technified.getModItems().getTechnicalCore().get());
                    output.accept(Technified.getModItems().getTechniteRaw().get());
                    output.accept(Technified.getModItems().getTechniteIngot().get());
                }).build());
        eventBus.register(CREATIVE_MODE_TABS);
    }
}
