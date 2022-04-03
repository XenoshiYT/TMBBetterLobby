package me.xenodev.tmbbl.events.profil.gadget.specialevents.easter;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class EggBombEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(p.getInventory().getItemInHand().getType().equals(Material.EGG)) {
            if (p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9Eggbomb §7«")) {
                e.setCancelled(true);

                p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());

                p.launchProjectile(Egg.class);
                p.playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1f, 1f);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        p.getInventory().setItem(6, new ItemBuilder(Material.EGG).setName("§7» §9Eggbomb §7«").setLore("§5EasterEgg-Gadget von Ostern 2021").build());
                    }
                }.runTaskLater(Main.instance, 20 * 3);
            }
        }
    }

    @EventHandler
    public void onThrow(ProjectileHitEvent e){
        if(e.getEntity().getShooter() instanceof Player){
            Player p = (Player) e.getEntity();
            if(e.getEntity() instanceof Egg){
                Egg egg = (Egg) e.getEntity();
                for(Entity entity : egg.getNearbyEntities(5D, 5D, 5D)){
                    Player all = (Player) entity;
                    all.playSound(egg.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
                    all.playEffect(egg.getLocation(), Effect.EXTINGUISH, 100);
                    if(all.getLocation().distance(egg.getLocation()) <= 5){
                        if (SettingsFilebuilder.getSetting(all, "Eggboost_other").equals(true)) {
                            if(SettingsFilebuilder.getSetting(p, "Eggboost_self").equals(true)) {
                                Vector v = all.getVelocity();
                                v.setX(all.getLocation().getDirection().multiply(4).getX());
                                v.setY(2);
                                v.setZ(all.getLocation().getDirection().multiply(4).getZ());
                                all.setVelocity(v);
                            }else{
                                if(all != p) {
                                    Vector v = all.getVelocity();
                                    v.setX(all.getLocation().getDirection().multiply(4).getX());
                                    v.setY(2);
                                    v.setZ(all.getLocation().getDirection().multiply(4).getZ());
                                    all.setVelocity(v);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e){
        if(e.getEntity() instanceof Chicken){
            e.setCancelled(true);
        }
    }
}
