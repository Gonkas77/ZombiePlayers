package me.gonkas.zombieplayers.registry;

import me.gonkas.zombieplayers.ZombiePlayers;
import me.gonkas.zombieplayers.block.SynthesizerBEBlock;
import me.gonkas.zombieplayers.util.ZombiePlayersIdentifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ZombiePlayersBlocks {

    public static final SynthesizerBEBlock SYNTHESIZER = registerWithItem("synthesizer", new SynthesizerBEBlock(AbstractBlock.Settings.create()
            .strength(1.5f, 6.0f)
            .requiresTool()
            .notSolid()
    ));

    public static void registerBlocks() {
        ZombiePlayers.logRegistration("blocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(SYNTHESIZER);
        });
    }

    public static <T extends Block> T register(String name, T block) {
        return Registry.register(Registries.BLOCK, ZombiePlayersIdentifier.of(name), block);
    }

    private static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings) {
        T registered = register(name, block);
        ZombiePlayersItems.register(name, new BlockItem(registered, settings));
        return registered;
    }

    private static <T extends Block> T registerWithItem(String name, T block) {
        return registerWithItem(name, block, new Item.Settings());
    }
}
