package ru.x1b6e6.cc_ic2.impl.kineticgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.kineticgenerator.tileentity.TileEntityWaterKineticGenerator;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "water_kinetic_generator",
				tileentity = TileEntityWaterKineticGenerator.class)
public class WaterKineticGeneratorImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getKuOutput(TileEntityWaterKineticGenerator te,
									   IComputerAccess computer,
									   ILuaContext context, Object[] args) {
		return Utils.toArray(te.getKuOutput());
	}
	@PeripheralFunc
	public static Object[] getEfficiency(TileEntityWaterKineticGenerator te,
										 IComputerAccess computer,
										 ILuaContext context, Object[] args) {
		return Utils.toArray(te.getEfficiency());
	}
	@PeripheralFunc
	public static Object[] getRotor(TileEntityWaterKineticGenerator te,
									IComputerAccess computer,
									ILuaContext context, Object[] args) {
		return Utils.getItemInfo(te.rotorSlot.get());
	}
}
