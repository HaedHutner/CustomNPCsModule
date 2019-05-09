package com.atherys.npcsmodule.script;

import noppes.npcs.api.entity.ICustomNpc;

import java.util.UUID;
import java.util.function.Function;

public class GetNpcUUID implements Function<ICustomNpc, UUID> {
    @Override
    public UUID apply(ICustomNpc npc) {
        return npc.getMCEntity().getUniqueID();
    }
}
