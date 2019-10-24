package ru.x1b6e6.cc_ic2.impl.kineticgenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.kineticgenerator.tileentity.TileEntitySteamKineticGenerator;

import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "steam_kinetic_generator", tileentity = TileEntitySteamKineticGenerator.class)
public class SteamKineticGeneratorImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getOut(TileEntitySteamKineticGenerator te, IComputerAccess computer, ILuaContext context,
			Object[] args) {
		return Utils.toArray(te.getKUoutput());
	}

	@PeripheralFunc
	public static Object[] hasTurbine(TileEntitySteamKineticGenerator te, IComputerAccess computer, ILuaContext context,
			Object[] args) {
		return Utils.toArray(te.hasTurbine());
	}

	@PeripheralFunc
	public static Object[] isTurbineBlockedByWater(TileEntitySteamKineticGenerator te, IComputerAccess computer,
			ILuaContext context, Object[] args) {
		return Utils.toArray(te.isTurbineBlockedByWater());
	}

	@PeripheralFunc
	public static Object[] isVentingSteam(TileEntitySteamKineticGenerator te, IComputerAccess computer,
			ILuaContext context, Object[] args) {
		return Utils.toArray(te.isVentingSteam());
	}

	@PeripheralFunc
	public static Object[] isThrottled(TileEntitySteamKineticGenerator te, IComputerAccess computer,
			ILuaContext context, Object[] args) {
		return Utils.toArray(te.isThrottled());
	}
}
