package me.gonkas.zombieplayers.util;

import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ZombiePlayersComponents {

    public static ItemEnchantmentsComponent getEmptyEnchantmentsComponent() {
        return (new ItemStack(new Item(new Item.Settings()))).getEnchantments();
    }
}
