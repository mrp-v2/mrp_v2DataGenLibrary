package mrp_v2.mrp_v2datagenlibrary.datagentesting;

import mrp_v2.mrp_v2datagenlibrary.datagen.RecipeGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import org.apache.logging.log4j.LogManager;

import java.util.function.Consumer;

public class RecipeGeneratorTest extends RecipeGenerator
{
    public RecipeGeneratorTest(DataGenerator dataGeneratorIn, String modId)
    {
        super(dataGeneratorIn, modId);
    }

    @Override protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        LogManager.getLogger().info("Test Recipe Generator");
    }
}
