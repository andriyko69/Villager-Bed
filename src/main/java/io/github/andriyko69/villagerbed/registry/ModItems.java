package io.github.andriyko69.villagerbed.registry;

import io.github.andriyko69.villagerbed.VillagerBed;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VillagerBed.MOD_ID);

    public static final DeferredItem<Item> VILLAGER_BED = ITEMS.register("villager_bed",
            () -> new BlockItem(ModBlocks.VILLAGER_BED.get(), new Item.Properties()));

    private ModItems() {
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}