package mrp_v2.mrp_v2datagenlibrary.datagen;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Loot tables are added by calling {@link LootTables#addLootTable(Block, Consumer)}.
 */
public class LootTables extends BlockLootTables
{
    private final IdentityHashMap<Block, Consumer<Block>> knownBlocks;

    public LootTables()
    {
        this.knownBlocks = new IdentityHashMap<>();
    }

    public final void addLootTable(Block block, Consumer<Block> lootTableFunction)
    {
        this.knownBlocks.put(block, lootTableFunction);
    }

    @Override protected final void addTables()
    {
        for (Map.Entry<Block, Consumer<Block>> entry : knownBlocks.entrySet())
        {
            entry.getValue().accept(entry.getKey());
        }
    }

    @Override protected final Iterable<Block> getKnownBlocks()
    {
        return this.knownBlocks.keySet();
    }
}
