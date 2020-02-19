package ru.x1b6e6.cc_ic2.impl.machine;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.peripheral.IComputerAccess;
import ic2.core.block.machine.tileentity.TileEntityMatter;
import ru.x1b6e6.cc_ic2.annotation.PeripheralFunc;
import ru.x1b6e6.cc_ic2.annotation.TileEntityBind;
import ru.x1b6e6.cc_ic2.util.Utils;

@TileEntityBind(name = "matter", tileentity = TileEntityMatter.class)
public class MatterImpl extends ElectricMachineImpl {
    @PeripheralFunc
    public static Object[] getOut(TileEntityMatter te, IComputerAccess computer, ILuaContext context,
            Object[] args) {
        return Utils.getFluidInfo(te.fluidTank);
    }

    @PeripheralFunc
    public static Object[] getAmplifierItem(TileEntityMatter te, IComputerAccess computer, ILuaContext context,
            Object[] args){
        return Utils.getItemInfo(te.amplifierSlot.get());
    }

    @PeripheralFunc
    public static Object[] getAmplifier(TileEntityMatter te, IComputerAccess computer, ILuaContext context,
            Object[] args) {
        return Utils.toArray(te.scrap);
    }
}
