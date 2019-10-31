package ru.x1b6e6.cc_ic2.impl.machine;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.machine.tileentity.TileEntityLiquidHeatExchanger;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.impl.HeatSourceImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "liquid_heat_exchanger",
				tileentity = TileEntityLiquidHeatExchanger.class)
public class LiquidHeatExchangerImpl extends HeatSourceImpl {
	@PeripheralFunc
	public static Object[] getInputTank(TileEntityLiquidHeatExchanger te,
										IComputerAccess computer,
										ILuaContext context, Object[] args) {
		return Utils.getFluidInfo(te.getInputTank());
	}

	@PeripheralFunc
	public static Object[] getOutputTank(TileEntityLiquidHeatExchanger te,
										 IComputerAccess computer,
										 ILuaContext context, Object[] args) {
		return Utils.getFluidInfo(te.getOutputTank());
	}
}
