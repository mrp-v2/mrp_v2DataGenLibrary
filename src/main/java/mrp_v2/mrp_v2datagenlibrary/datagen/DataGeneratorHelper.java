package mrp_v2.mrp_v2datagenlibrary.datagen;

import com.mojang.datafixers.util.Function3;
import com.mojang.datafixers.util.Function4;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

import java.util.function.BiFunction;

public class DataGeneratorHelper
{
    private final DataGenerator dataGenerator;
    private final String modId;
    private final ExistingFileHelper existingFileHelper;
    private final BlockTagsProvider blockTagsProvider;

    public DataGeneratorHelper(GatherDataEvent event, String modId)
    {
        this.dataGenerator = event.getGenerator();
        this.modId = modId;
        this.existingFileHelper = event.getExistingFileHelper();
        this.blockTagsProvider = new BlockTagsProvider(this.dataGenerator, this.modId, this.existingFileHelper);
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

    public void addItemTagGenerator(
            Function4<DataGenerator, BlockTagsProvider, String, ExistingFileHelper, ? extends ItemTagGenerator> itemTagGeneratorConstructor)
    {
        this.dataGenerator.addProvider(
                itemTagGeneratorConstructor.apply(this.dataGenerator, this.blockTagsProvider, this.modId,
                        this.existingFileHelper));
    }

    public void addBlockTagGenerator(
            Function3<DataGenerator, String, ExistingFileHelper, ? extends BlockTagGenerator> blockTagGeneratorConstructor)
    {
        this.dataGenerator.addProvider(
                blockTagGeneratorConstructor.apply(this.dataGenerator, this.modId, this.existingFileHelper));
    }
}
