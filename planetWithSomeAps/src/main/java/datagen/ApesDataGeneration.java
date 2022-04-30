package datagen;

import com.tlau.apes.Apesmod;

import datagen.client.ModBlockStateProvider;
import datagen.client.ModItemModelProvider;
import datagen.client.lang.ModEnUsProvider;
import datagen.server.ModBlockTagsProvider;
import datagen.server.ModItemTagsProvider;
import datagen.server.ModLootTableProvider;
import datagen.server.ModRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Apesmod.MOD_ID, bus = Bus.MOD)
public class ApesDataGeneration {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper helper = event.getExistingFileHelper();
		
		if (event.includeClient()) {
			
			// Client Data Generation
			generator.addProvider(new ModBlockStateProvider(generator, helper));
			generator.addProvider(new ModItemModelProvider(generator, helper));
			generator.addProvider(new ModEnUsProvider(generator));
		}
		
		if (event.includeServer()) {
			
			ModBlockTagsProvider blockTags = new ModBlockTagsProvider(generator, helper);
			
			// Server Data Generation
			generator.addProvider(new ModRecipeProvider(generator));
			generator.addProvider(blockTags);
			generator.addProvider(new ModItemTagsProvider(generator, blockTags, helper));
			generator.addProvider(new ModLootTableProvider(generator));
			
		}
	}
}