package me.xenodev.tmbbl.events.lobby;

import me.xenodev.tmbbl.events.profil.gadget.pvpschwert.PvPSchwertEvent;
import me.xenodev.tmbbl.file.LocationFilebuilder;
import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.file.StatsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.player.StartItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.List;

public class DeathmatchEvent implements Listener {

    //if(PvPSchwertEvent.pvpschwert.contains(p)){
      //  for(Player all : Bukkit.getOnlinePlayers()){
        //    if(PvPSchwertEvent.pvpschwert.contains(all)){
          //      e.setCancelled(false);
            //}else{
              //  e.setCancelled(true);
           // }
        //}
    //}else{
      //  e.setCancelled(true);
    //}

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            if(p.getInventory().getItemInOffHand().getType().equals(Material.AIR)){
                for(Player all : PvPSchwertEvent.pvpschwert){
                    Player t = Bukkit.getPlayer(all.getName());
                    if(PvPSchwertEvent.pvpschwert.contains(p) && PvPSchwertEvent.pvpschwert.contains(t)){
                        e.setCancelled(false);
                    }else{
                        e.setCancelled(true);
                    }
                }
            }else{
                e.setCancelled(true);
            }
        }else{
            e.setCancelled(true);
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        Player k = p.getKiller();
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable() {
            @Override
            public void run() {
                if(p.isDead()){
                    PvPSchwertEvent.pvpschwert.remove(p);
                    p.spigot().respawn();
                    StartItemBuilder.setItem(p);
                    Location loc = LocationFilebuilder.getLocation("Spawn");
                    p.teleport(loc);
                    p.setMaxHealth(6);
                    p.setHealth(6);
                    StatsFilebuilder.addDeaths(p, 1);
                    StatsFilebuilder.resetStreak(p);
                }
            }
        }, 20 * 1);
        StatsFilebuilder.addKills(k, 1);
        StatsFilebuilder.addStreak(k, 1);
        PvPSchwertEvent.lookSchword(k);
        e.setDeathMessage("");
    }

}
