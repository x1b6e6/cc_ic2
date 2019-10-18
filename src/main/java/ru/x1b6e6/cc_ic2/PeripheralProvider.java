package ru.x1b6e6.cc_ic2;

import java.util.ArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;

public class PeripheralProvider implements IPeripheralProvider {
	private Class<?>[] all_impls;

	public PeripheralProvider(Class<?>[] impls) {
		this.all_impls = impls;

	}

	@Nullable
	@Override
	public IPeripheral getPeripheral(@Nonnull World world, @Nonnull BlockPos blockPos, @Nonnull EnumFacing enumFacing) {
		TileEntity te = world.getTileEntity(blockPos);
		if (te != null) {
			ArrayList<Class<?>> support_impls = new ArrayList<>();
			for (Class<?> impl : all_impls) {
				Class<? extends TileEntity> cl = impl.getAnnotation(TileEntityBind.class).tileentity();
				if (cl.isInstance(te)) {
					support_impls.add(impl);
				}
			}
			if (support_impls.size() > 0)
				return new Peripheral(te, support_impls.toArray(new Class<?>[support_impls.size()]));
		}
		return null;
	}
}
