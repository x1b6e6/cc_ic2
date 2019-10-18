package ru.x1b6e6.cc_ic2.impl.heatgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.heatgenerator.tileentity.TileEntityFluidHeatGenerator;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.HeatSourceImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "fluid_heat_generator",
				tileentity = TileEntityFluidHeatGenerator.class)
public class FluidHeatGeneratorImpl extends HeatSourceImpl {
	@PeripheralFunc
	public static Object[] getTankAmount(TileEntityFluidHeatGenerator te,
										 IComputerAccess computer,
										 ILuaContext context, Object[] args) {
		return Utils.toArray(te.getTankAmount());
	}
	@PeripheralFunc
	public static Object[] needsFluid(TileEntityFluidHeatGenerator te,
									  IComputerAccess computer,
									  ILuaContext context, Object[] args) {
		return Utils.toArray(te.needsFluid());
	}
}
