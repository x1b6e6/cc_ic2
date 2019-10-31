package ru.x1b6e6.cc_ic2.impl.machine;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.machine.tileentity.TileEntityBatchCrafter;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "batch_crafter",
				tileentity = TileEntityBatchCrafter.class)
public class BatchCrafterImpl extends ElectricMachineImpl {
	@PeripheralFunc
	public static Object[] hasRecipe(TileEntityBatchCrafter te,
									 IComputerAccess computerAccess,
									 ILuaContext luaContext, Object[] args) {
		return Utils.toArray(te.hasRecipe());
	}

	@PeripheralFunc
	public static Object[] canCraft(TileEntityBatchCrafter te,
									IComputerAccess computerAccess,
									ILuaContext luaContext, Object[] args) {
		return Utils.toArray(te.canCraft());
	}

	@PeripheralFunc
	public static Object[] getEnergy(TileEntityBatchCrafter te,
									 IComputerAccess computerAccess,
									 ILuaContext luaContext, Object[] args) {
		return Utils.toArray(te.getEnergy());
	}

	@PeripheralFunc
	public static Object[] getOutput(TileEntityBatchCrafter te,
									 IComputerAccess computerAccess,
									 ILuaContext luaContext, Object[] args) {
		return Utils.getItemInfo(te.craftingOutput.get());
	}
}
