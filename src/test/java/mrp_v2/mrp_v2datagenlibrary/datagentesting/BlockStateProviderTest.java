package mrp_v2.mrp_v2datagenlibrary.datagentesting;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;

public class BlockStateProviderTest extends BlockStateProvider
{
    public BlockStateProviderTest(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
    }

    @Override protected void registerStatesAndModels()
    {
        LogManager.getLogger().info("Test Block State Provider");
    }
}
