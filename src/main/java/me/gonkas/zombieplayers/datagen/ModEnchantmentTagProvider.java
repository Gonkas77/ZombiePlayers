package me.gonkas.zombieplayers.datagen;

import me.gonkas.zombieplayers.registry.ModEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModEnchantmentTagProvider extends FabricTagProvider.EnchantmentTagProvider {
    public ModEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.ENCHANTMENT, Identifier.of("fabric", "damage")))
                .add(ModEnchantments.HOLY_STRIKE);

        getOrCreateTagBuilder(EnchantmentTags.DAMAGE_EXCLUSIVE_SET)
                .add(ModEnchantments.HOLY_STRIKE);
    }
}
