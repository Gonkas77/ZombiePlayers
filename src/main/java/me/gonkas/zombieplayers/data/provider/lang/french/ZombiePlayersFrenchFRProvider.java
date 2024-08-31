package me.gonkas.zombieplayers.data.provider.lang.french;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersFrenchFRProvider extends FabricLanguageProvider {
    public ZombiePlayersFrenchFRProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "fr_fr", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Frappe Sacrée");

        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "Cruche en Verre");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "Énergie de Sculk");
    }
}
