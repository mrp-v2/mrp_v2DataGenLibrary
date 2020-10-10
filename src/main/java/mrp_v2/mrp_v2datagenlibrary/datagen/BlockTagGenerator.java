package mrp_v2.mrp_v2datagenlibrary.datagen;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public abstract class BlockTagGenerator extends BlockTagsProvider
{
    public BlockTagGenerator(DataGenerator generatorIn, String modId, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, modId, existingFileHelper);
    }

    @Override protected abstract void registerTags();

    @Override public String getName()
    {
        return super.getName() + ": " + this.modId;
    }
}
