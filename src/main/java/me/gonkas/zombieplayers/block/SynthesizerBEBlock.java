package me.gonkas.zombieplayers.block;

import me.gonkas.zombieplayers.block.entity.SynthesizerBlockEntity;
import me.gonkas.zombieplayers.registry.ZombiePlayerBlockEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SynthesizerBEBlock extends Block implements BlockEntityProvider {

    public SynthesizerBEBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof SynthesizerBlockEntity synthesizerBlockEntity && player != null) {

            }
        } return ActionResult.success(world.isClient);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ZombiePlayerBlockEntities.SYNTHESIZER_BLOCK_ENTITY.instantiate(pos, state);
    }
}
