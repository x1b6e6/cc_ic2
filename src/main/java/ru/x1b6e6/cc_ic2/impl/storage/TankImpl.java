package ru.x1b6e6.cc_ic2.impl.storage;

import net.minecraftforge.fluids.FluidTank;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.comp.Fluids;
import ic2.core.block.storage.tank.TileEntityTank;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "tank", tileentity = TileEntityTank.class)
public class TankImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getFluidTank(TileEntityTank te,
										IComputerAccess computer,
										ILuaContext context, Object[] args) {
		try {
			Fluids fs = (Fluids)Utils.getObject(te, "fluidsComponent");
			Iterable<? extends FluidTank> ift = fs.getAllTanks();
			return Utils.getFluidInfo((FluidTank)ift.iterator().next());
		} catch (Exception e) {
		}
		return null;
	}
}
