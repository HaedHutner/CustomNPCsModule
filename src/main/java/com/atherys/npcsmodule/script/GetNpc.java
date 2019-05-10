package com.atherys.npcsmodule.script;

import com.atherys.npcsmodule.NpcsModule;
import noppes.npcs.api.entity.ICustomNpc;

import java.util.function.Function;

/**
 * @jsfunc
 */
public class GetNpc implements Function<String, ICustomNpc> {
    /**
     * Retrieves a CustomNPC from a name.
     * @param name The name of the NPC.
     * @return An `ICustomNpc` object.
     */
    @Override
    public ICustomNpc apply(String name) {
        return NpcsModule.getNpcRegistry().getNpc(name).orElse(null);
    }
}
