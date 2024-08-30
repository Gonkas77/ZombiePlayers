package me.gonkas.zombieplayers.data.provider.lang.portuguese;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersPortuguesePTProvider extends FabricLanguageProvider {
    public ZombiePlayersPortuguesePTProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "pt_pt", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Golpe Sagrado");
    }
}
