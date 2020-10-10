package mrp_v2.mrp_v2datagenlibrary.datagentesting;

import mrp_v2.mrp_v2datagenlibrary.MRP_V2DataGenLibrary;
import mrp_v2.mrp_v2datagenlibrary.datagen.DataGeneratorHelper;
import mrp_v2.mrp_v2datagenlibrary.datagen.LootTables;
import net.minecraft.block.Blocks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MRP_V2DataGenLibrary.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandlerTest
{
    @SubscribeEvent public static void gatherDataEvent(final GatherDataEvent event)
    {
        DataGeneratorHelper helper = new DataGeneratorHelper(event, MRP_V2DataGenLibrary.ID);
        if (event.includeServer())
        {
            LootTables lootTables = new LootTables();
            lootTables.addLootTable(Blocks.GLASS, lootTables::registerDropSelfLootTable);
            helper.addLootTables(lootTables);
            helper.addRecipeGenerator(RecipeGeneratorTest::new);
            helper.addBlockTagGenerator(BlockTagGeneratorTest::new);
            helper.addItemTagGenerator(ItemTagGeneratorTest::new);
        }
        if (event.includeClient())
        {
            helper.addBlockStateProvider(BlockStateProviderTest::new);
            helper.addItemModelProvider(ItemModelProviderTest::new);
        }
    }
}
