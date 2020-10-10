package mrp_v2.mrp_v2datagenlibrary.datagen;

import net.minecraft.data.DataGenerator;

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
}
