package me.gonkas.zombieplayers.data.provider.lang.english;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersEnglishUDProvider extends FabricLanguageProvider {
    public ZombiePlayersEnglishUDProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_ud", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {

        translationBuilder.addEnchantment(ZombiePlayersEnchantments.HOLY_STRIKE, "ǝʞᴉɹʇS ʎloH");

        translationBuilder.add(ZombiePlayersItems.GILDED_VESSEL, "פlǝssǝΛ pǝplᴉ");
        translationBuilder.add(ZombiePlayersItems.GLASS_JUG, "פƃnſ ssɐl");
        translationBuilder.add(ZombiePlayersItems.SCULK_ENERGY, "ʎƃɹǝuƎ ʞlnɔS");
    }
}
