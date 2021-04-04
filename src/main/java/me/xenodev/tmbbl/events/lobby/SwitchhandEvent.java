package me.xenodev.tmbbl.events.lobby;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class SwitchhandEvent implements Listener {

    @EventHandler
    public void onSwitch(PlayerSwapHandItemsEvent e){
        e.setCancelled(true);
    }
}
