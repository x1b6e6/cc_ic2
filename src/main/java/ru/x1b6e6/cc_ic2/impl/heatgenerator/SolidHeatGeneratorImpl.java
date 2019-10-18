package ru.x1b6e6.cc_ic2.impl.heatgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.heatgenerator.tileentity.TileEntitySolidHeatGenerator;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.HeatSourceImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "solid_heat_generator",
				tileentity = TileEntitySolidHeatGenerator.class)
public class SolidHeatGeneratorImpl extends HeatSourceImpl {
	@PeripheralFunc
	public static Object[] needsFuel(TileEntitySolidHeatGenerator te,
									 IComputerAccess computer,
									 ILuaContext context, Object[] args) {
		return Utils.toArray(te.needsFuel());
	}
}
