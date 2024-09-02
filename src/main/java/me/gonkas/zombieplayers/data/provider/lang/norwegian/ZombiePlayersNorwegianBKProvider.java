package me.gonkas.zombieplayers.data.provider.lang.norwegian;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersNorwegianBKProvider extends FabricLanguageProvider {
    public ZombiePlayersNorwegianBKProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "no_no", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Helliage Streik");

        translationBuilder.add(ZombiePlayersItems.GILDED_VESSEL, "Forgylt Fartøy");
        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "Glassmugge");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "Sculke Energi");
        translationBuilder.add(ZombiePlayersItems.SHINING_AMALGAMATE, "Skinnende Klyngje");
    }
}
