package ru.x1b6e6.cc_ic2.impl.generator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.comp.Energy;
import ic2.core.block.generator.tileentity.TileEntityBaseGenerator;

import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "base_generator", tileentity = TileEntityBaseGenerator.class)
public class BaseGeneratorImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getFuel(TileEntityBaseGenerator te, IComputerAccess conputer, ILuaContext context,
			Object[] args) {
		return Utils.toArray(te.fuel);
	}

	@PeripheralFunc
	public static Object[] getBuffer(TileEntityBaseGenerator te, IComputerAccess computer, ILuaContext context,
			Object[] args) {
		try {
			Energy e = (Energy) Utils.getObject(te, "energy");
			return Utils.toArray(e.getEnergy(), e.getCapacity());
		} catch (Exception e) {
		}
		return null;
	}

	@PeripheralFunc
	public static Object[] getSinkTier(TileEntityBaseGenerator te, IComputerAccess computer, ILuaContext context,
			Object[] args) {
		try {
			Energy e = (Energy) Utils.getObject(te, "energy");
			return Utils.toArray(e.getSinkTier());
		} catch (Exception e) {
		}

		return null;
	}

	@PeripheralFunc
	public static Object[] getSourceTier(TileEntityBaseGenerator te, IComputerAccess computer, ILuaContext context,
			Object[] args) {
		try {
			Energy e = (Energy) Utils.getObject(te, "energy");
			return Utils.toArray(e.getSourceTier());
		} catch (Exception e) {
		}

		return null;
	}
}
