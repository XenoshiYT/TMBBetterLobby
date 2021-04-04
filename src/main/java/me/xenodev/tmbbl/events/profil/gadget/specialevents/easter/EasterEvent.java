package me.xenodev.tmbbl.events.profil.gadget.specialevents.easter;

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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Random;

public class EasterEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9Eggbomb §7«")){
            //Cooldown 5s
            p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());

            p.launchProjectile(Egg.class);
            Main.instance.getServer().getWorld("world").playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1f, 1f);

            new BukkitRunnable() {
                @Override
                public void run() {
                    p.getInventory().setItem(6, new ItemBuilder(Material.EGG).setName("§7» §9Eggbomb §7«").setLore("§5EasterEgg-Gadget von Ostern 2021").build());
                }
            }.runTaskLater(Main.instance, 20 * 3);
        }
    }

    @EventHandler
    public void onThrow(ProjectileHitEvent e){
        Projectile proj = e.getEntity();
        for(Entity target : proj.getNearbyEntities(6, 6, 6)){
            Location loc = e.getHitBlock().getLocation();
            if(proj instanceof Egg){
                if(target instanceof Player){
                    Player t = (Player)target;

                    Vector v = t.getVelocity();
                    v.setX(t.getLocation().getDirection().multiply(4).getX());
                    v.setY(2);
                    v.setZ(t.getLocation().getDirection().multiply(4).getZ());
                    t.setVelocity(v);
                    Main.instance.getServer().getWorld("world").playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
                    Main.instance.getServer().getWorld("world").createExplosion(loc.getX(), loc.getY(), loc.getZ(), 3, false, false);
                }
            }
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        if(e.getEntity() instanceof Chicken){
            Chicken chicken = (Chicken) e.getEntity();
            chicken.setHealth(0);
        }
    }
}
