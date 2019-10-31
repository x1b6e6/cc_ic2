package ru.x1b6e6.cc_ic2.impl;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.peripheral.IComputerAccess;
import ic2.core.block.TileEntityHeatSourceInventory;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "heat_source",
				tileentity = TileEntityHeatSourceInventory.class)
public class HeatSourceImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getTransmitHeat(TileEntityHeatSourceInventory te,
										   IComputerAccess access,
										   ILuaContext context, Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return Utils.toArray(te.gettransmitHeat());
	}

	@PeripheralFunc
	public static Object[] getMaxHeatEmittedPerTick(
		TileEntityHeatSourceInventory te, IComputerAccess computer,
		ILuaContext context, Object[] args) {
		return Utils.toArray(te.getMaxHeatEmittedPerTick());
	}

	@PeripheralFunc
	public static Object[] getHeatBuffer(TileEntityHeatSourceInventory te,
										 IComputerAccess computerAccess,
										 ILuaContext luaContext,
										 Object[] args) {
		return Utils.toArray(te.getHeatBuffer());
	}
}
