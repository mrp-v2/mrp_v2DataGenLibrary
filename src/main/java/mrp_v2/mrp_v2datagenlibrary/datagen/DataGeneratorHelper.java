package mrp_v2.mrp_v2datagenlibrary.datagen;

import net.minecraft.data.DataGenerator;

import java.util.function.BiFunction;

public class DataGeneratorHelper
{
    private final DataGenerator dataGenerator;
    private final String modId;

    public DataGeneratorHelper(DataGenerator dataGenerator, String modId)
    {
        this.dataGenerator = dataGenerator;
        this.modId = modId;
    }

    public void addLootTables(LootTables lootTables)
    {
        this.dataGenerator.addProvider(new LootTableGenerator(this.dataGenerator, lootTables, this.modId));
    }

    public void addRecipeGenerator(
            BiFunction<DataGenerator, String, ? extends RecipeGenerator> recipeGeneratorConstructor)
    {
        this.dataGenerator.addProvider(recipeGeneratorConstructor.apply(this.dataGenerator, this.modId));
    }
}
