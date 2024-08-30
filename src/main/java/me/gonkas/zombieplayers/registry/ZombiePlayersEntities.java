package me.gonkas.zombieplayers.registry;

import me.gonkas.zombieplayers.ZombiePlayers;
import me.gonkas.zombieplayers.entity.ZombifiedPlayerEntity;
import me.gonkas.zombieplayers.util.ZombiePlayersIdentifier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ZombiePlayersEntities {

    public static final EntityType<ZombifiedPlayerEntity> ZOMBIFIED_PLAYER = register(
            ZombiePlayersIdentifier.of("zombified_player"),
            EntityType.Builder.<ZombifiedPlayerEntity>create(SpawnGroup.MISC)
                    .disableSaving()
                    .disableSummon()
                    .dimensions(0.6f, 1.8f)
                    .eyeHeight(1.62f)
                    .vehicleAttachment(PlayerEntity.VEHICLE_ATTACHMENT_POS)
                    .maxTrackingRange(32)
                    .trackingTickInterval(2)
    );

    private static <T extends Entity> EntityType<T> register(Identifier id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, id, type.build(id.getPath()));
    }

    public static void registerEntities() {
        ZombiePlayers.logRegistration("entities");;
    }
}
