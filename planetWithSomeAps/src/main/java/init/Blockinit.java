package init;

import java.util.function.Function;

import com.google.common.base.Supplier;
import com.tlau.apes.Apesmod;

import init.blockproperties.BananaBlock;
import init.blockproperties.BananaBlockItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blockinit {
	public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, Apesmod.MOD_ID);
	public static final DeferredRegister<Item> Items = ItemInit.Items;
	
	public static final RegistryObject <Block> bananaBlock=register("banana_block",
			()->new BananaBlock(BlockBehaviour.Properties.of(Material.WOOD,MaterialColor.COLOR_YELLOW)),
			object->()->new BananaBlockItem(object.get(),new Item.Properties().tab(Apesmod.CMTab)));
	public static final RegistryObject <Block> bananaPlanks=register("banana_planks",
			()->new Block(BlockBehaviour.Properties.of(Material.WOOD,MaterialColor.COLOR_YELLOW)),
			object->()->new BlockItem(object.get(),new Item.Properties().tab(Apesmod.CMTab)));
			
	
	private static <T extends Block>RegistryObject<T> registerBlock(final String name, final Supplier<? extends T>block){
		return Blocks.register(name,block);
	}
	private static <T extends Block>RegistryObject<T> register(final String name,final Supplier<? extends T>block,
																	Function<RegistryObject<T>, Supplier<? extends Item>>item){
		RegistryObject<T> obj= registerBlock(name,block);
		Items.register(name, item.apply(obj));
		return obj;
	}
	
		
}
