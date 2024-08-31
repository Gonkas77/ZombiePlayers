package me.gonkas.zombieplayers.data.provider.lang.arabic;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersArabicProvider extends FabricLanguageProvider {
    public ZombiePlayersArabicProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "ar_sa", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "قدوس الإضراب");

        translationBuilder.add(ZombiePlayersItems.GILDED_VESSEL, "إناء مذهب");
        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "إبريق زجاجي");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "سكالك للطاقة");
    }
}
