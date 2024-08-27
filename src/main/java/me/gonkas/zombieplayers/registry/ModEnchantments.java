package me.gonkas.zombieplayers.registry;

import me.gonkas.zombieplayers.ZombiePlayers;
import me.gonkas.zombieplayers.util.ModIdentifier;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> HOLY_STRIKE = RegistryKey.of(RegistryKeys.ENCHANTMENT, ModIdentifier.of("holy_strike"));

    public static void registerEnchantments() {
        ZombiePlayers.logRegistration("enchantments");
    }
}
