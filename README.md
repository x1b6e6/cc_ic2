# ComputerCraft with IndustrialCraft2
This mod provide peripheral interface few IC2 mechanics
for using in Comuters from ComputerCraft mod, and add controlled reactor component `cc_ic2:prototype_heat_vent_2`.
## Realised mechanics:

### Reactor:
for using, place computer closly to reactor, reactor chamber or reactor vessel (pump, readstone or access hatch).
- `getOut` - return output of reactor and units (`Eu/t` in single mode and `H/t` in fluid mode).
- `getHeat` - return current heat and maximum heat
- `getFluidCold` - return name of cooling fluid, amount and capacity (only for fluid mode).
- `getFluidHot` - return name of hot cooler fluid, amount and capacity (only for fluid mode).
- `getFuelRemaining` - return least duration of uranium or MOX cells.
- `hasDepleted` - return true, if reactor have depleted cells.
- `isActive` - return true, if reactor is active.
- `getSizeInvertory` - return size invertory of reactor.
- `getStackInSlot` - return information about item in slot of reactor (name, count, durability, maximal damage).
- `getStatePrototype` - return current status (power) of prototype heat vent. if reactor have vents with different status, return average.
- `setStatePrototype` - write status to all prototype heat vents.

examples:
```lua
reactor = peripheral.wrap("<side-where-reactor>") -- see more in ComputerCraft Wiki

-- getting output:
out, out_units = reactor.getOut()

-- getting heat:
heat, max_heat = reactor.getHeat()
heat_in_percents = (heat * 100) / max_heat

-- getting status of prototype vents
status = reactor.getStatePrototype()
while status < 0.5 do
    reactor.setStatusPrototype(status + 0.1)
    status = reactor.getStatePrototype()
end

-- etc...
```
---
Writing readme in progress
