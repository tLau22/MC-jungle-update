package init;

import java.util.Random;

import com.google.common.base.Supplier;
import com.tlau.apes.Apesmod;

import init.itemproperties.BananaItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, Apesmod.MOD_ID);
	public static final RegistryObject <Item> banana=register("banana",
																()->new BananaItem(new Item.Properties().tab(Apesmod.CMTab).
																food(new FoodProperties.Builder().saturationMod(1.0f).
																		effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED,180+ new Random().nextInt(50)-25),
																									 0.20f).
																		nutrition(4).fast().build())));
	
	private static <T extends Item>RegistryObject<T> register(final String name, final Supplier<T>item){
		return Items.register(name, item);
	}
}
