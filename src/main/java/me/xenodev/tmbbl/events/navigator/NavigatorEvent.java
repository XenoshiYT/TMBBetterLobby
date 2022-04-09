package me.xenodev.tmbbl.events.navigator;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.driver.service.ServiceInfoSnapshot;
import de.dytanic.cloudnet.ext.bridge.ServiceInfoSnapshotUtil;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import me.xenodev.tmbbl.file.LocationFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class NavigatorEvent implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        try{
            if(e.getItem().getType().equals(Material.COMPASS)){
                if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Navigator §7«")) {
                    Inventory inv = Bukkit.createInventory(null, 9 * 5, "§7» §6Navigator §7«");

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for (int i = 0; i < 9; i++) {
                                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                            }
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }
                    }.runTaskLaterAsynchronously(Main.instance, 0L);

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for (int i = 9; i < 18; i++) {
                                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                            }

                            inv.setItem(12, new ItemBuilder(Material.BARRIER).setName("§7» §5TryJump §7«").build());
                            inv.setItem(14, new ItemBuilder(Material.MAGMA_CREAM).setName("§7» §6Spawn §7«").build());

                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }
                    }.runTaskLaterAsynchronously(Main.instance, 5L);

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for (int i = 18; i < 27; i++) {
                                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                            }
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }
                    }.runTaskLaterAsynchronously(Main.instance, 10L);

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for (int i = 27; i < 36; i++) {
                                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                            }
                            inv.setItem(28, new ItemBuilder(Material.GOLDEN_HELMET).setName("§7» §eNeuling-Plots §7«").build());
                            inv.setItem(30, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §3Azubi-Plots §7«").build());
                            inv.setItem(32, new ItemBuilder(Material.STONE_BRICK_SLAB).setName("§7» §aTBuilderserver §7«").build());
                            inv.setItem(34, new ItemBuilder(Material.BRICK_STAIRS).setName("§7» §2Bauserver §7«").build());
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }
                    }.runTaskLaterAsynchronously(Main.instance, 15L);

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for (int i = 36; i < 45; i++) {
                                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                            }
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }
                    }.runTaskLaterAsynchronously(Main.instance, 20L);

                    p.openInventory(inv);
                }
            }
        }catch(NullPointerException e1){}
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Navigator §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE)) return;
            if(e.getCurrentItem().getType().equals(Material.MAGMA_CREAM)){
                Location loc = LocationFilebuilder.getLocation("Spawn");
                p.teleport(loc);
                p.sendMessage(Main.prefix + "§7Du hast dich zum §6Spawn §7teleportiert");
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);
                p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 255));
                p.closeInventory();
            } else if(e.getCurrentItem().getType().equals(Material.BARRIER)){
                p.sendMessage(Main.error + "§cDies wird noch kommen");
            } else if(e.getCurrentItem().getType().equals(Material.GOLDEN_HELMET)){
                if(p.hasPermission("tmb.neulingserver")){
                    IPlayerManager player = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
                    player.getPlayerExecutor(p.getUniqueId()).connect("bewerber-1");
                }else{
                    p.sendMessage(Main.error + "§cDer Neulingserver ist noch nicht betretbar");
                }
            } else if(e.getCurrentItem().getType().equals(Material.DIAMOND_HELMET)){
                if(p.hasPermission("tmb.azubiserver")){
                    IPlayerManager player = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
                    player.getPlayerExecutor(p.getUniqueId()).connect("bewerber-2");
                }else{
                    p.sendMessage(Main.error + "§cDer Azubiserver ist für Azubis vorgesehen");
                }
            } else if(e.getCurrentItem().getType().equals(Material.STONE_BRICK_SLAB)){
                if(p.hasPermission("tmb.tbuilderserver")){
                    IPlayerManager player = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
                    player.getPlayerExecutor(p.getUniqueId()).connect("tbuilderserver-1");
                }else{
                    p.sendMessage(Main.error + "§cDer TBuilderserver ist für unsere Test_Builder");
                }
            } else if(e.getCurrentItem().getType().equals(Material.BRICK_STAIRS)){
                if(p.hasPermission("tmb.bauserver")){
                    IPlayerManager player = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
                    player.getPlayerExecutor(p.getUniqueId()).connect("bauserver-1");
                }else{
                    p.sendMessage(Main.error + "§cDer Bauserver ist für das Serverteam vorgesehen");
                }
            } else if(e.getCurrentItem().getType().equals(Material.FEATHER)){
                if(p.hasPermission("tmb.tryjump")){
                    IPlayerManager player = CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
                    player.getPlayerExecutor(p.getUniqueId()).connect("tryjump-1");
                }else{
                    p.sendMessage(Main.error + "§cDer TryJump-Server ist für das Serverteam vorgesehen");
                }
            }
        }
    }
}
