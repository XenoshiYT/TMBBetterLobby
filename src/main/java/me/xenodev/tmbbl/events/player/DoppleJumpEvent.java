package me.xenodev.tmbbl.events.player;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import java.util.HashMap;

public class DoppleJumpEvent implements Listener {

    private HashMap<Player, Boolean> cooldown = new HashMap<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(false)) return;

        p.setAllowFlight(true);
        cooldown.put(p, false);
    }

    @EventHandler
    public void onFly(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();

        if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(false)) return;

        if(p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE)){
            e.setCancelled(true);
            if(cooldown.get(p))return;
            p.setVelocity(p.getLocation().getDirection().setY(1));
            p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 100, 100);
            cooldown.put(p, true);
            p.setAllowFlight(false);
        }else{
            cooldown.put(p, true);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(false)) return;

        if(p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE)) {
            if (p.isOnGround()) {
                cooldown.put(p, false);
                p.setAllowFlight(true);
            }
        }else{
            cooldown.put(p, true);
        }
    }

    @EventHandler
    public void changeGamemode(PlayerGameModeChangeEvent e){
        Player p = e.getPlayer();

        if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(false)) return;

        if(p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.ADVENTURE)){
            p.setAllowFlight(true);
            cooldown.put(p, false);
        }else{
            cooldown.put(p, true);
        }
    }

}
