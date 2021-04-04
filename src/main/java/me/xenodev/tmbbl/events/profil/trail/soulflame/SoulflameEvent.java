package me.xenodev.tmbbl.events.profil.trail.soulflame;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class SoulflameEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(SettingsFilebuilder.getArmor(p, "Spur", "Soulflame").equals(true)){
            if(SettingsFilebuilder.getSetting(p, "Hide").equals(false)) {
                if (p.getGameMode().equals(GameMode.ADVENTURE) || p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.CREATIVE)) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        Location loc = p.getLocation().add(0, 0.5, 0);
                        Object packet = Main.particles.SOUL_FIRE_FLAME().packet(true, loc);
                        Main.particles.sendPacket(all, packet);
                    }
                } else {
                    Location loc = p.getLocation().add(0, 0.5, 0);
                    Object packet = Main.particles.SOUL_FIRE_FLAME().packet(true, loc);
                    Main.particles.sendPacket(p, packet);
                }
            }else{
                Location loc = p.getLocation().add(0, 0.5, 0);
                Object packet = Main.particles.SOUL_FIRE_FLAME().packet(true, loc);
                Main.particles.sendPacket(p, packet);
            }
        }
    }
}
