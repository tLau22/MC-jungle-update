package datagen.client.lang;



import com.tlau.apes.Apesmod;

import init.BlockInit;
import init.ItemInit;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

	public ModEnUsProvider(DataGenerator gen) {
		super(gen, Apesmod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		
		// Item Groups
		add("itemGroup.tutorialmod", "Tutorial Mod Tab");
		
		// Items
		add(ItemInit.banana.get(), "banana");
		
		// Blocks
		add(BlockInit.bananaBlock.get(), "BananaBlock");
		add(BlockInit.bananaPlanks.get(), "BananaPlanks");
	}

}