package io.github.andriyko69.villagerbed.setup;

import io.github.andriyko69.villagerbed.mixin.PoiTypesAccessor;
import io.github.andriyko69.villagerbed.registry.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;

import java.util.Map;

public final class ModPoiSetup {
    private ModPoiSetup() {
    }

    public static void registerVillagerBedToHomePoi() {
        Holder<PoiType> homeHolder = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolderOrThrow(PoiTypes.HOME);
        Map<BlockState, Holder<PoiType>> typeByState = PoiTypesAccessor.villagerbed$getTypeByState();

        for (BlockState state : ModBlocks.VILLAGER_BED.get().getStateDefinition().getPossibleStates()) {
            if (state.getValue(BedBlock.PART) == BedPart.HEAD) {
                typeByState.put(state, homeHolder);
            }
        }
    }
}