package me.xenodev.tmbbl.events.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MusicMoveEvent implements Listener {

    public static Location locationupdate;

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        locationupdate = p.getLocation();
    }
}
