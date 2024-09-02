package me.gonkas.zombieplayers.data.provider;

import me.gonkas.zombieplayers.registry.ZombiePlayersBlocks;
import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ZombiePlayersModelProvider extends FabricModelProvider {
    public ZombiePlayersModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerParented(Blocks.ENCHANTING_TABLE, ZombiePlayersBlocks.SYNTHESIZER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ZombiePlayersItems.GILDED_VESSEL, Models.GENERATED);
        itemModelGenerator.register(ZombiePlayersItems.GLASS_JUG, Models.GENERATED);
        itemModelGenerator.register(ZombiePlayersItems.SCULK_ENERGY, Models.GENERATED);
        itemModelGenerator.register(ZombiePlayersItems.SHINING_AMALGAMATE, Models.GENERATED);
    }
}
