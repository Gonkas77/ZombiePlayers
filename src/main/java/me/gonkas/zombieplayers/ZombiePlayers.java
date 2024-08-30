package me.gonkas.zombieplayers;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersEntities;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import me.gonkas.zombieplayers.registry.ZombiePlayersTags;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZombiePlayers implements ModInitializer {

	public static final String MODID = "zombieplayers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		ZombiePlayersEntities.registerEntities();
		ZombiePlayersTags.registerTags();
		ZombiePlayersEnchantments.registerEnchantments();
		ZombiePlayersItems.registerItems();
	}

	public static void logRegistration(String type) {
        LOGGER.info("Registering {} for mod " + MODID, type);
	}
}