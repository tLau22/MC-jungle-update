package com.tlau.apes;


import init.BlockInit;
import init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("apes")

public class Apesmod {
	
		public static final String  MOD_ID = "apes";
		
		public static final CreativeModeTab CMTab = new CreativeModeTab(MOD_ID) {	
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack makeIcon() {
				
				return new ItemStack(ItemInit.banana.get());
			}};
	
		public Apesmod() {
			IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
			ItemInit.Items.register(bus);
			BlockInit.Blocks.register(bus);
			MinecraftForge.EVENT_BUS.register(this);
		}
}
