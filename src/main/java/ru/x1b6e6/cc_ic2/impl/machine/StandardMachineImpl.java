package ru.x1b6e6.cc_ic2.impl.machine;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.machine.tileentity.TileEntityStandardMachine;

import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "standard_machine",
				tileentity = TileEntityStandardMachine.class)
public class StandardMachineImpl extends ElectricMachineImpl {
	@PeripheralFunc
	public static Object[] getProgress(TileEntityStandardMachine<?,?,?> te,
									   IComputerAccess computer,
									   ILuaContext context, Object[] args) {
		return Utils.toArray(te.getProgress());
	}
	@PeripheralFunc
	public static Object[] getEnergy(TileEntityStandardMachine<?,?,?> te,
									 IComputerAccess computer,
									 ILuaContext context, Object[] args) {
		return Utils.toArray(te.getEnergy());
	}
	@PeripheralFunc
	public static Object[] getActive(TileEntityStandardMachine<?,?,?> te,
									 IComputerAccess computer,
									 ILuaContext context, Object[] args) {
		return Utils.toArray(te.getActive());
	}
}
