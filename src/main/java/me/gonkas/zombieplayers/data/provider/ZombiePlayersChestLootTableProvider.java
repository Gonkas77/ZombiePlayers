package me.gonkas.zombieplayers.data.provider;

import me.gonkas.zombieplayers.util.ZombiePlayersIdentifier;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ZombiePlayersChestLootTableProvider extends SimpleFabricLootTableProvider {
    public ZombiePlayersChestLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup, LootContextTypes.CHEST);
    }

    private static final RegistryKey<LootTable> DESERT_WELL_CHEST = RegistryKey.of(RegistryKeys.LOOT_TABLE, ZombiePlayersIdentifier.of("desert_well_chest"));

    @Override
    public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> lootTableBiConsumer) {
        lootTableBiConsumer.accept(DESERT_WELL_CHEST, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls()
                        .build())
        );
    }
}
