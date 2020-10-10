package mrp_v2.mrp_v2datagenlibrary.datagentesting;

import mrp_v2.mrp_v2datagenlibrary.MRP_V2DataGenLibrary;
import mrp_v2.mrp_v2datagenlibrary.datagen.LootTableGenerator;
import mrp_v2.mrp_v2datagenlibrary.datagen.LootTables;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MRP_V2DataGenLibrary.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandlerTest
{
    @SubscribeEvent public static void gatherDataEvent(final GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer())
        {
            LootTables lootTables = new LootTables();
            lootTables.addLootTable(Blocks.GLASS, lootTables::registerDropSelfLootTable);
            generator.addProvider(new LootTableGenerator(generator, () -> lootTables, MRP_V2DataGenLibrary.ID));
        }
    }
}
