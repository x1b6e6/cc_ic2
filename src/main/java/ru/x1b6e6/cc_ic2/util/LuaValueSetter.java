package ru.x1b6e6.cc_ic2.util;

import java.lang.reflect.Field;
import javax.annotation.Nullable;

import dan200.computercraft.api.lua.ILuaTask;
import dan200.computercraft.api.lua.LuaException;

public class LuaValueSetter implements ILuaTask {

	private final Field field;
	private final Object instance;
	private final Object value;

	public LuaValueSetter(Field field, Object instance, Object value) {
		this.field = field;
		this.instance = instance;
		this.value = value;
	}

	@Nullable
	@Override
	public Object[] execute() throws LuaException {
		if (instance == null) {
			return null;
		}
		field.setAccessible(true);
		try {
			field.set(instance, value);
		} catch (IllegalAccessException e) {
			throw new LuaException("Failed to set value of " + field.getName() +
								   " for entity of type " +
								   instance.getClass().getName());
		}
		return null;
	}
}
