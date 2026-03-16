package io.github.andriyko69.villagerbed.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class VillagerBedBlock extends BedBlock {
    private static final MapCodec<VillagerBedBlock> CODEC = simpleCodec(
            properties -> new VillagerBedBlock(DyeColor.WHITE, properties)
    );

    public VillagerBedBlock(DyeColor color, BlockBehaviour.Properties properties) {
        super(color, properties);
    }

    @Override
    @SuppressWarnings("unchecked")
    public MapCodec<BedBlock> codec() {
        return (MapCodec<BedBlock>) (MapCodec<?>) CODEC;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            player.displayClientMessage(
                    Component.translatable("message.villagerbed.cannot_sleep"),
                    true
            );
        }
        return InteractionResult.SUCCESS;
    }
}