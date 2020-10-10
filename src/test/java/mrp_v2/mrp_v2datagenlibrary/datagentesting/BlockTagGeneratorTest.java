package mrp_v2.mrp_v2datagenlibrary.datagentesting;

import mrp_v2.mrp_v2datagenlibrary.datagen.BlockTagGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;

public class BlockTagGeneratorTest extends BlockTagGenerator
{
    public BlockTagGeneratorTest(DataGenerator generatorIn, String modId,
            @Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, modId, existingFileHelper);
    }

    @Override protected void registerTags()
    {
        LogManager.getLogger().info("Test Block Tag Generator");
    }
}
