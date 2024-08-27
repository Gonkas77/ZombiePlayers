package me.gonkas.zombieplayers;

import me.gonkas.zombieplayers.datagen.ModEnchantmentTagProvider;
import me.gonkas.zombieplayers.datagen.ModEntityTypeTagProvider;
import me.gonkas.zombieplayers.datagen.ModItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ZombiePlayersDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModEnchantmentTagProvider::new);
		pack.addProvider(ModEntityTypeTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
	}
}
