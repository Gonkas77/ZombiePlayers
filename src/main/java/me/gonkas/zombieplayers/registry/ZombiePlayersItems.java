package me.gonkas.zombieplayers.registry;

import me.gonkas.zombieplayers.ZombiePlayers;
import me.gonkas.zombieplayers.util.ZombiePlayersComponents;
import me.gonkas.zombieplayers.util.ZombiePlayersIdentifier;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Rarity;

public class ZombiePlayersItems {

    public static final Item HOLY_STRIKE_BOOK = register("holy_strike_book", new EnchantedBookItem(new Item.Settings().fireproof()));

    public static void registerItems() {
        ZombiePlayers.logRegistration("items");
    }

    private static Item register(String name, Item item) {
        return Registry.register(Registries.ITEM, ZombiePlayersIdentifier.of(name), item);
    }

    private static EnchantedBookItem createHolyStrikeBook(int level) {

        ItemEnchantmentsComponent.Builder enchantments = new ItemEnchantmentsComponent.Builder(ZombiePlayersComponents.getEmptyEnchantmentsComponent());
        RegistryEntry<Enchantment> holy_strike = BuiltinRegistries.createWrapperLookup().getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(ZombiePlayersEnchantments.HOLY_STRIKE);
        enchantments.add(holy_strike, level);

        Item.Settings settings = new Item.Settings()
                .component(DataComponentTypes.ENCHANTMENTS, enchantments.build())
                .fireproof()
                .rarity(level < 3 ? Rarity.RARE : Rarity.EPIC); // if level < 3, then Rare, otherwise Epic

        return new EnchantedBookItem(settings);
    }
}
