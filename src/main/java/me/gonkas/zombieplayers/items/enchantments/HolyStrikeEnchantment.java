package me.gonkas.zombieplayers.items.enchantments;

import me.gonkas.zombieplayers.ZombiePlayers;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class HolyStrikeEnchantment {

    public static final EnchantedBookItem HOLY_STRIKE_ENCHANTMENT =  createItem();

    // method called by main function to initialize the item
    public static void registerHolyStrike() {

        ZombiePlayers.LOGGER.info("Registering Holy Strike Enchantment for " + ZombiePlayers.MODID);

        // adding the enchantment to combat item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HOLY_STRIKE_ENCHANTMENT);});
    }

    private static EnchantedBookItem createItem() {

        Item.Settings settings = new Item.Settings();
        settings.rarity(Rarity.RARE);
        settings.fireproof(); // item immune to lava and fire

        EnchantedBookItem holy_strike = new EnchantedBookItem(settings);
        return Registry.register(Registries.ITEM, Identifier.of(ZombiePlayers.MODID, "holy_strike_enchantment"), holy_strike);
    }
}