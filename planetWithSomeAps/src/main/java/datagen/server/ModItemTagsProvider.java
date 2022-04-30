package datagen.server;



import com.tlau.apes.Apesmod;

import init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

	public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blocks, ExistingFileHelper helper) {
		super(generator, blocks, Apesmod.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Items.BARRELS).add(BlockInit.bananaPlanks.get().asItem());
	}

}