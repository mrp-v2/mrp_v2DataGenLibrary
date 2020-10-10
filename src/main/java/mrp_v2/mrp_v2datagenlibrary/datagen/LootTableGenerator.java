package mrp_v2.mrp_v2datagenlibrary.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Pass an instance of this class to {@link DataGenerator#addProvider(IDataProvider)}.
 */
public class LootTableGenerator extends LootTableProvider
{
    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>>
            lootTables;
    private final String modId;

    public LootTableGenerator(DataGenerator dataGeneratorIn, LootTables lootTables, String modId)
    {
        this(dataGeneratorIn, () -> lootTables, modId);
    }

    public LootTableGenerator(DataGenerator dataGeneratorIn,
            Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>> lootTablesProvider, String modId)
    {
        super(dataGeneratorIn);
        lootTables = ImmutableList.of(Pair.of(lootTablesProvider, LootParameterSets.BLOCK));
        this.modId = modId;
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return this.lootTables;
    }

    @Override protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker)
    {
        map.forEach(
                (resourceLocation, lootTable) -> LootTableManager.validateLootTable(validationtracker, resourceLocation,
                        lootTable));
    }

    @Override public String getName()
    {
        return super.getName() + ": " + modId;
    }
}
