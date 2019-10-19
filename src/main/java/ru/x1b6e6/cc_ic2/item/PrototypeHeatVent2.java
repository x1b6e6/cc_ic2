package ru.x1b6e6.cc_ic2.item;

import ic2.api.reactor.IReactor;
import ic2.core.util.StackUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class PrototypeHeatVent2 extends Prototype {
	public static final int FROM_CORE = 144;
	public static final int HEAT_DOWN = 80;

	public PrototypeHeatVent2() {
		super("prototype_heat_vent_2", 9000);
	}

	@Override
	public void processChamber(ItemStack stack, IReactor reactor, int x, int y, boolean heatrun) {
		if (heatrun) {
			int rheat = reactor.getHeat();
			int from_core = (int) (FROM_CORE * getState(stack));
			int reactorDrain = rheat;
			if (reactorDrain > from_core)
				reactorDrain = from_core;
			rheat -= reactorDrain;
			if ((reactorDrain = alterHeat(stack, reactor, x, y, reactorDrain)) > 0)
				return;
			reactor.setHeat(rheat);
			int self = alterHeat(stack, reactor, x, y, -HEAT_DOWN);
			if (self <= 0)
				reactor.addEmitHeat(self + HEAT_DOWN);
		}
	}

	@Override
	public int alterHeat(ItemStack stack, IReactor reactor, int x, int y, int heat) {
		if (!reactor.isFluidCooled())
			return heat;
		int myHeat = getCurrentHeat(stack, reactor, x, y);

		myHeat += heat;

		if (myHeat > MAX_HEAT) {
			heat = MAX_HEAT - myHeat + 1;
			myHeat = MAX_HEAT;
		} else {
			if (myHeat < 0) {
				heat = myHeat;
				myHeat = 0;
			} else {
				heat = 0;
			}
		}

		setCustomDamage(stack, myHeat);

		return heat;
	}

	public void setState(ItemStack stack, double s) {
		NBTTagCompound nbt = StackUtil.getOrCreateNbtData(stack);
		if (s > 1.0D)
			s = 1.0D;
		if (s < 0.0D)
			s = 0.0D;
		nbt.setDouble("state", s);
	}

	public double getState(ItemStack stack) {
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey("state")) {
				return nbt.getDouble("state");
			}
		}

		return 0.5D;
	}
}
