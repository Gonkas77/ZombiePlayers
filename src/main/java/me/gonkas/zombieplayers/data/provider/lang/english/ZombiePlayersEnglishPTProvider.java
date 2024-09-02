package me.gonkas.zombieplayers.data.provider.lang.english;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersEnglishPTProvider extends FabricLanguageProvider {
    public ZombiePlayersEnglishPTProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_pt", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Holy Strike");

        translationBuilder.add(ZombiePlayersItems.GILDED_VESSEL, "Shiny vessel");
        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "Jar o' glass");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "Sculk power");
    }
}
