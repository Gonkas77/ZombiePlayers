package me.gonkas.zombieplayers.registry;

import me.gonkas.zombieplayers.ZombiePlayers;
import me.gonkas.zombieplayers.block.SynthesizerBEBlock;
import me.gonkas.zombieplayers.block.entity.SynthesizerBlockEntity;
import me.gonkas.zombieplayers.util.ZombiePlayersIdentifier;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ZombiePlayerBlockEntities {

    public static final BlockEntityType<SynthesizerBlockEntity> SYNTHESIZER_BLOCK_ENTITY = register("synthesizer_block_entity",
            BlockEntityType.Builder.create(SynthesizerBlockEntity::new, ZombiePlayersBlocks.SYNTHESIZER)
                    .build()
    );

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, ZombiePlayersIdentifier.of(name), type);
    }

    public static void registerBlockEntities() {
        ZombiePlayers.logRegistration("block entities");
    }
}
