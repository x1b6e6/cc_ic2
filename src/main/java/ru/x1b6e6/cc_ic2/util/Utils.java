package ru.x1b6e6.cc_ic2.util;

import java.lang.reflect.Field;

import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidTank;
import ru.x1b6e6.cc_ic2.IC2Mod;

public class Utils {
	/*
	 * @brief fast get info about FluidTank
	 *
	 * @param fluidTank is taget for getting info
	 *
	 * @return {fluid name, fluid amount, tank capacity}
	 */
	public static Object[] getFluidInfo(FluidTank fluidTank) {
		if (fluidTank == null || fluidTank.getFluidAmount() == 0) {
			return toArray("empty", 0, fluidTank == null ? 0 : fluidTank.getCapacity());
		}
		return toArray(fluidTank.getFluid().getUnlocalizedName(), fluidTank.getFluidAmount(), fluidTank.getCapacity());
	}

	/*
	 * @brief fast get info about ItemStack
	 *
	 * @param itemStack is target for getting info
	 *
	 * @return {item name, item counts, item health, item max health}
	 */
	public static Object[] getItemInfo(ItemStack itemStack) {
		if (itemStack == null || itemStack.getUnlocalizedName().equals("tile.air")) {
			return toArray("empty", 0, 0, 0);
		}
		return toArray(itemStack.getUnlocalizedName(), itemStack.getCount(),
				itemStack.getMaxDamage() - itemStack.getItemDamage(), itemStack.getMaxDamage());
	}

	/*
	 * @brief fast get info about BlockPos
	 *
	 * @param blockPos is target for getting info
	 *
	 * @return {x, y, z}
	 */
	public static Object[] getBlockPos(BlockPos blockPos) {
		return toArray(blockPos.getX(), blockPos.getY(), blockPos.getZ());
	}

	/*
	 * @brief fast convert few arguments to array
	 *
	 * @param t is a objects for result
	 *
	 * @return array of args
	 */
	public static Object[] toArray(Object... t) {
		return t;
	}

	/*
	 * @brief find declared field (recurse)
	 *
	 * @param cl is a class, where find
	 * @param name is name of target field
	 *
	 * @return founded field
	 */
	public static Field getDeclaredField(Class<?> cl, String name) throws NoSuchFieldException {
		try {
			Field f = cl.getDeclaredField(name);
			return f;
		} catch (NoSuchFieldException e) {
			Class<?> s = cl.getSuperclass();
			return getDeclaredField(s, name);
		}
	}

	/*
	 * @brief getting private/protected object by name
	 *
	 * @param obj is target object, where find
	 * @param varName is name of target field
	 *
	 * @return founded object
	 */
	public static Object getObject(Object obj, String varName) throws NoSuchFieldException, IllegalAccessException {
		try {
			Field f = getDeclaredField(obj.getClass(), varName);
			f.setAccessible(true);
			return f.get(obj);
		} catch (Exception e) {
			IC2Mod.log_error(e.getMessage() + e.getStackTrace());
			throw e;
		}
	}
}
