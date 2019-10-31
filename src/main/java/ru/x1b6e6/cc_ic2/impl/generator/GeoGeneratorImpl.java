package ru.x1b6e6.cc_ic2.impl.generator;

import net.minecraftforge.fluids.FluidTank;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.generator.tileentity.TileEntityGeoGenerator;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "geo_generator",
				tileentity = TileEntityGeoGenerator.class)
public class GeoGeneratorImpl extends BaseGeneratorImpl {
	@PeripheralFunc
	public static Object[] getFluidSlot(TileEntityGeoGenerator te,
										IComputerAccess icoAccess,
										ILuaContext icoContext, Object[] args) {
		try {
			FluidTank ft = (FluidTank)Utils.getObject(te, "fluidTank");
			return Utils.getFluidInfo(ft);
		} catch (Exception e) {
		}

		return null;
	}
}
