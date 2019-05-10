package com.atherys.npcsmodule.script;

import noppes.npcs.api.entity.ICustomNpc;

import java.util.UUID;
import java.util.function.Function;

/**
 * @jsfunc
 */
public class GetNpcUUID implements Function<ICustomNpc, UUID> {
    /**
     * Retrieve's an NPC's UUID.
     * @param npc The NPC to get the UUID for.
     * @return The NPC's UUID.
     */
    @Override
    public UUID apply(ICustomNpc npc) {
        return npc.getMCEntity().getUniqueID();
    }
}
