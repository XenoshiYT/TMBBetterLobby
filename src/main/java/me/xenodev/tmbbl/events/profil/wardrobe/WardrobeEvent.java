package me.xenodev.tmbbl.events.profil.wardrobe;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class WardrobeEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.NETHERITE_CHESTPLATE)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kleiderschrank §7«")){
                    e.setCancelled(true);
                    p.closeInventory();
                    Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §6Kleiderschrank §7«");

                    for(int i = 0; i < 53; i++){
                        inv.setItem(i, new ItemBuilder(Material.AIR).build());
                    }

                    for(int i = 36; i < 45; i++){
                        inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    }

                    inv.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    inv.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    inv.setItem(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    inv.setItem(28, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());

                    inv.setItem(0, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §6Helme §7«").build());
                    inv.setItem(9, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Brustplatten §7«").build());
                    inv.setItem(18, new ItemBuilder(Material.IRON_LEGGINGS).setName("§7» §6Hosen §7«").build());
                    inv.setItem(27, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Schuhe §7«").build());

                    inv.setItem(52, new ItemBuilder(Material.BARRIER).setName("§7» §cKleidung löschen §7«").build());
                    inv.setItem(53, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                    p.openInventory(inv);
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }
            }
        }
    }

    @EventHandler
    public void onClickKleider(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Kleiderschrank §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR)) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Helme §7«")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §6Kleiderschrank §7«");

                for(int i = 0; i < 53; i++){
                    inv.setItem(i, new ItemBuilder(Material.AIR).build());
                }

                for(int i = 36; i < 45; i++){
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                }

                inv.setItem(1, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
                inv.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(28, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());

                inv.setItem(0, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §6Helme §7«").build());
                inv.setItem(9, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Brustplatten §7«").build());
                inv.setItem(18, new ItemBuilder(Material.IRON_LEGGINGS).setName("§7» §6Hosen §7«").build());
                inv.setItem(27, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Schuhe §7«").build());

                inv.setItem(2, new ItemBuilder(Material.TURTLE_HELMET).setName("§7» §6Schildkrötenhelm §7«").build());
                inv.setItem(3, new ItemBuilder(Material.CHAINMAIL_HELMET).setName("§7» §6Kettenhelm §7«").build());
                inv.setItem(4, new ItemBuilder(Material.IRON_HELMET).setName("§7» §6Eisenhelm §7«").build());
                inv.setItem(5, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §6Diamanthelm §7«").build());
                inv.setItem(6, new ItemBuilder(Material.GOLDEN_HELMET).setName("§7» §6Goldhelm §7«").build());
                inv.setItem(7, new ItemBuilder(Material.NETHERITE_HELMET).setName("§7» §6Netherithelm §7«").build());

                inv.setItem(52, new ItemBuilder(Material.BARRIER).setName("§7» §cKleidung löschen §7«").build());
                inv.setItem(53, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Brustplatten §7«")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §6Kleiderschrank §7«");

                for(int i = 0; i < 53; i++){
                    inv.setItem(i, new ItemBuilder(Material.AIR).build());
                }

                for(int i = 36; i < 45; i++){
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                }

                inv.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(10, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
                inv.setItem(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(28, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());

                inv.setItem(0, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §6Helme §7«").build());
                inv.setItem(9, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Brustplatten §7«").build());
                inv.setItem(18, new ItemBuilder(Material.IRON_LEGGINGS).setName("§7» §6Hosen §7«").build());
                inv.setItem(27, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Schuhe §7«").build());

                inv.setItem(2, new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setName("§7» §6Kettenbrustplatte §7«").build());
                inv.setItem(3, new ItemBuilder(Material.IRON_CHESTPLATE).setName("§7» §6Eisenbrustplatte §7«").build());
                inv.setItem(4, new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName("§7» §6Diamantbrustplatte §7«").build());
                inv.setItem(5, new ItemBuilder(Material.GOLDEN_CHESTPLATE).setName("§7» §6Goldbrustplatte §7«").build());
                inv.setItem(6, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Netheritbrustplatte §7«").build());

                inv.setItem(52, new ItemBuilder(Material.BARRIER).setName("§7» §cKleidung löschen §7«").build());
                inv.setItem(53, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Hosen §7«")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §6Kleiderschrank §7«");

                for(int i = 0; i < 53; i++){
                    inv.setItem(i, new ItemBuilder(Material.AIR).build());
                }

                for(int i = 36; i < 45; i++){
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                }

                inv.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(19, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
                inv.setItem(28, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());

                inv.setItem(0, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §6Helme §7«").build());
                inv.setItem(9, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Brustplatten §7«").build());
                inv.setItem(18, new ItemBuilder(Material.IRON_LEGGINGS).setName("§7» §6Hosen §7«").build());
                inv.setItem(27, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Schuhe §7«").build());

                inv.setItem(2, new ItemBuilder(Material.CHAINMAIL_LEGGINGS).setName("§7» §6Kettenhose §7«").build());
                inv.setItem(3, new ItemBuilder(Material.IRON_LEGGINGS).setName("§7» §6Eisenhose §7«").build());
                inv.setItem(4, new ItemBuilder(Material.DIAMOND_LEGGINGS).setName("§7» §6Diamanthose §7«").build());
                inv.setItem(5, new ItemBuilder(Material.GOLDEN_LEGGINGS).setName("§7» §6Goldhose §7«").build());
                inv.setItem(6, new ItemBuilder(Material.NETHERITE_LEGGINGS).setName("§7» §6Netherithose §7«").build());

                inv.setItem(52, new ItemBuilder(Material.BARRIER).setName("§7» §cKleidung löschen §7«").build());
                inv.setItem(53, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Schuhe §7«")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §6Kleiderschrank §7«");

                for(int i = 0; i < 53; i++){
                    inv.setItem(i, new ItemBuilder(Material.AIR).build());
                }

                for(int i = 36; i < 45; i++){
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                }

                inv.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                inv.setItem(28, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());

                inv.setItem(0, new ItemBuilder(Material.DIAMOND_HELMET).setName("§7» §6Helme §7«").build());
                inv.setItem(9, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Brustplatten §7«").build());
                inv.setItem(18, new ItemBuilder(Material.IRON_LEGGINGS).setName("§7» §6Hosen §7«").build());
                inv.setItem(27, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Schuhe §7«").build());

                inv.setItem(2, new ItemBuilder(Material.CHAINMAIL_BOOTS).setName("§7» §6Kettenschuhe §7«").build());
                inv.setItem(3, new ItemBuilder(Material.IRON_BOOTS).setName("§7» §6Eisenschuhe §7«").build());
                inv.setItem(4, new ItemBuilder(Material.DIAMOND_BOOTS).setName("§7» §6Diamantschuhe §7«").build());
                inv.setItem(5, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Goldschuhe §7«").build());
                inv.setItem(6, new ItemBuilder(Material.NETHERITE_BOOTS).setName("§7» §6Netheritschuhe §7«").build());

                inv.setItem(52, new ItemBuilder(Material.BARRIER).setName("§7» §cKleidung löschen §7«").build());
                inv.setItem(53, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cKleidung löschen §7«")){
                p.getInventory().setHelmet(null);
                p.getInventory().setChestplate(null);
                p.getInventory().setLeggings(null);
                p.getInventory().setBoots(null);
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Kettenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Eisenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Diamantbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Goldbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Netheritbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Kettenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Eisenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Diamanthose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Goldhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Netherithose", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Kettenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Eisenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Diamantschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Goldschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Netheritschuhe", false);
                p.sendMessage(Main.prefix + "§7Du hast deine ausgewählten Kleidungen gelöscht");
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Zurück §7«")) {
                p.closeInventory();
                Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §aProfil §7«");

                for(int i = 0; i < 53; i++){
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                }

                inv.setItem(12, new ItemBuilder(Material.MUSIC_DISC_PIGSTEP).setName("§7» §6Musik §7«").build());
                inv.setItem(14, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());
                inv.setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setName("§7» §6Köpfe §7«").build());
                inv.setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setOwner(p.getName()).setName("§7» §6Freunde §7«").build());
                inv.setItem(31, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Kleiderschrank §7«").build());
                inv.setItem(38, new ItemBuilder(Material.CHEST).setName("§7» §6Gadgets §7«").build());
                inv.setItem(42, new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§7» §6Verstecker §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Schildkrötenhelm §7«")){
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", true);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.TURTLE_HELMET).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kettenhelm §7«")){
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", true);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.CHAINMAIL_HELMET).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eisenhelm §7«")){
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", true);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.IRON_HELMET).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Diamanthelm §7«")){
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", true);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Goldhelm §7«")){
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", true);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.GOLDEN_HELMET).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Netherithelm §7«")){
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", true);
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.NETHERITE_HELMET).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kettenbrustplatte §7«")){
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Kettenbrustplatte", true);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Eisenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Diamantbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Goldbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Netheritbrustplatte", false);
                p.getInventory().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eisenbrustplatte §7«")){
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Kettenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Eisenbrustplatte", true);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Diamantbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Goldbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Netheritbrustplatte", false);
                p.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Diamantbrustplatte §7«")){
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Kettenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Eisenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Diamantbrustplatte", true);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Goldbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Netheritbrustplatte", false);
                p.getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Goldbrustplatte §7«")){
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Kettenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Eisenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Diamantbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Goldbrustplatte", true);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Netheritbrustplatte", false);
                p.getInventory().setChestplate(new ItemBuilder(Material.GOLDEN_CHESTPLATE).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Netheritbrustplatte §7«")){
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Kettenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Eisenbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Diamantbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Goldbrustplatte", false);
                SettingsFilebuilder.setArmor(p, "Brustplatte", "Netheritbrustplatte", true);
                p.getInventory().setChestplate(new ItemBuilder(Material.NETHERITE_CHESTPLATE).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kettenhose §7«")){
                SettingsFilebuilder.setArmor(p, "Hose", "Kettenhose", true);
                SettingsFilebuilder.setArmor(p, "Hose", "Eisenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Diamanthose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Goldhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Netherithose", false);
                p.getInventory().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eisenhose §7«")){
                SettingsFilebuilder.setArmor(p, "Hose", "Kettenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Eisenhose", true);
                SettingsFilebuilder.setArmor(p, "Hose", "Diamanthose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Goldhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Netherithose", false);
                p.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Diamanthose §7«")){
                SettingsFilebuilder.setArmor(p, "Hose", "Kettenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Eisenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Diamanthose", true);
                SettingsFilebuilder.setArmor(p, "Hose", "Goldhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Netherithose", false);
                p.getInventory().setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Goldhose §7«")){
                SettingsFilebuilder.setArmor(p, "Hose", "Kettenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Eisenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Diamanthose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Goldhose", true);
                SettingsFilebuilder.setArmor(p, "Hose", "Netherithose", false);
                p.getInventory().setLeggings(new ItemBuilder(Material.GOLDEN_LEGGINGS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Netherithose §7«")){
                SettingsFilebuilder.setArmor(p, "Hose", "Kettenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Eisenhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Diamanthose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Goldhose", false);
                SettingsFilebuilder.setArmor(p, "Hose", "Netherithose", true);
                p.getInventory().setLeggings(new ItemBuilder(Material.NETHERITE_LEGGINGS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kettenschuhe §7«")){
                SettingsFilebuilder.setArmor(p, "Schuhe", "Kettenschuhe", true);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Eisenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Diamantschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Goldschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Netheritschuhe", false);
                p.getInventory().setBoots(new ItemBuilder(Material.CHAINMAIL_BOOTS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eisenschuhe §7«")){
                SettingsFilebuilder.setArmor(p, "Schuhe", "Kettenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Eisenschuhe", true);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Diamantschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Goldschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Netheritschuhe", false);
                p.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Diamantschuhe §7«")){
                SettingsFilebuilder.setArmor(p, "Schuhe", "Kettenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Eisenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Diamantschuhe", true);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Goldschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Netheritschuhe", false);
                p.getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Goldschuhe §7«")){
                SettingsFilebuilder.setArmor(p, "Schuhe", "Kettenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Eisenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Diamantschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Goldschuhe", true);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Netheritschuhe", false);
                p.getInventory().setBoots(new ItemBuilder(Material.GOLDEN_BOOTS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Netheritschuhe §7«")){
                SettingsFilebuilder.setArmor(p, "Schuhe", "Kettenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Eisenschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Diamantschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Goldschuhe", false);
                SettingsFilebuilder.setArmor(p, "Schuhe", "Netheritschuhe", true);
                p.getInventory().setBoots(new ItemBuilder(Material.NETHERITE_BOOTS).setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }
        }
    }

}
