package me.gonkas.zombieplayers.registry;

import me.gonkas.zombieplayers.ZombiePlayers;
import me.gonkas.zombieplayers.util.ModIdentifier;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ModTags {

    public static void registerTags() {
        Items.registerItemTags();
        Entity.registerEntityTags();
    }

    public static class Items {

        public static final TagKey<Item> HOLY_STRIKE_COMPATIBLE = createTag("holy_strike_compatible.json");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, ModIdentifier.of(name));
        }

        private static void registerItemTags() {ZombiePlayers.LOGGER.info("Registering item tags for mod 'ZombiePlayers'.");}
    }

    public static class Entity {

        public static final TagKey<EntityType<?>> SENSITIVE_TO_HOLY_STIKE = createTag("sensitive_to_holy_strike.json");

        public static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, ModIdentifier.of(name));
        }

        private static void registerEntityTags() {
            ZombiePlayers.logRegistration("enchantments");;
        }
    }
}