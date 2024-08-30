package me.gonkas.zombieplayers.data.provider;

import me.gonkas.zombieplayers.registry.ZombiePlayersTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ZombiePlayersItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(ZombiePlayersTags.Items.HOLY_STRIKE_COMPATIBLE)
                .forceAddTag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .forceAddTag(ItemTags.TRIDENT_ENCHANTABLE);
    }
}
