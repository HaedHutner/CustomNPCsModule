package com.atherys.npcsmodule;

import noppes.npcs.api.entity.ICustomNpc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CustomNpcRegistry {
    private Map<String, ICustomNpc> npcs = new HashMap<>();

    private static CustomNpcRegistry instance = new CustomNpcRegistry();

    private CustomNpcRegistry() {
    }

    public static CustomNpcRegistry getInstance() {
        return instance;
    }

    public void registerNpc(String name, ICustomNpc npc) {
         npcs.put(name, npc);
    }

    public Optional<ICustomNpc> getNpc(String name) {
        return Optional.ofNullable(npcs.get(name));
    }
}
