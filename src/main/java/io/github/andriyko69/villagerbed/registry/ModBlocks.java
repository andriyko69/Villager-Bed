package io.github.andriyko69.villagerbed.registry;

import io.github.andriyko69.villagerbed.VillagerBed;
import io.github.andriyko69.villagerbed.block.VillagerBedBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(VillagerBed.MOD_ID);

    public static final DeferredBlock<Block> VILLAGER_BED = BLOCKS.register("villager_bed",
            () -> new VillagerBedBlock(
                    DyeColor.WHITE,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.WOOL)
                            .strength(0.2F)
                            .noOcclusion()
                            .ignitedByLava()
            )
    );

    private ModBlocks() {
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}