package ru.x1b6e6.cc_ic2.impl.kineticgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.kineticgenerator.tileentity.TileEntityWindKineticGenerator;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "wind_kinetic_generator",
				tileentity = TileEntityWindKineticGenerator.class)
public class WindKineticGeneratorImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getRotor(TileEntityWindKineticGenerator te,
									IComputerAccess computer,
									ILuaContext context, Object[] args) {
		return Utils.getItemInfo(te.rotorSlot.get());
	}

	@PeripheralFunc
	public static Object[] hasRotor(TileEntityWindKineticGenerator te,
									IComputerAccess computer,
									ILuaContext context, Object[] args) {
		return Utils.toArray(te.hasRotor());
	}

	@PeripheralFunc
	public static Object[] rotorHasSpace(TileEntityWindKineticGenerator te,
										 IComputerAccess computer,
										 ILuaContext context, Object[] args) {
		return Utils.toArray(te.rotorHasSpace());
	}

	@PeripheralFunc
	public static Object[] getEfficiency(TileEntityWindKineticGenerator te,
										 IComputerAccess computer,
										 ILuaContext context, Object[] args) {
		return Utils.toArray(te.getEfficiency());
	}

	@PeripheralFunc
	public static Object[] getMinWindStrength(TileEntityWindKineticGenerator te,
											  IComputerAccess computer,
											  ILuaContext context,
											  Object[] args) {
		return Utils.toArray(te.getMinWindStrength());
	}

	@PeripheralFunc
	public static Object[] getMaxWindStrength(TileEntityWindKineticGenerator te,
											  IComputerAccess computer,
											  ILuaContext context,
											  Object[] args) {
		return Utils.toArray(te.getMaxWindStrength());
	}

	@PeripheralFunc
	public static Object[] isRotorOverloaded(TileEntityWindKineticGenerator te,
											 IComputerAccess computer,
											 ILuaContext context,
											 Object[] args) {
		return Utils.toArray(te.isRotorOverloaded());
	}

	@PeripheralFunc
	public static Object[] isWindStrongEnough(TileEntityWindKineticGenerator te,
											  IComputerAccess computer,
											  ILuaContext context,
											  Object[] args) {
		return Utils.toArray(te.isWindStrongEnough());
	}

	@PeripheralFunc
	public static Object[] getKuOutput(TileEntityWindKineticGenerator te,
									   IComputerAccess computer,
									   ILuaContext context, Object[] args) {
		return Utils.toArray(te.getKuOutput());
	}

	@PeripheralFunc
	public static Object[] getWindStrength(TileEntityWindKineticGenerator te,
										   IComputerAccess computer,
										   ILuaContext context, Object[] args) {
		return Utils.toArray(te.getWindStrength());
	}

	@PeripheralFunc
	public static Object[] getObstructions(TileEntityWindKineticGenerator te,
										   IComputerAccess computer,
										   ILuaContext context, Object[] args) {
		return Utils.toArray(te.getObstructions());
	}
}
