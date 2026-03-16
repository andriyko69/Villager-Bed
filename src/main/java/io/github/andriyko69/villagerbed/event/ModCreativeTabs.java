package io.github.andriyko69.villagerbed.event;

import io.github.andriyko69.villagerbed.VillagerBed;
import io.github.andriyko69.villagerbed.registry.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(modid = VillagerBed.MOD_ID)
public final class ModCreativeTabs {
    private ModCreativeTabs() {
    }

    @SubscribeEvent
    public static void buildCreativeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() != CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            return;
        }

        event.insertAfter(
                Items.PINK_BED.getDefaultInstance(),
                ModItems.VILLAGER_BED.get().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
        );
    }
}