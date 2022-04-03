package me.xenodev.tmbbl.events.profil.gadget.enderperle;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.spigotmc.event.entity.EntityDismountEvent;

public class EnderperleEvent implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Endermite) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().getType().equals(Material.ENDER_PEARL) && (e.getAction().equals(Action.RIGHT_CLICK_AIR)) && !p.isSneaking()) {
            e.setCancelled(false);

            p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_STAR).setName("§cBitte kurz warten").build());
            EnderPearl pearl = p.launchProjectile(EnderPearl.class);
            pearl.setPassenger(p);

            new BukkitRunnable() {
                @Override
                public void run() {
                    p.getInventory().setItem(6, new ItemBuilder(Material.ENDER_PEARL).setName("§7» §9Enderperle §7«").build());
                }
            }.runTaskLater(Main.instance, 20 * 3);
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onVehicleLeave(EntityDismountEvent e){
        Entity entity = e.getDismounted();

        if(entity instanceof EnderPearl){
            entity.remove();
        }

    }
}
