package mrp_v2.mrp_v2datagenlibrary.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.logging.log4j.LogManager;

public abstract class TranslationGenerator extends LanguageProvider
{
    protected final String modid;

    public TranslationGenerator(DataGenerator gen, String modid, String locale)
    {
        super(gen, modid, locale);
        this.modid = modid;
    }

    public void add(ItemGroup key, String name)
    {
        TranslationTextComponent test = key.getGroupName() instanceof TranslationTextComponent ?
                (TranslationTextComponent) key.getGroupName() :
                null;
        if (test != null)
        {
            add(test.getKey(), name);
        } else
        {
            LogManager.getLogger()
                    .warn("Could not make a translation for " +
                            key +
                            " because its groupName is not a TranslationTextComponent!");
        }
    }

    @Override public String getName()
    {
        return super.getName() + ": " + this.modid;
    }
}
