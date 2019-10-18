package ru.x1b6e6.cc_ic2.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import ic2.api.item.ICustomDamageItem;
import ic2.api.reactor.IReactor;
import ic2.api.reactor.IReactorComponent;
import ic2.core.IC2;
import ic2.core.util.StackUtil;

public abstract class Prototype extends Item implements IReactorComponent, ICustomDamageItem {
	public final int MAX_HEAT;

	public Prototype(String NAME, int m) {
		MAX_HEAT = m;
		setUnlocalizedName(NAME);
		setRegistryName(NAME);
		setCreativeTab(IC2.tabIC2);
		setNoRepair();
		ForgeRegistries.ITEMS.register(this);
		ModelLoader.setCustomModelResourceLocation(this, 0,
				new ModelResourceLocation(this.getRegistryName(), "invertory"));
	}

	@Override
	public boolean acceptUraniumPulse(ItemStack stack, IReactor reactor, ItemStack pulsingStack, int youX, int youY,
			int pulseX, int pulseY, boolean heatrun) {
		return false;
	}

	@Override
	public int getCurrentHeat(ItemStack stack, IReactor reactor, int x, int y) {
		return getCustomDamage(stack);
	}

	@Override
	public int alterHeat(ItemStack stack, IReactor reactor, int x, int y, int heat) {
		if (!reactor.isFluidCooled())
			return heat;
		int myHeat = getCurrentHeat(stack, reactor, x, y);
		myHeat += heat;

		int max = MAX_HEAT;

		if (myHeat > max) {
			reactor.setItemAt(x, y, null);
			heat = max - myHeat + 1;
		} else {
			if (myHeat < 0) {
				heat = myHeat;
				myHeat = 0;
			} else {
				heat = 0;
			}

			setCustomDamage(stack, myHeat);
		}

		return heat;
	}

	@Override
	public float influenceExplosion(ItemStack stack, IReactor reactor) {
		return 0;
	}

	@Override
	public boolean canBePlacedIn(ItemStack stack, IReactor reactor) {
		return true;
	}

	@Override
	public int getMaxHeat(ItemStack stack, IReactor reactor, int x, int y) {
		return MAX_HEAT;
	}

	@Override
	public boolean canStoreHeat(ItemStack stack, IReactor reactor, int x, int y) {
		return true;
	}

	@Override
	public boolean showDurabilityBar(ItemStack p_showDurabilityBar_1_) {
		return true;
	}

	@Override
	public boolean isDamageable() {
		return true;
	}

	@Override
	public boolean isDamaged(ItemStack stack) {
		return getCustomDamage(stack) > 0;
	}

	@Override
	public void setCustomDamage(ItemStack stack, int damage) {
		NBTTagCompound nbt = StackUtil.getOrCreateNbtData(stack);
		nbt.setInteger("advDmg", damage);
	}

	@Override
	public int getCustomDamage(ItemStack stack) {
		if (stack.hasTagCompound())
			return stack.getTagCompound().getInteger("advDmg");
		return 0;
	}

	@Override
	public int getMaxCustomDamage(ItemStack stack) {
		return MAX_HEAT;
	}

	@Override
	public boolean applyCustomDamage(ItemStack stack, int damage, EntityLivingBase src) {
		setCustomDamage(stack, getCustomDamage(stack) + damage);
		return true;
	}

	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return (double) getCustomDamage(stack) / (double) getMaxCustomDamage(stack);
	}

	@Override
	public int getDamage(ItemStack stack) {
		return getCustomDamage(stack);
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return getMaxCustomDamage(stack);
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (!isInCreativeTab(tab)) {
			return;
		}
		ItemStack stack = new ItemStack(this);
		setCustomDamage(stack, 0);
		subItems.add(stack);
	}
}
