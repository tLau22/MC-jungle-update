package init.blockproperties;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class BananaBlockItem extends BlockItem{
	public BananaBlockItem(Block block ,Properties properties) {
	super(block, properties);
	

}

	@Override
	public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType) {
		
		return 20*5;//=1s
	}
}
