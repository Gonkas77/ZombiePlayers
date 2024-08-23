package me.gonkas.zombieplayers.items.enchantments;

import me.gonkas.zombieplayers.ZombiePlayers;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import static net.minecraft.enchantment.EnchantmentHelper.enchant;

public class HolyStrikeEnchantment {

    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_1;
    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_2;
    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_3;
    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_4;
    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_5;

    // method called by main function to initialize the item
    public static void registerHolyStrike() {

        ZombiePlayers.LOGGER.info("Registering Holy Strike Enchantment for " + ZombiePlayers.MODID);

        createItems();

        // adding the enchantment to combat item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_1);
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_2);
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_3);
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_4);
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_5);
        });
    }

    private static void createItems() {

        Item.Settings settings = new Item.Settings();
        settings.rarity(Rarity.RARE);
        settings.fireproof(); // item immune to lava and fire

        // creating the item itself with the setting above
        EnchantedBookItem holy_strike_1 = new EnchantedBookItem(settings);
        EnchantedBookItem holy_strike_2 = new EnchantedBookItem(settings);
        EnchantedBookItem holy_strike_3 = new EnchantedBookItem(settings);

        // levels 4 and 5 are epic instead of rare
        settings.rarity(Rarity.EPIC);
        EnchantedBookItem holy_strike_4 = new EnchantedBookItem(settings);
        EnchantedBookItem holy_strike_5 = new EnchantedBookItem(settings);

        EnchantedBookItem[] books = new EnchantedBookItem[]{holy_strike_1, holy_strike_2, holy_strike_3, holy_strike_4, holy_strike_5};

        for (int i=0; i<5; i++) {enchant(books[i], i);} // <------------------------------- note this may not work
        for (EnchantedBookItem book : books) {register(book);}

        return Registry.register(Registries.ITEM, Identifier.of(ZombiePlayers.MODID, "holy_strike_enchantment"), holy_strike_1);
    }

    private static void enchant(EnchantedBookItem item, int level) {

        ItemEnchantmentsComponent component = item.getDefaultStack().getEnchantments();
        ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(component);
        builder.add(createEnchantment(), level);
        builder.build(); // <------------------------------- note this may not work
    }

    private static RegistryEntry<Enchantment> createEnchantment() {

    }
}