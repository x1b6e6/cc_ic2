package ru.x1b6e6.cc_ic2.impl.reactor;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.peripheral.IComputerAccess;
import ic2.core.block.reactor.tileentity.TileEntityReactorChamberElectric;

import ru.x1b6e6.cc_ic2.annotation.*;

@TileEntityBind(name = "reactor",
				tileentity = TileEntityReactorChamberElectric.class)
public class ReactorChamberImpl extends ReactorImpl {
	@PeripheralFunc
	public static Object[] getOut(TileEntityReactorChamberElectric te,
								  IComputerAccess access, ILuaContext context,
								  Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.getOut(te.getReactorInstance(), access, context,
								  args);
	}

	@PeripheralFunc
	public static Object[] getHeat(TileEntityReactorChamberElectric te,
								   IComputerAccess access, ILuaContext context,
								   Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.getHeat(te.getReactorInstance(), access, context,
								   args);
	}

	@PeripheralFunc
	public static Object[] getFluidHot(TileEntityReactorChamberElectric te,
									   IComputerAccess access,
									   ILuaContext context, Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.getFluidHot(te.getReactorInstance(), access, context,
									   args);
	}

	@PeripheralFunc
	public static Object[] getFluidCold(TileEntityReactorChamberElectric te,
										IComputerAccess access,
										ILuaContext context, Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.getFluidCold(te.getReactorInstance(), access,
										context, args);
	}

	@PeripheralFunc
	public static Object[] isActive(TileEntityReactorChamberElectric te,
									IComputerAccess access, ILuaContext context,
									Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.isActive(te.getReactorInstance(), access, context,
									args);
	}

	@PeripheralFunc
	public static Object[] getFuelRemaining(TileEntityReactorChamberElectric te,
											IComputerAccess access,
											ILuaContext context, Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.getFuelRemaining(te.getReactorInstance(), access,
											context, args);
	}

	@PeripheralFunc
	public static Object[] setStatePrototype(
		TileEntityReactorChamberElectric te, IComputerAccess access,
		ILuaContext context, Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.setStatePrototype(te.getReactorInstance(), access,
											 context, args);
	}

	@PeripheralFunc
	public static Object[] getStatePrototype(
		TileEntityReactorChamberElectric te, IComputerAccess access,
		ILuaContext context, Object[] args)
		throws NoSuchFieldException, IllegalAccessException {
		return ReactorImpl.getStatePrototype(te.getReactorInstance(), access,
											 context, args);
	}

	@PeripheralFunc
	public static Object[] hasDepleted(TileEntityReactorChamberElectric te,
									   IComputerAccess access,
									   ILuaContext context, Object[] args) {
		return ReactorImpl.hasDepleted(te.getReactorInstance(), access, context,
									   args);
	}

	@PeripheralFunc
	public static Object[] getStackInSlot(TileEntityReactorChamberElectric te,
										  IComputerAccess access,
										  ILuaContext context, Object[] args) {
		return ReactorImpl.getStackInSlot(te.getReactorInstance(), access,
										  context, args);
	}

	@PeripheralFunc
	public static Object[] getSizeInventory(TileEntityReactorChamberElectric te,
											IComputerAccess access,
											ILuaContext context,
											Object[] args) {
		return ReactorImpl.getSizeInventory(te.getReactorInstance(), access,
											context, args);
	}
}
