package me.gonkas.zombieplayers.data.provider.lang.greek;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersGreekProvider extends FabricLanguageProvider {
    public ZombiePlayersGreekProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "el_gr", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "Ιερά Απεργία");

        translationBuilder.add(ZombiePlayersItems.GILDED_VESSEL, "Επιχρυσωμένο Σκάφος");
        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "Γυάλινη Κανάτα");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "Κρυφή Ενέργεια");
    }
}
