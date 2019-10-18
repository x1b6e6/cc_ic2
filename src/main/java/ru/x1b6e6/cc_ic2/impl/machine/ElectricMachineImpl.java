package ru.x1b6e6.cc_ic2.impl.machine;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.machine.tileentity.TileEntityElectricMachine;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "electric_machine",
				tileentity = TileEntityElectricMachine.class)
public class ElectricMachineImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getInputSlot(TileEntityElectricMachine te,
										IComputerAccess computer,
										ILuaContext context, Object[] args) {
		return Utils.getItemInfo(te.dischargeSlot.get());
	}
}
