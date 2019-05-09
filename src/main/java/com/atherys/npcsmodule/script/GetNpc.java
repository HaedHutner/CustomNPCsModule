package com.atherys.npcsmodule.script;

import com.atherys.npcsmodule.NpcsModule;
import noppes.npcs.api.entity.ICustomNpc;

import java.util.function.Function;

public class GetNpc implements Function<String, ICustomNpc> {
    @Override
    public ICustomNpc apply(String name) {
        return NpcsModule.getNpcRegistry().getNpc(name).orElse(null);
    }
}
