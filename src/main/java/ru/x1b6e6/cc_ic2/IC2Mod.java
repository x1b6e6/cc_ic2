package ru.x1b6e6.cc_ic2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dan200.computercraft.api.ComputerCraftAPI;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import ru.x1b6e6.cc_ic2.impl.HeatSourceImpl;
import ru.x1b6e6.cc_ic2.impl.InvertoryImpl;
import ru.x1b6e6.cc_ic2.impl.generator.BaseGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.generator.ConversionGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.generator.GeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.generator.GeoGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.generator.KineticGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.heatgenerator.ElectricHeatGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.heatgenerator.FluidHeatGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.heatgenerator.RTHeatGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.heatgenerator.SolidHeatGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.kineticgenerator.ElectricKineticGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.kineticgenerator.SteamKineticGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.kineticgenerator.StirlingKineticGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.kineticgenerator.WaterKineticGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.kineticgenerator.WindKineticGeneratorImpl;
import ru.x1b6e6.cc_ic2.impl.machine.AssemblyBenchImpl;
import ru.x1b6e6.cc_ic2.impl.machine.BatchCrafterImpl;
import ru.x1b6e6.cc_ic2.impl.machine.ElectricMachineImpl;
import ru.x1b6e6.cc_ic2.impl.machine.LiquidHeatExchangerImpl;
import ru.x1b6e6.cc_ic2.impl.machine.MatterImpl;
import ru.x1b6e6.cc_ic2.impl.machine.StandardMachineImpl;
import ru.x1b6e6.cc_ic2.impl.reactor.ReactorChamberImpl;
import ru.x1b6e6.cc_ic2.impl.reactor.ReactorImpl;
import ru.x1b6e6.cc_ic2.impl.reactor.ReactorVesselImpl;
import ru.x1b6e6.cc_ic2.impl.storage.StorageBoxImpl;
import ru.x1b6e6.cc_ic2.impl.storage.TankImpl;
import ru.x1b6e6.cc_ic2.impl.wiring.ElectricBlockImpl;
import ru.x1b6e6.cc_ic2.item.PrototypeHeatVent;
import ru.x1b6e6.cc_ic2.item.PrototypeHeatVent2;

@Mod(name = IC2Mod.NAME, version = IC2Mod.VERSION, modid = IC2Mod.MODID,
	 dependencies = "required-after:computercraft;required-after:ic2")
public class IC2Mod {
	public static final String MODID = "cc_ic2";
	public static final String NAME = "ComputerCraft with IndustrialCraft2";
	public static final String VERSION = "1.0";

	private static Logger log = LogManager.getLogger(MODID);
	Item[] items;

	public static final Class<?>[] impls_classes = new Class<?>[] {
		// clang-format off

			// base
			InvertoryImpl.class,
			HeatSourceImpl.class,

			// generator
			BaseGeneratorImpl.class,
			ConversionGeneratorImpl.class,
			GeneratorImpl.class,
			GeoGeneratorImpl.class,
			KineticGeneratorImpl.class,

			// heatgenerator
			ElectricHeatGeneratorImpl.class,
			FluidHeatGeneratorImpl.class,
			RTHeatGeneratorImpl.class,
			SolidHeatGeneratorImpl.class,

			// kineticgenerator
			ElectricKineticGeneratorImpl.class,
			SteamKineticGeneratorImpl.class,
			StirlingKineticGeneratorImpl.class,
			WaterKineticGeneratorImpl.class,
			WindKineticGeneratorImpl.class,

			// machine
			AssemblyBenchImpl.class,
			BatchCrafterImpl.class,
			ElectricMachineImpl.class,
			LiquidHeatExchangerImpl.class,
			MatterImpl.class,
			StandardMachineImpl.class,

			// reactor
			ReactorImpl.class,
			ReactorVesselImpl.class,
			ReactorChamberImpl.class,

			// storage
			TankImpl.class,
			StorageBoxImpl.class,

			// wiring
			ElectricBlockImpl.class

		// clang-format on
	};
	public static final Class<?>[] items_classes =
		new Class<?>[] {PrototypeHeatVent.class, PrototypeHeatVent2.class};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		log.info("registering items");
		for (Class<?> item_cls : items_classes) {
			try {
				Object obj = item_cls.newInstance();

				Item item = Item.class.cast(obj);

				ForgeRegistries.ITEMS.register(item);
				ModelLoader.setCustomModelResourceLocation(
					item, 0,
					new ModelResourceLocation(item.getRegistryName(),
											  "invertory"));
			} catch (Exception e) {
				String error_msg = "";
				if (IllegalAccessException.class.isInstance(e)) {
					error_msg +=
						IllegalAccessException.class.cast(e).getMessage();
				}
				if (InstantiationException.class.isInstance(e)) {
					error_msg +=
						InstantiationException.class.cast(e).getMessage();
				}
				log.error("cant register item (", item_cls.getName(),
						  "): ", error_msg);
			}
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		log.info("register peripherals");
		ComputerCraftAPI.registerPeripheralProvider(
			new PeripheralProvider(impls_classes));
	}

	public static void log_info(String... msg) { log.info(msg); }

	public static void log_warn(String... msg) { log.warn(msg); }

	public static void log_error(String... msg) { log.error(msg); }
}
