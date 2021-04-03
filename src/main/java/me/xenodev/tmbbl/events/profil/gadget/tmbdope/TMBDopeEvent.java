package me.xenodev.tmbbl.events.profil.gadget.tmbdope;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class TMBDopeEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9TMBDope §7«")) {
                p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());
                p.playSound(p.getLocation(), Sound.ENTITY_PANDA_SNEEZE, 1f, 1f);

                p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*30*2, 3));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*30*2, 3));

                new BukkitRunnable(){
                    @Override
                    public void run(){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*20, 2));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20*20, 2));
                    }
                }.runTaskLaterAsynchronously(Main.instance, 20*60);

                new BukkitRunnable(){
                    @Override
                    public void run(){
                        p.getInventory().setItem(6, new ItemBuilder(Material.SUGAR).setName("§7» §9TMBDope §7«").build());
                    }
                }.runTaskLaterAsynchronously(Main.instance, 20*80);
            }
        } catch (NullPointerException e1) {}
    }
}
