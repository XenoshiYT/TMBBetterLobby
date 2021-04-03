package me.xenodev.tmbbl.events.profil.gadget.megasprung;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Firework;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MegasprungEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9Megasprung §7«")) {
                Vector vector = p.getVelocity();
                vector.setY(2.5D);
                p.setVelocity(vector);
                p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 3, 1);
                p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());

                new BukkitRunnable(){
                    @Override
                    public void run(){
                        p.getInventory().setItem(6, new ItemBuilder(Material.FEATHER).setName("§7» §9Megasprung §7«").build());
                    }
                }.runTaskLaterAsynchronously(Main.instance, 20*3);
            }
        } catch (NullPointerException e1) {}
    }
}
