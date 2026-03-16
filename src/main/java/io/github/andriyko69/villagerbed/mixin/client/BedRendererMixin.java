package io.github.andriyko69.villagerbed.mixin.client;

import io.github.andriyko69.villagerbed.VillagerBed;
import io.github.andriyko69.villagerbed.registry.ModBlocks;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(BedRenderer.class)
public abstract class BedRendererMixin {
    @Unique
    private static final Material VILLAGERBED$MATERIAL = new Material(
            Sheets.BED_SHEET,
            ResourceLocation.fromNamespaceAndPath(VillagerBed.MOD_ID, "entity/bed/villager_bed")
    );

    @ModifyVariable(
            method = "render(Lnet/minecraft/world/level/block/entity/BedBlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V",
            at = @At("STORE"),
            ordinal = 0
    )
    private Material villagerbed$useCustomTextureForVillagerBed(
            Material original,
            BedBlockEntity blockEntity,
            float partialTick,
            com.mojang.blaze3d.vertex.PoseStack poseStack,
            net.minecraft.client.renderer.MultiBufferSource bufferSource,
            int packedLight,
            int packedOverlay
    ) {
        BlockState state = blockEntity.getBlockState();

        if (state.is(ModBlocks.VILLAGER_BED.get())) {
            return VILLAGERBED$MATERIAL;
        }

        return original;
    }
}