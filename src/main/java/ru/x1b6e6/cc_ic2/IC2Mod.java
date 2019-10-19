package ru.x1b6e6.cc_ic2;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import dan200.computercraft.api.ComputerCraftAPI;

import ru.x1b6e6.cc_ic2.impl.*;
import ru.x1b6e6.cc_ic2.impl.generator.*;
import ru.x1b6e6.cc_ic2.impl.heatgenerator.*;
import ru.x1b6e6.cc_ic2.impl.kineticgenerator.*;
import ru.x1b6e6.cc_ic2.impl.machine.*;
import ru.x1b6e6.cc_ic2.impl.reactor.*;
import ru.x1b6e6.cc_ic2.impl.storage.*;
import ru.x1b6e6.cc_ic2.impl.wiring.*;
import ru.x1b6e6.cc_ic2.item.*;

@Mod(name = IC2Mod.NAME, version = IC2Mod.VERSION, modid = IC2Mod.MODID)
public class IC2Mod {
	public static final String MODID = "cc_ic2";
	public static final String NAME = "CC with IC2";
	public static final String VERSION = "1.0";

	private static Logger log = LogManager.getLogger(MODID);
	Item[] items;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log.info("register items");
		items = new Item[] {
				// clang-format off

				new PrototypeHeatVent(), new PrototypeHeatVent2()
				// new PrototypeHeatExchanger()

				// clang-format on
		};
		// ItemRegistrator.register(new Class[] {PrototypeHeatVent.class,
		// PrototypeHeatVent2.class,
		// PrototypeHeatExchanger.class});
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		log.info("register peripherals");
		ComputerCraftAPI.registerPeripheralProvider(new PeripheralProvider(new Class[] {
				// clang-format off

				// base
				InvertoryImpl.class, HeatSourceImpl.class,

				// generator
				BaseGeneratorImpl.class, ConversionGeneratorImpl.class, GeneratorImpl.class, GeoGeneratorImpl.class,
				KineticGeneratorImpl.class,

				// heatgenerator
				ElectricHeatGeneratorImpl.class, FluidHeatGeneratorImpl.class, RTHeatGeneratorImpl.class,
				SolidHeatGeneratorImpl.class,

				// kineticgenerator
				ElectricKineticGeneratorImpl.class, SteamKineticGeneratorImpl.class, StirlingKineticGeneratorImpl.class,
				WaterKineticGeneratorImpl.class, WindKineticGeneratorImpl.class,

				// machine
				AssemblyBenchImpl.class, BatchCrafterImpl.class, ElectricMachineImpl.class,
				LiquidHeatExchangerImpl.class, StandardMachineImpl.class,

				// reactor
				ReactorImpl.class, ReactorVesselImpl.class, ReactorChamberImpl.class,

				// storage
				TankImpl.class, StorageBoxImpl.class,

				// wiring
				ElectricBlockImpl.class

				// clang-format on
		}));
	}

	public static void log_info(String msg) {
		log.info(msg);
	}

	public static void log_warn(String msg) {
		log.warn(msg);
	}

	public static void log_error(String msg) {
		log.error(msg);
	}
}
