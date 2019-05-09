package com.atherys.npcsmodule;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import noppes.npcs.api.event.NpcEvent;

public class NpcListener {
    @SubscribeEvent
    public void onNpcUpdate(NpcEvent.UpdateEvent event) {
        NpcsModule.getLogger().info("Updating NPC: {}", event.npc.getDisplay().getName());
        NpcsModule.getNpcRegistry().registerNpc(event.npc.getDisplay().getName(), event.npc);
    }
}
