package io.github.andriyko69.villagerbed.event;

import io.github.andriyko69.villagerbed.VillagerBed;
import io.github.andriyko69.villagerbed.registry.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

@EventBusSubscriber(modid = VillagerBed.MOD_ID)
public final class ModBlockEntityValidBlocks {
    private ModBlockEntityValidBlocks() {
    }

    @SubscribeEvent
    public static void onBlockEntityValidBlocks(BlockEntityTypeAddBlocksEvent event) {
        event.modify(BlockEntityType.BED, ModBlocks.VILLAGER_BED.get());
    }
}