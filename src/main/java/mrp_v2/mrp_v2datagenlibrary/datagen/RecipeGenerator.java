package mrp_v2.mrp_v2datagenlibrary.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public abstract class RecipeGenerator extends RecipeProvider
{
    private final String modId;

    protected RecipeGenerator(DataGenerator dataGeneratorIn, String modId)
    {
        super(dataGeneratorIn);
        this.modId = modId;
    }

    protected static String getID(IItemProvider item)
    {
        return Registry.ITEM.getKey(item.asItem()).getPath();
    }

    @Override protected abstract void registerRecipes(Consumer<IFinishedRecipe> consumer);

    @Override public String getName()
    {
        return super.getName() + ": " + this.modId;
    }
}
