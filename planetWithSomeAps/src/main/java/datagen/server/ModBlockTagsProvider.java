package datagen.server;



import com.tlau.apes.Apesmod;

import init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {

	public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Apesmod.MOD_ID, helper);
	}
	
	@Override
	protected void addTags() {
		tag(Tags.Blocks.SAND).add(BlockInit.bananaPlanks.get());
	}

}