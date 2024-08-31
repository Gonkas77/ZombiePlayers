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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ZombiePlayersItems.GILDED_VESSEL)
                .input('B', Items.BOOK)
                .input('E', Items.EMERALD)
                .input('G', Items.GOLD_INGOT)
                .pattern("EGE")
                .pattern("GBG")
                .pattern("EGE")
                .criterion(hasItem(Items.BOOK), conditionsFromItem(Items.BOOK))
                .criterion(hasItem(Items.EMERALD), conditionsFromItem(Items.EMERALD))
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ZombiePlayersItems.GLASS_JUG)
                .input('G', Items.GLASS)
                .input('B', Items.GLASS_BOTTLE)
                .pattern(" G ")
                .pattern("GBG")
                .pattern(" G ")
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .offerTo(exporter);
    }
}
