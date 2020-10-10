package mrp_v2.mrp_v2datagenlibrary.datagentesting;

import mrp_v2.mrp_v2datagenlibrary.datagen.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;

import java.util.function.Consumer;

public class RecipeGeneratorTest extends RecipeGenerator
{
    public RecipeGeneratorTest(DataGenerator dataGeneratorIn, String modId)
    {
        super(dataGeneratorIn, modId);
    }

    @Override protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapelessRecipeBuilder.shapelessRecipe(Items.BEDROCK, 1)
                .addIngredient(Items.DIRT, 9)
                .addCriterion("has_dirt", hasItem(Items.DIRT))
                .build(consumer);
    }
}
