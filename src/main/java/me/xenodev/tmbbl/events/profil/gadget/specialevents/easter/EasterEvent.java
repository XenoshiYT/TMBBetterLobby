package me.xenodev.tmbbl.events.profil.gadget.specialevents.easter;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class EasterEvent implements Listener {

    @EventHandler
    public void onInteract(ProjectileLaunchEvent e) {
        Projectile proj = e.getEntity();
        Player p = (Player) proj.getShooter();
        if(proj instanceof Egg) {
            //Cooldown 5s
            p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());

            Main.instance.getServer().getWorld("world").playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1f, 1f);

            new BukkitRunnable() {
                @Override
                public void run() {
                    p.getInventory().setItem(6, new ItemBuilder(Material.EGG).setName("§7» §9Farbbombe §7«").setLore("§5EasterEgg-Gadget von Ostern 2021").build());
                }
            }.runTaskLater(Main.instance, 20 * 5);
        }
    }

    @EventHandler
    public void onThrow(ProjectileHitEvent e){
        Entity entity = e.getEntity();
        Block block = e.getHitBlock();
        Chunk chunks = block.getChunk();
        Location location = block.getLocation();

        if(entity instanceof Egg){
            if(!block.getType().equals(Material.LIGHT_BLUE_CONCRETE) || !block.getType().equals(Material.LIME_CONCRETE) || !block.getType().equals(Material.RED_CONCRETE)) {
                Random random = new Random();
                Integer i = random.nextInt(4);
                Bukkit.broadcastMessage(" " + i);
                getPattern(i, block, chunks);
            }
            Main.instance.getServer().getWorld("world").playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 10f, 10f);
        }
    }

    @EventHandler
    public void onSpawn(EntitySpawnEvent e){
        if(e.getEntity() instanceof Chicken){
            Chicken chicken = (Chicken) e.getEntity();
            chicken.setHealth(0);
        }
    }


    private static void getPattern(Integer number, Block block, Chunk chunk){
        if(number == 0){
            Location loc1 = block.getLocation();
            Location loc2 = block.getLocation();
            Location loc3 = block.getLocation();
            Location loc4 = block.getLocation();
            Location loc5 = block.getLocation();

            Material oldmaterial1 = loc1.getBlock().getType();
            Material oldmaterial2 = loc2.add(0,0, -1).getBlock().getType();
            Material oldmaterial3 = loc3.add(-1,0, -1).getBlock().getType();
            Material oldmaterial4 = loc4.add(-1,0, +1).getBlock().getType();
            Material oldmaterial5 = loc5.add(+1,0, +1).getBlock().getType();
            if(oldmaterial1 != Material.RED_CONCRETE || oldmaterial1 != Material.LIME_CONCRETE || oldmaterial1 != Material.LIGHT_BLUE_CONCRETE || oldmaterial1 != Material.WHITE_CONCRETE || oldmaterial1 != Material.YELLOW_CONCRETE || oldmaterial1 != Material.MAGENTA_CONCRETE)
                if(oldmaterial2 != Material.RED_CONCRETE || oldmaterial2 != Material.LIME_CONCRETE || oldmaterial2 != Material.LIGHT_BLUE_CONCRETE || oldmaterial2 != Material.WHITE_CONCRETE || oldmaterial2 != Material.YELLOW_CONCRETE || oldmaterial2 != Material.MAGENTA_CONCRETE)
                    if(oldmaterial3 != Material.RED_CONCRETE || oldmaterial3 != Material.LIME_CONCRETE || oldmaterial3 != Material.LIGHT_BLUE_CONCRETE || oldmaterial3 != Material.WHITE_CONCRETE || oldmaterial3 != Material.YELLOW_CONCRETE || oldmaterial3 != Material.MAGENTA_CONCRETE)
                        if(oldmaterial4 != Material.RED_CONCRETE || oldmaterial4 != Material.LIME_CONCRETE || oldmaterial4 != Material.LIGHT_BLUE_CONCRETE || oldmaterial4 != Material.WHITE_CONCRETE || oldmaterial4 != Material.YELLOW_CONCRETE || oldmaterial4 != Material.MAGENTA_CONCRETE)
                            if(oldmaterial5 != Material.RED_CONCRETE || oldmaterial5 != Material.LIME_CONCRETE || oldmaterial5 != Material.LIGHT_BLUE_CONCRETE || oldmaterial5 != Material.WHITE_CONCRETE || oldmaterial5 != Material.YELLOW_CONCRETE || oldmaterial5 != Material.MAGENTA_CONCRETE)
            loc1.getBlock().setType(Material.YELLOW_CONCRETE);
            loc2.add(0,0, -1).getBlock().setType(Material.RED_CONCRETE);
            loc3.add(-1,0, -1).getBlock().setType(Material.LIME_CONCRETE);
            loc4.add(-1,0, +1).getBlock().setType(Material.WHITE_CONCRETE);
            loc5.add(+1,0, +1).getBlock().setType(Material.LIGHT_BLUE_CONCRETE);

            Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                @Override
                public void run() {
                    loc1.getBlock().setType(oldmaterial1);
                    loc2.add(0,0, -1).getBlock().setType(oldmaterial2);
                    loc3.add(-1,0, -1).getBlock().setType(oldmaterial3);
                    loc4.add(-1,0, +1).getBlock().setType(oldmaterial4);
                    loc5.add(+1,0, +1).getBlock().setType(oldmaterial5);
                }
            }, 20*3);
        }else if(number == 1){
            Location loc1 = block.getLocation();
            Location loc2 = block.getLocation();
            Location loc3 = block.getLocation();
            Location loc4 = block.getLocation();
            Location loc5 = block.getLocation();
            Location loc6 = block.getLocation();

            Material oldmaterial1 = loc1.getBlock().getType();
            Material oldmaterial2 = loc2.add(-1, 0, 0).getBlock().getType();
            Material oldmaterial3 = loc3.add(-1, 0, +1).getBlock().getType();
            Material oldmaterial4 = loc4.add(0, 0, +1).getBlock().getType();
            Material oldmaterial5 = loc5.add(+1, 0, +1).getBlock().getType();
            Material oldmaterial6 = loc6.add(+1, 0, -1).getBlock().getType();
            if(oldmaterial1 != Material.RED_CONCRETE || oldmaterial1 != Material.LIME_CONCRETE || oldmaterial1 != Material.LIGHT_BLUE_CONCRETE || oldmaterial1 != Material.WHITE_CONCRETE || oldmaterial1 != Material.YELLOW_CONCRETE || oldmaterial1 != Material.MAGENTA_CONCRETE)
                if(oldmaterial2 != Material.RED_CONCRETE || oldmaterial2 != Material.LIME_CONCRETE || oldmaterial2 != Material.LIGHT_BLUE_CONCRETE || oldmaterial2 != Material.WHITE_CONCRETE || oldmaterial2 != Material.YELLOW_CONCRETE || oldmaterial2 != Material.MAGENTA_CONCRETE)
                    if(oldmaterial3 != Material.RED_CONCRETE || oldmaterial3 != Material.LIME_CONCRETE || oldmaterial3 != Material.LIGHT_BLUE_CONCRETE || oldmaterial3 != Material.WHITE_CONCRETE || oldmaterial3 != Material.YELLOW_CONCRETE || oldmaterial3 != Material.MAGENTA_CONCRETE)
                        if(oldmaterial4 != Material.RED_CONCRETE || oldmaterial4 != Material.LIME_CONCRETE || oldmaterial4 != Material.LIGHT_BLUE_CONCRETE || oldmaterial4 != Material.WHITE_CONCRETE || oldmaterial4 != Material.YELLOW_CONCRETE || oldmaterial4 != Material.MAGENTA_CONCRETE)
                            if(oldmaterial5 != Material.RED_CONCRETE || oldmaterial5 != Material.LIME_CONCRETE || oldmaterial5 != Material.LIGHT_BLUE_CONCRETE || oldmaterial5 != Material.WHITE_CONCRETE || oldmaterial5 != Material.YELLOW_CONCRETE || oldmaterial5 != Material.MAGENTA_CONCRETE)
                                if(oldmaterial6 != Material.RED_CONCRETE || oldmaterial6 != Material.LIME_CONCRETE || oldmaterial6 != Material.LIGHT_BLUE_CONCRETE || oldmaterial6 != Material.WHITE_CONCRETE || oldmaterial6 != Material.YELLOW_CONCRETE || oldmaterial6 != Material.MAGENTA_CONCRETE)
            loc1.getBlock().setType(Material.YELLOW_CONCRETE);
            loc2.add(-1, 0, 0).getBlock().setType(Material.RED_CONCRETE);
            loc3.add(-1, 0, +1).getBlock().setType(Material.LIME_CONCRETE);
            loc4.add(0, 0, +1).getBlock().setType(Material.WHITE_CONCRETE);
            loc5.add(+1, 0, +1).getBlock().setType(Material.LIGHT_BLUE_CONCRETE);
            loc6.add(+1, 0, -1).getBlock().setType(Material.MAGENTA_CONCRETE);
        }else if(number == 2){
            Location loc1 = block.getLocation();
            Location loc2 = block.getLocation();
            Location loc3 = block.getLocation();
            Location loc4 = block.getLocation();
            Location loc5 = block.getLocation();
            Location loc6 = block.getLocation();

            Material oldmaterial1 = loc1.getBlock().getType();
            Material oldmaterial2 = loc2.add(-1, 0, 0).getBlock().getType();
            Material oldmaterial3 = loc3.add(-1, 0, +1).getBlock().getType();
            Material oldmaterial4 = loc4.add(+1, 0, +1).getBlock().getType();
            Material oldmaterial5 = loc5.add(+1, 0, 0).getBlock().getType();
            Material oldmaterial6 = loc6.add(+1, 0, -1).getBlock().getType();
            if(oldmaterial1 != Material.RED_CONCRETE || oldmaterial1 != Material.LIME_CONCRETE || oldmaterial1 != Material.LIGHT_BLUE_CONCRETE || oldmaterial1 != Material.WHITE_CONCRETE || oldmaterial1 != Material.YELLOW_CONCRETE || oldmaterial1 != Material.MAGENTA_CONCRETE)
                if(oldmaterial2 != Material.RED_CONCRETE || oldmaterial2 != Material.LIME_CONCRETE || oldmaterial2 != Material.LIGHT_BLUE_CONCRETE || oldmaterial2 != Material.WHITE_CONCRETE || oldmaterial2 != Material.YELLOW_CONCRETE || oldmaterial2 != Material.MAGENTA_CONCRETE)
                    if(oldmaterial3 != Material.RED_CONCRETE || oldmaterial3 != Material.LIME_CONCRETE || oldmaterial3 != Material.LIGHT_BLUE_CONCRETE || oldmaterial3 != Material.WHITE_CONCRETE || oldmaterial3 != Material.YELLOW_CONCRETE || oldmaterial3 != Material.MAGENTA_CONCRETE)
                        if(oldmaterial4 != Material.RED_CONCRETE || oldmaterial4 != Material.LIME_CONCRETE || oldmaterial4 != Material.LIGHT_BLUE_CONCRETE || oldmaterial4 != Material.WHITE_CONCRETE || oldmaterial4 != Material.YELLOW_CONCRETE || oldmaterial4 != Material.MAGENTA_CONCRETE)
                            if(oldmaterial5 != Material.RED_CONCRETE || oldmaterial5 != Material.LIME_CONCRETE || oldmaterial5 != Material.LIGHT_BLUE_CONCRETE || oldmaterial5 != Material.WHITE_CONCRETE || oldmaterial5 != Material.YELLOW_CONCRETE || oldmaterial5 != Material.MAGENTA_CONCRETE)
                                if(oldmaterial6 != Material.RED_CONCRETE || oldmaterial6 != Material.LIME_CONCRETE || oldmaterial6 != Material.LIGHT_BLUE_CONCRETE || oldmaterial6 != Material.WHITE_CONCRETE || oldmaterial6 != Material.YELLOW_CONCRETE || oldmaterial6 != Material.MAGENTA_CONCRETE)
            loc1.getBlock().setType(Material.YELLOW_CONCRETE);
            loc2.add(-1, 0, 0).getBlock().setType(Material.RED_CONCRETE);
            loc3.add(-1, 0, +1).getBlock().setType(Material.LIME_CONCRETE);
            loc4.add(+1, 0, +1).getBlock().setType(Material.WHITE_CONCRETE);
            loc5.add(+1, 0, 0).getBlock().setType(Material.LIGHT_BLUE_CONCRETE);
            loc6.add(+1, 0, -1).getBlock().setType(Material.MAGENTA_CONCRETE);
        }else if(number == 3){
            Location loc1 = block.getLocation();
            Location loc2 = block.getLocation();
            Location loc3 = block.getLocation();
            Location loc4 = block.getLocation();
            Location loc5 = block.getLocation();
            Location loc6 = block.getLocation();

            Material oldmaterial1 = loc1.getBlock().getType();
            Material oldmaterial2 = loc2.add(0, 0, -1).getBlock().getType();
            Material oldmaterial3 = loc3.add(-1, 0, -1).getBlock().getType();
            Material oldmaterial4 = loc4.add(-1, 0, +1).getBlock().getType();
            Material oldmaterial5 = loc5.add(+1, 0, +1).getBlock().getType();
            Material oldmaterial6 = loc6.add(+1, 0, 0).getBlock().getType();
            if(oldmaterial1 != Material.RED_CONCRETE || oldmaterial1 != Material.LIME_CONCRETE || oldmaterial1 != Material.LIGHT_BLUE_CONCRETE || oldmaterial1 != Material.WHITE_CONCRETE || oldmaterial1 != Material.YELLOW_CONCRETE || oldmaterial1 != Material.MAGENTA_CONCRETE)
                if(oldmaterial2 != Material.RED_CONCRETE || oldmaterial2 != Material.LIME_CONCRETE || oldmaterial2 != Material.LIGHT_BLUE_CONCRETE || oldmaterial2 != Material.WHITE_CONCRETE || oldmaterial2 != Material.YELLOW_CONCRETE || oldmaterial2 != Material.MAGENTA_CONCRETE)
                    if(oldmaterial3 != Material.RED_CONCRETE || oldmaterial3 != Material.LIME_CONCRETE || oldmaterial3 != Material.LIGHT_BLUE_CONCRETE || oldmaterial3 != Material.WHITE_CONCRETE || oldmaterial3 != Material.YELLOW_CONCRETE || oldmaterial3 != Material.MAGENTA_CONCRETE)
                        if(oldmaterial4 != Material.RED_CONCRETE || oldmaterial4 != Material.LIME_CONCRETE || oldmaterial4 != Material.LIGHT_BLUE_CONCRETE || oldmaterial4 != Material.WHITE_CONCRETE || oldmaterial4 != Material.YELLOW_CONCRETE || oldmaterial4 != Material.MAGENTA_CONCRETE)
                            if(oldmaterial5 != Material.RED_CONCRETE || oldmaterial5 != Material.LIME_CONCRETE || oldmaterial5 != Material.LIGHT_BLUE_CONCRETE || oldmaterial5 != Material.WHITE_CONCRETE || oldmaterial5 != Material.YELLOW_CONCRETE || oldmaterial5 != Material.MAGENTA_CONCRETE)
                                if(oldmaterial6 != Material.RED_CONCRETE || oldmaterial6 != Material.LIME_CONCRETE || oldmaterial6 != Material.LIGHT_BLUE_CONCRETE || oldmaterial6 != Material.WHITE_CONCRETE || oldmaterial6 != Material.YELLOW_CONCRETE || oldmaterial6 != Material.MAGENTA_CONCRETE)
            loc1.getBlock().setType(Material.YELLOW_CONCRETE);
            loc2.add(0, 0, -1).getBlock().setType(Material.RED_CONCRETE);
            loc3.add(-1, 0, -1).getBlock().setType(Material.LIME_CONCRETE);
            loc4.add(-1, 0, +1).getBlock().setType(Material.WHITE_CONCRETE);
            loc5.add(+1, 0, +1).getBlock().setType(Material.LIGHT_BLUE_CONCRETE);
            loc6.add(+1, 0, 0).getBlock().setType(Material.MAGENTA_CONCRETE);
        }
    }
}
