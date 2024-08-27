package me.gonkas.zombieplayers;

import me.gonkas.zombieplayers.registry.ModEnchantments;
import me.gonkas.zombieplayers.registry.ModEntities;
import me.gonkas.zombieplayers.registry.ModItems;
import me.gonkas.zombieplayers.registry.ModTags;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZombiePlayers implements ModInitializer {

	public static final String MODID = "zombieplayers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		ModEntities.registerEntities();
		ModTags.registerTags();
		ModEnchantments.registerEnchantments();
		ModItems.registerItems();
	}

	public static void logRegistration(String type) {
        LOGGER.info("Registering {} for mod " + MODID, type);
	}
}