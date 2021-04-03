package me.xenodev.tmbbl.events.profil.gadget.specialevents.easter;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class EasterEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9Farbbombe §7«")){
                //Cooldown 10s
                p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());

                p.launchProjectile(Egg.class);
                Main.instance.getServer().getWorld("world").playSound(p.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1f, 1f);

                new BukkitRunnable(){
                    @Override
                    public void run(){
                        p.getInventory().setItem(6, new ItemBuilder(Material.EGG).setName("§7» §9Farbbombe §7«").setLore("§5EasterEgg-Gadget von Ostern 2021").build());
                    }
                }.runTaskLaterAsynchronously(Main.instance, 20*5);
            }
        } catch (NullPointerException exception) { }
    }

    @EventHandler
    public void onThrow(ProjectileHitEvent e){
        Entity entity = e.getEntity();
        Block block = e.getHitBlock();
        Chunk chunks = block.getChunk();
        Location location = block.getLocation();
        Material material = block.getType();

        if(entity instanceof Egg){
            block.setType(Material.BLACK_CONCRETE);
            Main.instance.getServer().getWorld("world").playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 10f, 10f);

            Bukkit.getScheduler().runTaskLater(Main.instance, new Runnable() {
                @Override
                public void run() {
                    block.setType(material);
                }
            }, 20*10);
        }
    }
}
