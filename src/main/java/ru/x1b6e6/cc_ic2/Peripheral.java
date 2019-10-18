package ru.x1b6e6.cc_ic2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.tileentity.TileEntity;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;

public class Peripheral implements IPeripheral {
	private Method[] methods;
	private String[] method_names;

	Class<? extends TileEntity> te_class;
	TileEntity te;

	String peripheral_name;

	public Peripheral(@Nonnull TileEntity te, @Nonnull Class<?>[] impls) {
		this.te = te;

		Class<?> top = impls[0];
		for (int j = 1; j < impls.length; j++)
			if (top.isAssignableFrom(impls[j]))
				top = impls[j];

		TileEntityBind ann = top.getAnnotation(TileEntityBind.class);
		this.peripheral_name = ann.name();
		this.te_class = ann.tileentity();

		ArrayList<String> method_names_arr = new ArrayList<>();
		ArrayList<Method> methods_arr = new ArrayList<>();

		for (Class<?> impl : impls) {
			for (Method m : impl.getMethods()) {
				if (m.isAnnotationPresent(PeripheralFunc.class)) {
					String m_name = m.getName();
					if (!method_names_arr.contains(m_name)) {
						method_names_arr.add(m_name);
						methods_arr.add(m);
					}
				}
			}
		}
		methods = methods_arr.toArray(new Method[methods_arr.size()]);
		method_names = method_names_arr.toArray(new String[method_names_arr.size()]);
	}

	@Nonnull
	@Override
	public String getType() {
		return peripheral_name;
	}

	@Override
	@Nonnull
	public String[] getMethodNames() {
		return method_names;
	}

	@Override
	@Nullable
	public Object[] callMethod(@Nonnull IComputerAccess computer, @Nonnull ILuaContext context, int method_id,
			@Nonnull Object[] args) throws LuaException, InterruptedException {
		try {
			return (Object[]) this.methods[method_id].invoke(null, te_class.cast(te), computer, context, args);
		} catch (IllegalAccessException err) {
			IC2Mod.log_error("call method " + te_class.getName() + "." + method_names[method_id] + "(" + method_id
					+ ") not work: " + err.getMessage() + err.getStackTrace());

		} catch (InvocationTargetException err) {
			IC2Mod.log_error("call method " + te_class.getName() + "." + method_names[method_id] + "(" + method_id
					+ ") not work: " + err.getMessage() + err.getStackTrace());
		}
		return null;
	}

	@Override
	public boolean equals(@Nullable IPeripheral other) {
		if (other == null)
			return false;
		if (!(other instanceof Peripheral))
			return false;

		Peripheral otherImpl = (Peripheral) other;

		return this.te.equals(otherImpl.te);
	}
}
