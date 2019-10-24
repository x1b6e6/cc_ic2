package ru.x1b6e6.cc_ic2.impl.generator;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.generator.tileentity.TileEntityConversionGenerator;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "conversion_generator", tileentity = TileEntityConversionGenerator.class)
public class ConversionGeneratorImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getSourceTier(TileEntityConversionGenerator te, IComputerAccess comAccess,
			ILuaContext icoILuaContext, Object[] args) {
		return Utils.toArray(te.getSourceTier());
	}

	@PeripheralFunc
	public static Object[] getProduction(TileEntityConversionGenerator te, IComputerAccess comAccess,
			ILuaContext icoILuaContext, Object[] args) {
		return Utils.toArray(Double.parseDouble(te.getProduction()));
	}

	@PeripheralFunc
	public static Object[] getMaxProduction(TileEntityConversionGenerator te, IComputerAccess comAccess,
			ILuaContext icoILuaContext, Object[] args) {
		return Utils.toArray(Double.parseDouble(te.getMaxProduction()));
	}
}
