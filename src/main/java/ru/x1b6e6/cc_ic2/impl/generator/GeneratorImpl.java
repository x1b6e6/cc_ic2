package ru.x1b6e6.cc_ic2.impl.generator;

import ic2.core.block.generator.tileentity.TileEntityGenerator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "generator", tileentity = TileEntityGenerator.class)
public class GeneratorImpl extends BaseGeneratorImpl {
	@PeripheralFunc
	public static Object[] getFuelRatio(TileEntityGenerator te,
										IComputerAccess computer,
										ILuaContext context, Object[] args) {
		return Utils.toArray(te.getFuelRatio());
	}
}
