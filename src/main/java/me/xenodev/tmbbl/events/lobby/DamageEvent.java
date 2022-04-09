package me.xenodev.tmbbl.events.lobby;

import me.xenodev.tmbbl.file.LocationFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.player.StartItemBuilder;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageEvent implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFall(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(e.getEntity() instanceof Player){
            Player p = e.getEntity();
            if(LocationFilebuilder.cfg.getString("Spawn.World") != null){
                Location loc = LocationFilebuilder.getLocation("Spawn");
                p.teleport(loc);
                p.sendMessage(Main.prefix + "§7Du hast dich zum §6Spawn §7teleportiert");
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);
                p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 255));
                StartItemBuilder.setItem(p);
                p.spigot().respawn();
            }else{
                p.sendMessage(Main.error+ " §4§lDer Spawn wurde noch nicht gesetzt! Bitte den Spawn setzten mit /setup lobby");
            }
        }
    }

}
