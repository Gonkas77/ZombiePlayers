package me.gonkas.zombieplayers;

import me.gonkas.zombieplayers.data.generator.ZombiePlayersEnchantmentGenerator;
import me.gonkas.zombieplayers.data.provider.ZombiePlayersEntityTypeTagProvider;
import me.gonkas.zombieplayers.data.provider.ZombiePlayersItemTagProvider;
import me.gonkas.zombieplayers.data.provider.lang.arabic.ZombiePlayersArabicProvider;
import me.gonkas.zombieplayers.data.provider.lang.dutch.ZombiePlayersDutchBEProvider;
import me.gonkas.zombieplayers.data.provider.lang.dutch.ZombiePlayersDutchNLProvider;
import me.gonkas.zombieplayers.data.provider.lang.french.ZombiePlayersFrenchCAProvider;
import me.gonkas.zombieplayers.data.provider.lang.french.ZombiePlayersFrenchFRProvider;
import me.gonkas.zombieplayers.data.provider.lang.greek.ZombiePlayersGreekProvider;
import me.gonkas.zombieplayers.data.provider.lang.norwegian.ZombiePlayersNorwegianBKProvider;
import me.gonkas.zombieplayers.data.provider.lang.norwegian.ZombiePlayersNorwegianNYProvider;
import me.gonkas.zombieplayers.data.provider.lang.portuguese.ZombiePlayersPortugueseBRProvider;
import me.gonkas.zombieplayers.data.provider.lang.portuguese.ZombiePlayersPortuguesePTProvider;
import me.gonkas.zombieplayers.data.provider.lang.spanish.*;
import me.gonkas.zombieplayers.data.provider.lang.english.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ZombiePlayersDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ZombiePlayersItemTagProvider::new);
		pack.addProvider(ZombiePlayersEntityTypeTagProvider::new);
		pack.addProvider(ZombiePlayersEnchantmentGenerator::new);

		// adding all lang files
		pack.addProvider(ZombiePlayersArabicProvider::new); // Arabic

		pack.addProvider(ZombiePlayersEnglishAUProvider::new); // Australian English
		pack.addProvider(ZombiePlayersEnglishCAProvider::new); // Canadian English
		pack.addProvider(ZombiePlayersEnglishUKProvider::new); // British English
		pack.addProvider(ZombiePlayersEnglishNZProvider::new); // New Zealand English
		pack.addProvider(ZombiePlayersEnglishUDProvider::new); // Upside Down English
		pack.addProvider(ZombiePlayersEnglishUSProvider::new); // US English

		pack.addProvider(ZombiePlayersSpanishARProvider::new); // Argentinian Spanish
		pack.addProvider(ZombiePlayersSpanishCLProvider::new); // Chilean Spanish
		pack.addProvider(ZombiePlayersSpanishECProvider::new); // Ecuadorian Spanish
		pack.addProvider(ZombiePlayersSpanishESProvider::new); // European Spanish
		pack.addProvider(ZombiePlayersSpanishMXProvider::new); // Mexican Spanish
		pack.addProvider(ZombiePlayersSpanishUYProvider::new); // Uruguayan Spanish
		pack.addProvider(ZombiePlayersSpanishVEProvider::new); // Venezuelan Spanish

		pack.addProvider(ZombiePlayersFrenchCAProvider::new);  // Canadian French
		pack.addProvider(ZombiePlayersFrenchFRProvider::new);  // European French

		pack.addProvider(ZombiePlayersGreekProvider::new); // Greek

		pack.addProvider(ZombiePlayersDutchBEProvider::new); // Belgium Dutch
		pack.addProvider(ZombiePlayersDutchNLProvider::new); // Netherlands Dutch

		pack.addProvider(ZombiePlayersNorwegianBKProvider::new); // Norwegian Bokmål
		pack.addProvider(ZombiePlayersNorwegianNYProvider::new); // Norwegian Nynorsk

		pack.addProvider(ZombiePlayersPortugueseBRProvider::new); // Brazillian Portuguese
		pack.addProvider(ZombiePlayersPortuguesePTProvider::new); // European Portuguese
	}
}
