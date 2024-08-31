package me.gonkas.zombieplayers.data.provider.lang.dutch;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersDutchBEProvider extends FabricLanguageProvider {
    public ZombiePlayersDutchBEProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "nl_be", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Heilige Slag");

        translationBuilder.add(ZombiePlayersItems.GILDED_VESSEL, "Verguld Vaartuig");
        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "Glazen kan");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "Sculk Energie");
    }
}
