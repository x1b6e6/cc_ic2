package ru.x1b6e6.cc_ic2.item;

import net.minecraft.item.ItemStack;

import ic2.api.reactor.IReactor;

public class PrototypeHeatVent extends Prototype {
	public static final int FROM_CORE = 144;
	public static final int HEAT_DOWN = 80;

	public PrototypeHeatVent() {
		super("prototype_heat_vent", 9000);
	}

	@Override
	public void processChamber(ItemStack stack, IReactor reactor, int x, int y, boolean heatrun) {
		if (heatrun) {
			int rheat = reactor.getHeat();
			int reactorDrain = rheat;
			if (reactorDrain > FROM_CORE)
				reactorDrain = FROM_CORE;
			rheat -= reactorDrain;
			if ((reactorDrain = alterHeat(stack, reactor, x, y, reactorDrain)) > 0)
				return;
			reactor.setHeat(rheat);
			int self = alterHeat(stack, reactor, x, y, -HEAT_DOWN);
			if (self <= 0)
				reactor.addEmitHeat(self + HEAT_DOWN);
		}
	}
}
