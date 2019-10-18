package ru.x1b6e6.cc_ic2.impl.kineticgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.kineticgenerator.tileentity.TileEntityElectricKineticGenerator;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "electric_kinetic_generator",
				tileentity = TileEntityElectricKineticGenerator.class)
public class ElectricKineticGeneratorImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getMaxKU(TileEntityElectricKineticGenerator te,
									IComputerAccess computer,
									ILuaContext context, Object[] args) {
		return Utils.toArray(te.getMaxKU());
	}
}
