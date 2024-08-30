package me.gonkas.zombieplayers.data.provider;

import me.gonkas.zombieplayers.registry.ZombiePlayersEntities;
import me.gonkas.zombieplayers.registry.ZombiePlayersTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {
    public ZombiePlayersEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ZombiePlayersTags.EntityTypes.SENSITIVE_TO_HOLY_STRIKE)
                .add(ZombiePlayersEntities.ZOMBIFIED_PLAYER);
    }
}
