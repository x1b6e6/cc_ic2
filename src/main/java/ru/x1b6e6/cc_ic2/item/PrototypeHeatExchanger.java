package ru.x1b6e6.cc_ic2.item;

import net.minecraft.item.ItemStack;

import ic2.api.reactor.IReactor;

public class PrototypeHeatExchanger extends Prototype {
	public static final String NAME = "prototype_heat_exchanger";
	public static final int MAX_HEAT = 10000;
	public static final int FROM_CORE = 0;
	public static final int HEAT_DOWN = 0;
	public static final int EXCHANGE = 64;

	public PrototypeHeatExchanger() { super(NAME, MAX_HEAT); }

	@Override
	public void processChamber(ItemStack stack, IReactor reactor, int x, int y,
							   boolean heatrun) {}
}
