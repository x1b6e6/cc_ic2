package ru.x1b6e6.cc_ic2.impl.kineticgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.kineticgenerator.tileentity.TileEntityStirlingKineticGenerator;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "stirling_kinetic_generator", tileentity = TileEntityStirlingKineticGenerator.class)
public class StirlingKineticGeneratorImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getOutputTank(TileEntityStirlingKineticGenerator te, IComputerAccess computer,
			ILuaContext context, Object[] args) {
		return Utils.getFluidInfo(te.getOutputTank());
	}

	@PeripheralFunc
	public static Object[] getInputTank(TileEntityStirlingKineticGenerator te, IComputerAccess computer,
			ILuaContext context, Object[] args) {
		return Utils.getFluidInfo(te.getInputTank());
	}
}
