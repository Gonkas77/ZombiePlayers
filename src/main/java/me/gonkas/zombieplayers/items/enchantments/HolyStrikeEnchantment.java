package me.gonkas.zombieplayers.items.enchantments;

import me.gonkas.zombieplayers.ZombiePlayers;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

import java.util.ArrayList;
import java.util.List;

public class HolyStrikeEnchantment {

    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_1;
    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_2;
    public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_3;

    // public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_4;
    // public static EnchantedBookItem HOLY_STRIKE_ENCHANTMENT_LEVEL_5;

    // method called by main function to initialize the item
    public static void registerHolyStrike() {

        ZombiePlayers.LOGGER.info("Registering Holy Strike Enchantment for " + ZombiePlayers.MODID);

        createItems();

        // adding the enchantment to combat item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_1);
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_2);
            entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_3);
            // entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_4);
            // entries.add(HOLY_STRIKE_ENCHANTMENT_LEVEL_5);
        });
    }

    private static void createItems() {

        Item.Settings settings = new Item.Settings();
        settings.rarity(Rarity.RARE);
        settings.fireproof(); // item immune to lava and fire

        // creating the item itself with the setting above
        EnchantedBookItem holy_strike_1 = new EnchantedBookItem(settings);
        EnchantedBookItem holy_strike_2 = new EnchantedBookItem(settings);

        // levels 4 and 5 are epic instead of rare (initially, but for now level 3 is the highest and the only epic)
        settings.rarity(Rarity.EPIC);
        EnchantedBookItem holy_strike_3 = new EnchantedBookItem(settings);

        // EnchantedBookItem holy_strike_4 = new EnchantedBookItem(settings);
        // EnchantedBookItem holy_strike_5 = new EnchantedBookItem(settings);

        // making the books actually have the enchantment
        enchantBookItem(holy_strike_1, 1);
        enchantBookItem(holy_strike_2, 2);
        enchantBookItem(holy_strike_3, 3);
        // enchantBookItem(holy_strike_4, 4);
        // enchantBookItem(holy_strike_5, 5);

        // registering every item
        HOLY_STRIKE_ENCHANTMENT_LEVEL_1 = registerEnchantment("holy_strike_enchantment_level_1", holy_strike_1);
        HOLY_STRIKE_ENCHANTMENT_LEVEL_2 = registerEnchantment("holy_strike_enchantment_level_2", holy_strike_2);
        HOLY_STRIKE_ENCHANTMENT_LEVEL_3 = registerEnchantment("holy_strike_enchantment_level_3", holy_strike_3);
        // HOLY_STRIKE_ENCHANTMENT_LEVEL_4 = registerEnchantment("holy_strike_enchantment_level_4", holy_strike_4);
        // HOLY_STRIKE_ENCHANTMENT_LEVEL_5 = registerEnchantment("holy_strike_enchantment_level_5", holy_strike_5);
    }

    private static EnchantedBookItem registerEnchantment(String name, EnchantedBookItem item) {
        return Registry.register(Registries.ITEM, Identifier.of(ZombiePlayers.MODID, name), item);
    }

    private static void enchantBookItem(EnchantedBookItem item, int level) {

        ItemEnchantmentsComponent component = item.getDefaultStack().getEnchantments();
        ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(component);
        builder.add(createEnchantment(), level);
        builder.build(); // <------------------------------- note this may not work
    }

    public static RegistryEntry<Enchantment> createEnchantment() {

        Enchantment.Builder builder = getBuilder();
        builder.addEffect(
                EnchantmentEffectComponentTypes.DAMAGE, // setting enchantment as damage bonus type
                new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(3f, 1.5f)), // possibly changing these values in the future
                EntityPropertiesLootCondition.builder(
                        LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().type(EntityTypePredicate.create(EntityTypeTags.SENSITIVE_TO_SMITE))
                ) // TEMPORARY ADDITION ------------------------------------------------------------------------------------------
        );

        // making sharpness, smite and bane of arthropods incompatible
        builder.exclusiveSet(getIncompatibleEnchantments());

        Enchantment holy_strike = builder.build(Identifier.of(ZombiePlayers.MODID, "holy_strike_enchantment"));
        return RegistryEntry.of(holy_strike);
    }

    private static RegistryEntryList<Enchantment> getIncompatibleEnchantments() {

        RegistryEntry<Enchantment> sharpness = RegistryKeys.ENCHANTMENT.getRegistry();

        // FIND ENTRY FOR ENCHANTMENTS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    }

    private static Enchantment.Builder getBuilder() {
        Enchantment.Definition definition = new Enchantment.Definition(
                /* supported items */  getSupportedItems(),
                /* primary items */    null,
                /* weight */           1,
                /* max level */        5,
                /* minCost */          Enchantment.leveledCost(1, 11), // --->  assuming minCost is when applying enchantment on anvil from a book
                /* maxCost */          Enchantment.leveledCost(12, 11), // -->  ^^ but from an another item instead of a book
                /* anvilCost */        1,
                /* supported slots */  List.of(AttributeModifierSlot.MAINHAND)
        ); return new Enchantment.Builder(definition);
    }

    private static RegistryEntryList<Item> getSupportedItems() {

        RegistryEntry<Item> netherite_sword = Registries.ITEM.getEntry(Items.NETHERITE_SWORD);
        RegistryEntry<Item> diamond_sword = Registries.ITEM.getEntry(Items.NETHERITE_SWORD);
        RegistryEntry<Item> iron_sword = Registries.ITEM.getEntry(Items.NETHERITE_SWORD);
        RegistryEntry<Item> stone_sword = Registries.ITEM.getEntry(Items.NETHERITE_SWORD);
        RegistryEntry<Item> golden_sword = Registries.ITEM.getEntry(Items.NETHERITE_SWORD);
        RegistryEntry<Item> wooden_sword = Registries.ITEM.getEntry(Items.NETHERITE_SWORD);

        RegistryEntry<Item> netherite_axe = Registries.ITEM.getEntry(Items.NETHERITE_AXE);
        RegistryEntry<Item> diamond_axe = Registries.ITEM.getEntry(Items.NETHERITE_AXE);
        RegistryEntry<Item> iron_axe = Registries.ITEM.getEntry(Items.NETHERITE_AXE);
        RegistryEntry<Item> stone_axe = Registries.ITEM.getEntry(Items.NETHERITE_AXE);
        RegistryEntry<Item> golden_axe = Registries.ITEM.getEntry(Items.NETHERITE_AXE);
        RegistryEntry<Item> wooden_axe = Registries.ITEM.getEntry(Items.NETHERITE_AXE);

        RegistryEntry<Item> trident = Registries.ITEM.getEntry(Items.TRIDENT);

        List<RegistryEntry<Item>> supported_items = new ArrayList<>(13);
        supported_items.add(netherite_sword);
        supported_items.add(diamond_sword);
        supported_items.add(iron_sword);
        supported_items.add(stone_sword);
        supported_items.add(golden_sword);
        supported_items.add(wooden_sword);
        supported_items.add(netherite_axe);
        supported_items.add(diamond_axe);
        supported_items.add(iron_axe);
        supported_items.add(stone_axe);
        supported_items.add(golden_axe);
        supported_items.add(wooden_axe);
        supported_items.add(trident);

        return RegistryEntryList.of(supported_items);
    }

}