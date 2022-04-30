package datagen.server;


import java.util.function.Consumer;

import com.tlau.apes.Apesmod;

import init.BlockInit;
import init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class ModRecipeProvider extends RecipeProvider {

	public ModRecipeProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		// Shaped Recipes
		ShapedRecipeBuilder.shaped(ItemInit.banana.get(), 10)
			.define('a', BlockInit.bananaBlock.get().asItem())
			//.define('b', TagInit.Items.COOL_ITEMS).pattern("aba").pattern("bab").pattern("aba")
			.unlockedBy("has_" + BlockInit.bananaBlock.get().getRegistryName().getPath(), has(BlockInit.bananaBlock.get().asItem()))
			.save(consumer, new ResourceLocation(Apesmod.MOD_ID,
						ItemInit.banana.get().getRegistryName().getPath()));
		
		// Shapeless Recipe
		ShapelessRecipeBuilder.shapeless(BlockInit.bananaBlock.get().asItem(), 4)
			.requires(ItemInit.banana.get())
			.requires(ItemInit.banana.get())
			.requires(ItemInit.banana.get())
			.requires(Items.DIAMOND)
			.unlockedBy("has_" + ItemInit.banana.get().getRegistryName().getPath(), has(ItemInit.banana.get()))
			.save(consumer, new ResourceLocation(Apesmod.MOD_ID,
					BlockInit.bananaBlock.get().getRegistryName().getPath()));
		
		// Cooking Recipe
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.bananaPlanks.get().asItem()),
				ItemInit.banana.get(), 1f, 200)
		.unlockedBy("has_" + BlockInit.bananaPlanks.get().getRegistryName().getPath(), has(BlockInit.bananaPlanks.get().asItem()))
		.save(consumer, new ResourceLocation(Apesmod.MOD_ID,
						ItemInit.banana.get().getRegistryName().getPath() + "_smelting"));
		
	}

}