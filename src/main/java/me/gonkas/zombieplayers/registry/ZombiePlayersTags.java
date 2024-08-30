package me.gonkas.zombieplayers.registry;

import me.gonkas.zombieplayers.ZombiePlayers;
import me.gonkas.zombieplayers.util.ZombiePlayersIdentifier;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class ZombiePlayersTags {

    public static void registerTags() {
        Items.registerItemTags();
        EntityTypes.registerEntityTags();
    }

    public static class Items {

        public static final TagKey<Item> HOLY_STRIKE_COMPATIBLE = createTag("holy_strike_compatible");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, ZombiePlayersIdentifier.of(name));
        }

        private static void registerItemTags() {ZombiePlayers.logRegistration("item tags");}
    }

    public static class EntityTypes {

        public static final TagKey<EntityType<?>> SENSITIVE_TO_HOLY_STRIKE = createTag("sensitive_to_holy_strike");

        public static TagKey<EntityType<?>> createTag(String name) {
            return TagKey.of(RegistryKeys.ENTITY_TYPE, ZombiePlayersIdentifier.of(name));
        }

        private static void registerEntityTags() {
            ZombiePlayers.logRegistration("entity type tags");;
        }
    }
}