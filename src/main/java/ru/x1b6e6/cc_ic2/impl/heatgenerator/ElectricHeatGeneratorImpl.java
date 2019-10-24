package ru.x1b6e6.cc_ic2.impl.heatgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.heatgenerator.tileentity.TileEntityElectricHeatGenerator;

import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.impl.HeatSourceImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "electric_heat_generator", tileentity = TileEntityElectricHeatGenerator.class)
public class ElectricHeatGeneratorImpl extends HeatSourceImpl {
	@PeripheralFunc
	public static Object[] getChargeLevel(TileEntityElectricHeatGenerator te, IComputerAccess computer,
			ILuaContext context, Object[] args) {
		return Utils.toArray(te.getChargeLevel());
	}
}
