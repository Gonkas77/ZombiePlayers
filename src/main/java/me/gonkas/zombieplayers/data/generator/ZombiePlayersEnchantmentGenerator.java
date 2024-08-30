package me.gonkas.zombieplayers.data.generator;

import me.gonkas.zombieplayers.registry.ZombiePlayersEnchantments;
import me.gonkas.zombieplayers.registry.ZombiePlayersTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ZombiePlayersEnchantmentGenerator extends FabricDynamicRegistryProvider {
    public ZombiePlayersEnchantmentGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        RegistryWrapper<Item> itemLookup = registries.getWrapperOrThrow(RegistryKeys.ITEM);
        RegistryWrapper<Enchantment> enchantmentLookup = registries.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        register(
                entries,
                ZombiePlayersEnchantments.HOLY_STRIKE,
                new Enchantment.Builder(
                        new Enchantment.Definition(
                                itemLookup.getOrThrow(ZombiePlayersTags.Items.HOLY_STRIKE_COMPATIBLE),
                                Optional.of(itemLookup.getOrThrow(ItemTags.SWORD_ENCHANTABLE)),
                                /* weight */  1,
                                /* maxlvl */  3,
                                Enchantment.leveledCost(5, 8),
                                Enchantment.leveledCost(25, 8),
                                /* anvil Cost */  5,
                                Collections.singletonList(AttributeModifierSlot.MAINHAND)
                        )
                ).addEffect(
                        EnchantmentEffectComponentTypes.DAMAGE, // setting enchantment as damage bonus type
                        new AddEnchantmentEffect(EnchantmentLevelBasedValue.linear(3f, 1.5f)), // possibly changing these values in the future
                        EntityPropertiesLootCondition.builder(
                                LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().type(ZombiePlayersTags.EntityTypes.SENSITIVE_TO_HOLY_STRIKE)
                        )
                ).exclusiveSet(enchantmentLookup.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
        );
    }

    private static void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
        entries.add(key, customEnchantmentBuilder(builder, key.getValue()), resourceConditions);
    }

    private static Enchantment customEnchantmentBuilder(Enchantment.Builder builder, Identifier id) {
        Enchantment enchant = builder.build(Identifier.of("temp", "temp"));
        Enchantment.Definition definition = enchant.definition();
        RegistryEntryList<Enchantment> exclusive_set = enchant.exclusiveSet();
        ComponentMap components = enchant.effects();

        Text enchant_name = Text.translatable(Util.createTranslationKey("enchantment", id)).formatted(Formatting.GOLD); // custom part
        return new Enchantment(enchant_name, definition, exclusive_set, components);
    }

    @Override
    public String getName() {
        return "ZombiePlayers - Enchantment Generator";
    }
}
