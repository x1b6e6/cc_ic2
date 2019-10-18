package ru.x1b6e6.cc_ic2.impl.machine;

import ic2.core.block.machine.tileentity.TileEntityAssemblyBench;

import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;

@TileEntityBind(name = "assembly_bench",
				tileentity = TileEntityAssemblyBench.class)
public class AssemblyBenchImpl extends BatchCrafterImpl {}
