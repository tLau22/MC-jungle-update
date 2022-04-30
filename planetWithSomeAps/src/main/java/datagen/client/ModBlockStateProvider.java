package datagen.client;




import com.tlau.apes.Apesmod;

import init.BlockInit;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

	public ModBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
		super(generator, Apesmod.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(BlockInit.bananaBlock.get());
	}
}