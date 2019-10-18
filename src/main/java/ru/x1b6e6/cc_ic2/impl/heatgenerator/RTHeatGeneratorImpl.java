package ru.x1b6e6.cc_ic2.impl.heatgenerator;

import ic2.core.block.heatgenerator.tileentity.TileEntityRTHeatGenerator;

import ru.x1b6e6.cc_ic2.annotation.*;
import ru.x1b6e6.cc_ic2.impl.HeatSourceImpl;

@TileEntityBind(name = "rt_heat_generator",
				tileentity = TileEntityRTHeatGenerator.class)
public class RTHeatGeneratorImpl extends HeatSourceImpl {}
