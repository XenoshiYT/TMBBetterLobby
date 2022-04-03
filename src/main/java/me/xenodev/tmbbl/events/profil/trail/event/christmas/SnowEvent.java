package me.xenodev.tmbbl.events.profil.trail.event.christmas;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Snow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class SnowEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (SettingsFilebuilder.getArmor(p, "Spur", "Snow").equals(true)) {
            if (SettingsFilebuilder.getSetting(p, "Hide").equals(false)) {
                if (p.getGameMode().equals(GameMode.ADVENTURE) || p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.CREATIVE)) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (SettingsFilebuilder.getSetting(all, "Hide").equals(true)) {
                            Location loc = p.getLocation().add(0, 0.5, 0);
                            Object packet = Main.particles_1_13.FIREWORK().packet(true, loc);
                            Main.particles_1_13.sendPacket(p, packet);
                        } else {
                            Location loc = p.getLocation().add(0, 0.5, 0);
                            Object packet = Main.particles_1_13.FIREWORK().packet(true, loc);
                            Main.particles_1_13.sendPacket(all, packet);
                        }
                    }
                } else {
                    Location loc = p.getLocation().add(0, 0.5, 0);
                    Object packet = Main.particles_1_13.FIREWORK().packet(true, loc);
                    Main.particles_1_13.sendPacket(p, packet);
                }
            } else {
                Location loc = p.getLocation().add(0, 0.5, 0);
                Object packet = Main.particles_1_13.FIREWORK().packet(true, loc);
                Main.particles_1_13.sendPacket(p, packet);
            }
        }
    }
}
