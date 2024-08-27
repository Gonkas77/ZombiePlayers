//package me.gonkas.zombieplayers.enchantments;
//
//import me.gonkas.zombieplayers.registry.ModEnchantments;
//import me.gonkas.zombieplayers.registry.ModTags;
//import me.gonkas.zombieplayers.util.ModIdentifier;
//import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//import net.minecraft.component.type.AttributeModifierSlot;
//import net.minecraft.component.EnchantmentEffectComponentTypes;
//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnchantmentLevelBasedValue;
//import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
//import net.minecraft.item.*;
//import net.minecraft.loot.condition.EntityPropertiesLootCondition;
//import net.minecraft.loot.context.LootContext;
//import net.minecraft.predicate.entity.EntityPredicate;
//import net.minecraft.registry.BuiltinRegistries;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.RegistryKeys;
//import net.minecraft.registry.entry.RegistryEntry;
//import net.minecraft.registry.entry.RegistryEntryList;
//import net.minecraft.registry.tag.EnchantmentTags;
//import net.minecraft.registry.tag.ItemTags;
//import net.minecraft.util.Rarity;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class HolyStrikeEnchantment {
//
//    public static final Enchantment HOLY_STRIKE = createEnchantment();
//
//    public static void addHolyStrikeInCreativeMenu() {
//
//        // adding max holy strike to ingredients tab
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> entries.add(makeEnchantedBook(3)));
//
//        // adding all holy strike levels to search tab
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SEARCH).register(
//                entries -> {
//                    entries.add(makeEnchantedBook(1));
//                    entries.add(makeEnchantedBook(2));
//                    entries.add(makeEnchantedBook(3));
//                }
//        );
//    }
//
//    private static Item makeEnchantedBook(int level) {
//        RegistryEntry<Enchantment> holy_strike = createEnchantment();
//
//        Item.Settings settings;
//        if (level > 2) {settings = new Item.Settings().rarity(Rarity.RARE);}
//        else {settings = new Item.Settings().rarity(Rarity.EPIC);} // if the level of the enchantment is 3 or higher, rarity is EPIC, not RARE
//
//        EnchantedBookItem item = new EnchantedBookItem(settings);
//        ItemStack itemStack = new ItemStack(item);
//        itemStack.addEnchantment(holy_strike, level);
//        return itemStack.getItem();
//    }
//
//    private static RegistryEntry<Enchantment> getHolyStrike() {
//        return BuiltinRegistries.createWrapperLookup().createRegistryLookup().getOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(ModEnchantments.HOLY_STRIKE);
//    }
//
//    private static Enchantment createEnchantment() {
//
//        Enchantment.Builder builder = getBuilder();
//        builder.addEffect(
//                EnchantmentEffectComponentTypes.DAMAGE, // setting enchantment as damage bonus type
//                new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(3f, 1.5f)), // possibly changing these values in the future
//                EntityPropertiesLootCondition.builder(
//                        LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().type(ModTags.Entity.SENSITIVE_TO_HOLY_STIKE)
//                )
//        );
//
//        // making sharpness, smite and bane of arthropods incompatible
//        builder.exclusiveSet(getIncompatibleEnchantments());
//
//        return builder.build(ModIdentifier.of("holy_strike"));
//    }
//
//    private static Enchantment.Builder getBuilder() {
//        Enchantment.Definition definition = new Enchantment.Definition(
//                /* supported items */  getSupportedItems(),
//                /* primary items */    getPrimaryItems(),
//                /* weight */           1,
//                /* max level */        3,
//                /* minCost */          Enchantment.leveledCost(5, 8), // --->  assuming minCost is when applying enchantment on anvil from a book
//                /* maxCost */          Enchantment.leveledCost(25, 8), // -->  ^^ but from an another item instead of a book
//                /* anvilCost */        1,
//                /* supported slots */  List.of(AttributeModifierSlot.MAINHAND)
//        ); return new Enchantment.Builder(definition);
//    }
//
//    private static Optional<RegistryEntryList<Item>> getPrimaryItems() {
//        List<RegistryEntry<Item>> swords = new ArrayList<>(Registries.ITEM.getEntryList(ItemTags.SWORDS).get().stream().toList());
//        return Optional.of(RegistryEntryList.of(swords));
//    }
//
//    private static RegistryEntryList<Item> getSupportedItems() {
//        List<RegistryEntry<Item>> swords = new ArrayList<>(getPrimaryItems().get().stream().toList());
//        List<RegistryEntry<Item>> axes = new ArrayList<>(Registries.ITEM.getEntryList(ItemTags.AXES).get().stream().toList());
//        List<RegistryEntry<Item>> trident = Registries.ITEM.getEntryList(ItemTags.TRIDENT_ENCHANTABLE).get().stream().toList();
//
//        swords.addAll(axes);
//        swords.addAll(trident);
//        return RegistryEntryList.of(swords);
//    }
//
//    private static RegistryEntryList<Enchantment> getIncompatibleEnchantments() {
//        return BuiltinRegistries.createWrapperLookup().getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET);
//    }
//}
