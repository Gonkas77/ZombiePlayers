package me.gonkas.zombieplayers.data.provider;

import me.gonkas.zombieplayers.registry.ZombiePlayersItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ZombiePlayersRecipeProvider extends FabricRecipeProvider {
    public ZombiePlayersRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ZombiePlayersItems.GLASS_JUG)
                .input('G', Items.GLASS)
                .input('B', Items.GLASS_BOTTLE)
                .pattern(" G ")
                .pattern("GBG")
                .pattern(" G ")
                .criterion(hasItem(ZombiePlayersItems.GLASS_JUG), conditionsFromItem(ZombiePlayersItems.GLASS_JUG))
                .offerTo(exporter);
    }
}
