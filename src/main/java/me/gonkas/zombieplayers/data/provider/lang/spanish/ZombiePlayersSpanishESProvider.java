package me.gonkas.zombieplayers.data.provider.lang.spanish;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersSpanishESProvider extends FabricLanguageProvider {
    public ZombiePlayersSpanishESProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "es_es", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Golpe Santo");

        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "Jarra de Cristal");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "Energía de Sculk");
    }
}
