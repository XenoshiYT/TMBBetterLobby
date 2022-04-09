package me.xenodev.tmbbl.events.profil.gadget.specialevents.easter;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class SwitchBow implements Listener {

    private ArrayList<Player> cooldownArray = new ArrayList<>();
    private Integer cooldownInt = 3;
    private BukkitTask cooldownID;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(p.getInventory().getItemInHand().getType().equals(Material.BOW)) {
                if (p.getInventory().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9Switch Bow §7«")) {
                    e.setCancelled(true);

                    if (!cooldownArray.contains(p)) {
                        cooldownArray.add(p);
                        Arrow arrow = p.launchProjectile(Arrow.class);
                        Egg egg = p.launchProjectile(Egg.class);
                        arrow.setPassenger(egg);
                        p.playSound(p.getLocation(), Sound.ITEM_CROSSBOW_SHOOT, 1f, 1f);
                        cooldownID = Bukkit.getScheduler().runTaskTimer(Main.instance, new Runnable() {
                            @Override
                            public void run() {
                                p.getInventory().setItem(6, new ItemBuilder(Material.BOW).setName("§7» §9Switch Bow §7«").setAmount(cooldownInt).build());
                                cooldownInt--;
                                if (cooldownInt == 0) {
                                    Bukkit.getScheduler().cancelTask(cooldownID.getTaskId());
                                    p.getInventory().setItem(6, new ItemBuilder(Material.BOW).setName("§7» §9Switch Bow §7«").setAmount(1).build());
                                    cooldownInt = 3;
                                    cooldownArray.remove(p);
                                }
                            }
                        }, 0, 20*1);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent e){
        if(e.getEntity().getShooter() instanceof Player && e.getHitEntity() instanceof Player) {
            Player p = (Player) e.getEntity().getShooter();
            Player t = (Player) e.getHitEntity();

            Location oldp = p.getLocation();
            Location oldt = t.getLocation();
            if (e.getEntity() instanceof Arrow) {
                p.teleport(oldt);
                t.teleport(oldp);
                p.playSound(p.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1f, 1f);
                t.playSound(t.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1f, 1f);
                Entity arrow = e.getEntity();
                arrow.remove();
            }
        }
    }

    @EventHandler
    public void onLand(ProjectileHitEvent e){
        if (e.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getEntity();
            Egg egg = (Egg) arrow.getPassenger();
            arrow.remove();
            egg.remove();
        }
    }

}
