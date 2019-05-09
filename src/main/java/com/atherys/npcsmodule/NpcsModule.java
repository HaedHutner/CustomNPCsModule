package com.atherys.npcsmodule;

import com.google.inject.Inject;
import noppes.npcs.api.NpcAPI;
import noppes.npcs.api.constants.EntityType;
import noppes.npcs.api.entity.ICustomNpc;
import org.slf4j.Logger;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Dependency;
import org.spongepowered.api.plugin.Plugin;

import java.util.Arrays;

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
    Logger logger;

    @Listener
    public void onStart(GameStartedServerEvent event) {
        Arrays.asList(NpcAPI.Instance().getIWorlds()).forEach(world -> {
            Arrays.asList(world.getAllEntities(EntityType.NPC)).forEach(entity -> {
                logger.info(((ICustomNpc) entity).getDisplay().getName());
            });
        });
    }
}
