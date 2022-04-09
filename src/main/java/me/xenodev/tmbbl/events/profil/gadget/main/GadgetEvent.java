package me.xenodev.tmbbl.events.profil.gadget.main;

import me.xenodev.tmbbl.file.BuyFilebuilder;
import me.xenodev.tmbbl.file.EventFilebuilder;
import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class GadgetEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.CHEST)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Gadgets §7«")){
                    e.setCancelled(true);
                    p.closeInventory();
                    Inventory inv = Bukkit.createInventory(null, 9*4, "§7» §6Gadgets §7«");

                    for(int i = 18; i < 27; i++){
                        inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    }

                    if(BuyFilebuilder.getBuy(p, "enderperl").equals(true)){
                        inv.addItem(new ItemBuilder(Material.ENDER_PEARL).setName("§7» §6Enderperle §7«").build());
                    }
                    if(BuyFilebuilder.getBuy(p, "enterhaken").equals(true)){
                        inv.addItem(new ItemBuilder(Material.FISHING_ROD).setName("§7» §6Enterhaken §7«").build());
                    }
                    if(BuyFilebuilder.getBuy(p, "flugstab").equals(true)){
                        inv.addItem(new ItemBuilder(Material.BLAZE_ROD).setName("§7» §6Flugstab §7«").build());
                    }
                    if(BuyFilebuilder.getBuy(p, "eggbomb").equals(true)){
                        inv.addItem(new ItemBuilder(Material.PLAYER_HEAD).setName("§7» §6Eggbomb §7«").setLore("§oGatget von Ostern 2021").setOwnerURL("http://textures.minecraft.net/texture/3ed037452223bda1381a17c3daafa71baac6ed8aa3a71ae36163cfeb61227b47").build());
                    }
                    if(BuyFilebuilder.getBuy(p, "switchbow").equals(true)){
                        inv.addItem(new ItemBuilder(Material.BOW).setName("§7» §6Switch Bow §7«").setLore("§oGatget von Ostern 2022").build());
                    }

                    inv.setItem(34, new ItemBuilder(Material.BARRIER).setName("§7» §cGadget löschen §7«").build());
                    inv.setItem(35, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                    p.openInventory(inv);
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }
            }
        }
    }

    @EventHandler
    public void onClickKleider(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Gadgets §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR) || e.getCurrentItem().getType().equals(Material.NETHER_STAR) || e.getCurrentItem() == null) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cGadget löschen §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                SettingsFilebuilder.setSetting(p, "Flugstab", false);
                SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                SettingsFilebuilder.setSetting(p, "Enderperle", false);
                SettingsFilebuilder.setSetting(p, "Switchbow", false);
                p.sendMessage(Main.prefix + "§cDu hast dein ausgewähltes Gadget gelöscht");
                p.getInventory().setItem(6, new ItemBuilder(Material.BARRIER).setName("§7» §cKein Gadget ausgewählt §7«").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Zurück §7«")) {
                p.closeInventory();
                Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §aProfil §7«");

                for(int i = 0; i < 53; i++){
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                }

                inv.setItem(12, new ItemBuilder(Material.PLAYER_HEAD).setOwnerURL("http://textures.minecraft.net/texture/9d4c9997ad46fdf900720c189720977fdee3742ab9ae9ffb00e5af9417d0454e").setName("§7» §6Köpfe §7«").build());
                inv.setItem(19, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Kleiderschrank §7«").build());
                inv.setItem(38, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());

                inv.setItem(14, new ItemBuilder(Material.CHEST).setName("§7» §6Gadgets §7«").build());
                inv.setItem(25, new ItemBuilder(Material.ENDER_CHEST).setName("§7» §6Shop §7«").build());
                inv.setItem(42, new ItemBuilder(Material.REDSTONE).setName("§7» §6Settings §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Enterhaken §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", true);
                SettingsFilebuilder.setSetting(p, "Flugstab", false);
                SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                SettingsFilebuilder.setSetting(p, "Enderperle", false);
                SettingsFilebuilder.setSetting(p, "Switchbow", false);
                p.getInventory().setItem(6, new ItemBuilder(Material.FISHING_ROD).setName("§7» §9Enterhaken §7«").setUnbreakable().build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Flugstab §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                SettingsFilebuilder.setSetting(p, "Flugstab", true);
                SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                SettingsFilebuilder.setSetting(p, "Enderperle", false);
                SettingsFilebuilder.setSetting(p, "Switchbow", false);
                p.getInventory().setItem(6, new ItemBuilder(Material.BLAZE_ROD).setName("§7» §9Flugstab §7«").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eggbomb §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                SettingsFilebuilder.setSetting(p, "Flugstab", false);
                SettingsFilebuilder.setSetting(p, "Eggbomb", true);
                SettingsFilebuilder.setSetting(p, "Enderperle", false);
                SettingsFilebuilder.setSetting(p, "Switchbow", false);
                p.getInventory().setItem(6, new ItemBuilder(Material.EGG).setName("§7» §9Eggbomb §7«").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Enderperle §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                SettingsFilebuilder.setSetting(p, "Flugstab", false);
                SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                SettingsFilebuilder.setSetting(p, "Enderperle", true);
                SettingsFilebuilder.setSetting(p, "Switchbow", false);
                p.getInventory().setItem(6, new ItemBuilder(Material.ENDER_PEARL).setName("§7» §9Enderperle §7«").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Switch Bow §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                SettingsFilebuilder.setSetting(p, "Flugstab", false);
                SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                SettingsFilebuilder.setSetting(p, "Enderperle", false);
                SettingsFilebuilder.setSetting(p, "Switchbow", true);
                p.getInventory().setItem(6, new ItemBuilder(Material.BOW).setName("§7» §9Switch Bow §7«").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }
        }
    }
}
