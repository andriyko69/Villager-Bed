package io.github.andriyko69.villagerbed.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.andriyko69.villagerbed.config.VillagerBedConfig;
import io.github.andriyko69.villagerbed.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StructureTemplate.class)
public abstract class StructureTemplateMixin {
    @WrapOperation(
            method = "placeInWorld",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/ServerLevelAccessor;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"
            )
    )
    private boolean villagerbed$replaceVillageBeds(
            ServerLevelAccessor level,
            BlockPos pos,
            BlockState state,
            int flags,
            Operation<Boolean> original
    ) {
        state = villager_Bed$replaceBed(state);
        return original.call(level, pos, state, flags);
    }

    @Unique
    private static BlockState villager_Bed$replaceBed(BlockState original) {
        Block block = original.getBlock();

        if (!villager_Bed$shouldReplace(block)) {
            return original;
        }

        return ModBlocks.VILLAGER_BED.get().defaultBlockState()
                .setValue(BedBlock.FACING, original.getValue(BedBlock.FACING))
                .setValue(BedBlock.PART, original.getValue(BedBlock.PART))
                .setValue(BedBlock.OCCUPIED, original.getValue(BedBlock.OCCUPIED));
    }

    @Unique
    private static boolean villager_Bed$shouldReplace(Block block) {
        var mode = VillagerBedConfig.BED_REPLACEMENT_MODE.get();

        if (mode == VillagerBedConfig.BedReplacementMode.NONE) {
            return false;
        }

        if (!(block instanceof BedBlock)) {
            return false;
        }

        if (mode == VillagerBedConfig.BedReplacementMode.ALL_BEDS) {
            return true;
        }

        return BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals("minecraft");
    }
}