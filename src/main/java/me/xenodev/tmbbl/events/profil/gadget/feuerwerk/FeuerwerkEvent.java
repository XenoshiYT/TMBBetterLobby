package me.xenodev.tmbbl.events.profil.gadget.feuerwerk;

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

public class FeuerwerkEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9Feuerwerk §7«")) {
                p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());
                Location loc = p.getLocation();
                if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                    loc = e.getClickedBlock().getRelative(BlockFace.UP).getLocation();
                }
                FireworkMeta firemeta = (FireworkMeta) e.getItem().getItemMeta();
                firemeta.setPower(1);
                firemeta.addEffect(FireworkEffect.builder().withFade(Color.LIME).withColor(Color.BLUE).trail(true).build());

                Firework firework = loc.getWorld().spawn(loc, Firework.class);
                firework.setFireworkMeta(firemeta);

                new BukkitRunnable(){
                    @Override
                    public void run(){
                        p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_ROCKET).setName("§7» §9Feuerwerk §7«").build());
                    }
                }.runTaskLaterAsynchronously(Main.instance, 20*1);
            }
        } catch (NullPointerException e1) {}
    }
}
