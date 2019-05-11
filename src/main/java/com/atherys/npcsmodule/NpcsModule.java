package com.atherys.npcsmodule;

import com.atherys.npcsmodule.script.NpcLibrary;
import com.atherys.script.js.JavaScriptLibrary;
import com.google.inject.Inject;
import noppes.npcs.api.IWorld;
import noppes.npcs.api.NpcAPI;
import noppes.npcs.api.constants.EntityType;
import noppes.npcs.api.entity.ICustomNpc;
import noppes.npcs.api.entity.IEntity;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

@Plugin(id = NpcsModule.ID,
        name = NpcsModule.NAME,
        description = NpcsModule.DESCRIPTION,
        version = NpcsModule.VERSION,
        dependencies = {
                @Dependency(id = "atheryscore"),
                @Dependency(id = "atherysscript"),
                @Dependency(id = "customnpcs")
        })
public class NpcsModule {
    static final String ID = "npcsmodule";
    static final String NAME = "CustomNPCs Module";
    static final String DESCRIPTION = "Custom NPCs scripting for AtherysScript";
    static final String VERSION = "0.0.1";

    @Inject
    private Logger logger;

    private CustomNpcRegistry registry;

    private static NpcsModule instance;

    @Listener
    public void onInit(GameInitializationEvent event) {
        JavaScriptLibrary.getInstance().extendWith(new NpcLibrary());
        instance = this;
        registry = CustomNpcRegistry.getInstance();
    }

    @Listener(order = Order.EARLY)
    public void onStart(GameStartedServerEvent event) {
        loadNpcs();
        NpcAPI.Instance().events().register(NpcListener.class);
    }

    @Listener
    public void onReload(GameReloadEvent event) {
        loadNpcs();
    }

    private void loadNpcs() {
        registry.clearAll();

        for (IWorld world : NpcAPI.Instance().getIWorlds()) {
            for (IEntity entity : world.getAllEntities(EntityType.NPC)) {
                ICustomNpc npc = (ICustomNpc) entity;
                registry.registerNpc(npc.getDisplay().getName(), npc);
            }
        }
    }

    public static CustomNpcRegistry getNpcRegistry() {
        return instance.registry;
    }

    public static Logger getLogger() {
        return instance.logger;
    }
}