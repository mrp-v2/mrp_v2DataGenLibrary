package mrp_v2.mrp_v2datagenlibrary.datagentesting;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;

public class ItemModelProviderTest extends ItemModelProvider
{
    public ItemModelProviderTest(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override protected void registerModels()
    {
        LogManager.getLogger().info("Test Item Model Provider");
    }
}
