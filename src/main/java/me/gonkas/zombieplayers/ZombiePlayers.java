package me.gonkas.zombieplayers;

import me.gonkas.zombieplayers.items.enchantments.HolyStrikeEnchantment;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZombiePlayers implements ModInitializer {

	public static final String MODID = "zombieplayers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		// HolyStrikeEnchantment.registerHolyStrike();
	}
}