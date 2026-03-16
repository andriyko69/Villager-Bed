package io.github.andriyko69.villagerbed;

import io.github.andriyko69.villagerbed.registry.ModBlocks;
import io.github.andriyko69.villagerbed.registry.ModItems;
import io.github.andriyko69.villagerbed.setup.ModPoiSetup;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(VillagerBed.MOD_ID)
public final class VillagerBed {
    public static final String MOD_ID = "villagerbed";

    public VillagerBed(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, io.github.andriyko69.villagerbed.config.VillagerBedConfig.SPEC);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(ModPoiSetup::registerVillagerBedToHomePoi);
    }
}