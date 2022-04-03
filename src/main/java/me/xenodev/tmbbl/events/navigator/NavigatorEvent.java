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
                            ServiceInfoSnapshot bewerber1 = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName("bewerber-1");
                            Integer bi1 = ServiceInfoSnapshotUtil.getPlayers(bewerber1).size();
                            Integer bm1 = ServiceInfoSnapshotUtil.getMaxPlayers(bewerber1);
                            ServiceInfoSnapshot bewerber2 = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName("bewerber-2");
                            Integer bi2 = ServiceInfoSnapshotUtil.getPlayers(bewerber2).size();
                            Integer bm2 = ServiceInfoSnapshotUtil.getMaxPlayers(bewerber2);

                            inv.setItem(11, new ItemBuilder(Material.GOLDEN_HELMET).setName("§7» §eNeuling-Plots §7«").setLore("", "§7- §c§o" + bi1 + " §7/ §c§o" + bm1 + " §7-", "", "", "§7§oDrücke auf das ITEM um zu connecten").build());
                            inv.setItem(15, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §3Azubi-Plots §7«").setLore("", "§7- §c§o" + bi2 + " §7/ §c§o" + bm2 + " §7-", "", "", "§7§oDrücke auf das ITEM um zu connecten").build());
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }
                    }.runTaskLaterAsynchronously(Main.instance, 5L);

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for (int i = 18; i < 27; i++) {
                                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                            }
                            ServiceInfoSnapshot lobby = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName("lobby-1");
                            Integer li = ServiceInfoSnapshotUtil.getPlayers(lobby).size();
                            Integer lm = ServiceInfoSnapshotUtil.getMaxPlayers(lobby);
                            inv.setItem(22, new ItemBuilder(Material.MAGMA_CREAM).setName("§7» §6Spawn §7«").setLore("", "§7- §c§o" + li + " §7/ §c§o" + lm + " §7-", "", "", "§7§oDrücke auf das ITEM um zu connecten").build());
                            p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                        }
                    }.runTaskLaterAsynchronously(Main.instance, 10L);

                    new BukkitRunnable(){
                        @Override
                        public void run(){
                            for (int i = 27; i < 36; i++) {
                                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                            }
                            ServiceInfoSnapshot tutorial = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName("tbuilderserver-1");
                            Integer ti = ServiceInfoSnapshotUtil.getPlayers(tutorial).size();
                            Integer tm = ServiceInfoSnapshotUtil.getMaxPlayers(tutorial);
                            ServiceInfoSnapshot bauserver = CloudNetDriver.getInstance().getCloudServiceProvider().getCloudServiceByName("bauserver-1");
                            Integer bi = ServiceInfoSnapshotUtil.getPlayers(bauserver).size();
                            Integer bm = ServiceInfoSnapshotUtil.getMaxPlayers(bauserver);
                            inv.setItem(29, new ItemBuilder(Material.STONE_BRICK_SLAB).setName("§7» §aTBuilderserver §7«").setLore("", "§7- §c§o" + ti + " §7/ §c§o" + tm + " §7-", "", "", "§7§oDrücke auf das ITEM um zu connecten").build());
                            inv.setItem(33, new ItemBuilder(Material.BRICK_STAIRS).setName("§7» §2Bauserver §7«").setLore("", "§7- §c§o" + bi + " §7/ §c§o" + bm + " §7-", "", "", "§7§oDrücke auf das ITEM um zu connecten").build());
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
            }
        }
    }
}
