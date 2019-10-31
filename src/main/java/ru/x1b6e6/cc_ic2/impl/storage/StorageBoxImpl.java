package ru.x1b6e6.cc_ic2.impl.storage;

import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.lua.ILuaContext;
import ic2.core.block.storage.box.TileEntityStorageBox;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "storage_box", tileentity = TileEntityStorageBox.class)
public class StorageBoxImpl extends InvertoryImpl {
	@PeripheralFunc
	public static Object[] getSizeInventory(TileEntityStorageBox te,
											IComputerAccess computerAccess,
											ILuaContext luaContext,
											Object[] args) {
		return Utils.toArray(te.getSizeInventory());
	}

	@PeripheralFunc
	public static Object[] getStackInSlot(TileEntityStorageBox te,
										  IComputerAccess computerAccess,
										  ILuaContext luaContext,
										  Object[] args) {
		if (args == null || args.length != 1 || args[0] == null ||
			!(args[0] instanceof Double)) {
			return null;
		}

		return Utils.getItemInfo(
			te.getStackInSlot(Double.class.cast(args[0]).intValue()));
	}

	@PeripheralFunc
	public static Object[] isEmpty(TileEntityStorageBox te,
								   IComputerAccess computerAccess,
								   ILuaContext luaContext, Object[] args) {
		return Utils.toArray(te.isEmpty());
	}
}
