package ru.x1b6e6.cc_ic2.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.minecraft.tileentity.TileEntity;

/**
 * Annotating a class for automatically casting tileentity
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TileEntityBind {
	String name();
	Class<? extends TileEntity> tileentity();
}
