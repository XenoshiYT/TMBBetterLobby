package me.xenodev.tmbbl.events.profil.trail.note;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class NoteEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(SettingsFilebuilder.getArmor(p, "Spur", "Note").equals(true)){
            if(SettingsFilebuilder.getSetting(p, "Hide").equals(false)) {
                if (p.getGameMode().equals(GameMode.ADVENTURE) || p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.CREATIVE)) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        Location loc = p.getLocation().add(0, 0.5, 0);
                        Object packet = Main.particles.NOTE().packet(true, loc);
                        Main.particles.sendPacket(all, packet);
                    }
                } else {
                    Location loc = p.getLocation().add(0, 0.5, 0);
                    Object packet = Main.particles.NOTE().packet(true, loc);
                    Main.particles.sendPacket(p, packet);
                }
            }else{
                Location loc = p.getLocation().add(0, 0.5, 0);
                Object packet = Main.particles.NOTE().packet(true, loc);
                Main.particles.sendPacket(p, packet);
            }
        }
    }
}
