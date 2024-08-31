package me.gonkas.zombieplayers.data.provider.lang.english;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersEnglishNZProvider extends FabricLanguageProvider {
    public ZombiePlayersEnglishNZProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_nz", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Holy Strike");

        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "Glass Jug");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "Sculk Energy");
    }
}
