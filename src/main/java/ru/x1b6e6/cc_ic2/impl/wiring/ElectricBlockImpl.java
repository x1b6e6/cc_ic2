package ru.x1b6e6.cc_ic2.impl.wiring;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.wiring.TileEntityElectricBlock;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "electric_block",
				tileentity = TileEntityElectricBlock.class)
public class ElectricBlockImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getEnergy(TileEntityElectricBlock te,
									 IComputerAccess computer,
									 ILuaContext iluContext, Object[] args) {
		return Utils.toArray(te.energy.getEnergy());
	}

	@PeripheralFunc
	public static Object[] getCapacity(TileEntityElectricBlock te,
									   IComputerAccess computer,
									   ILuaContext iluContext, Object[] args) {
		return Utils.toArray(te.getCapacity());
	}

	@PeripheralFunc
	public static Object[] getOutput(TileEntityElectricBlock te,
									 IComputerAccess computer,
									 ILuaContext iluContext, Object[] args) {
		return Utils.toArray(te.getOutput());
	}
}
