package ru.x1b6e6.cc_ic2.impl.reactor;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.peripheral.IComputerAccess;
import ic2.api.reactor.IReactorComponent;
import ic2.core.block.reactor.tileentity.TileEntityNuclearReactorElectric;
import ic2.core.item.reactor.ItemReactorDepletedUranium;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.item.PrototypeHeatVent2;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "reactor", tileentity = TileEntityNuclearReactorElectric.class)
public class ReactorImpl extends InvertoryImpl {

	@PeripheralFunc
	public static Object[] getOut(TileEntityNuclearReactorElectric te, IComputerAccess access, ILuaContext context,
			Object[] args) throws NoSuchFieldException, IllegalAccessException {
		if (te.isFluidCooled()) {
			return Utils.toArray(te.EmitHeat, "Hu/t");
		}
		return Utils.toArray(te.getReactorEUEnergyOutput(), "Eu/t");
	}

	@PeripheralFunc
	public static Object[] getHeat(TileEntityNuclearReactorElectric te, IComputerAccess access, ILuaContext context,
			Object[] args) throws NoSuchFieldException, IllegalAccessException {
		return Utils.toArray(te.getHeat(), te.getMaxHeat());
	}

	@PeripheralFunc
	public static Object[] getFluidHot(TileEntityNuclearReactorElectric te, IComputerAccess access, ILuaContext context,
			Object[] args) throws NoSuchFieldException, IllegalAccessException {
		return Utils.getFluidInfo(te.getoutputtank());
	}

	@PeripheralFunc
	public static Object[] getFluidCold(TileEntityNuclearReactorElectric te, IComputerAccess access,
			ILuaContext context, Object[] args) throws NoSuchFieldException, IllegalAccessException {
		return Utils.getFluidInfo(te.getinputtank());
	}

	@PeripheralFunc
	public static Object[] isActive(TileEntityNuclearReactorElectric te, IComputerAccess access, ILuaContext context,
			Object[] args) throws NoSuchFieldException, IllegalAccessException {
		return Utils.toArray(te.getActive());
	}

	@PeripheralFunc
	public static Object[] getFuelRemaining(TileEntityNuclearReactorElectric te, IComputerAccess access,
			ILuaContext context, Object[] args) throws NoSuchFieldException, IllegalAccessException {
		int o = -1;

		for (int i = 0; i < te.getSizeInventory(); i++) {
			ItemStack stack = te.getStackInSlot(i);
			if (stack == null)
				continue;
			Item item = stack.getItem();

			if (item instanceof IReactorComponent)
				if (!((IReactorComponent) item).canStoreHeat(stack, te, 0, 0) && item.isDamageable()) {
					int d = item.getMaxDamage(stack) - item.getDamage(stack);
					if (d < o || o == -1)
						o = d;
				}
		}

		o = o == -1 ? 0 : o;

		return Utils.toArray(o);
	}

	@PeripheralFunc
	public static Object[] setStatePrototype(TileEntityNuclearReactorElectric te, IComputerAccess access,
			ILuaContext context, Object[] args) throws NoSuchFieldException, IllegalAccessException {
		if (args == null || args.length < 1 || args[0] == null || !(args[0] instanceof Double))
			return null;

		double s = ((Double) args[0]).doubleValue();

		for (int i = 0; i < te.getSizeInventory(); i++) {
			ItemStack stack = te.getStackInSlot(i);
			if (stack == null)
				continue;
			Item item = stack.getItem();
			if (item == null)
				continue;
			if (item instanceof PrototypeHeatVent2)
				((PrototypeHeatVent2) item).setState(stack, s);
		}

		return null;
	}

	@PeripheralFunc
	public static Object[] getStatePrototype(TileEntityNuclearReactorElectric te, IComputerAccess access,
			ILuaContext context, Object[] args) throws NoSuchFieldException, IllegalAccessException {

		double s = 0.0D;

		int c = 0;

		for (int i = 0; i < te.getSizeInventory(); i++) {
			ItemStack stack = te.getStackInSlot(i);
			if (stack == null)
				continue;
			Item item = stack.getItem();
			if (item == null)
				continue;
			if (item instanceof PrototypeHeatVent2) {
				s += ((PrototypeHeatVent2) item).getState(stack);
				c++;
			}
		}

		s = c == 0 ? 0 : s / c;
		return Utils.toArray(s);
	}

	@PeripheralFunc
	public static Object[] hasDepleted(TileEntityNuclearReactorElectric te, IComputerAccess computer,
			ILuaContext context, Object[] args) {

		for (int i = 0; i < te.getSizeInventory(); i++) {
			ItemStack stack = te.getStackInSlot(i);
			if (stack == null)
				continue;
			Item item = stack.getItem();
			if (item == null)
				continue;
			if (item instanceof ItemReactorDepletedUranium) {
				return Utils.toArray(true);
			}
		}

		return Utils.toArray(false);
	}

	@PeripheralFunc
	public static Object[] getSizeInventory(TileEntityNuclearReactorElectric te, IComputerAccess computerAccess,
			ILuaContext luaContext, Object[] args) {
		return Utils.toArray(te.getSizeInventory());
	}

	@PeripheralFunc
	public static Object[] getStackInSlot(TileEntityNuclearReactorElectric te, IComputerAccess computerAccess,
			ILuaContext luaContext, Object[] args) {
		if (args == null || args.length != 1 || args[0] == null || !(args[0] instanceof Double))
			return null;
		return Utils.getItemInfo(te.getStackInSlot(Double.class.cast(args[0]).intValue()));
	}
}
