package me.xenodev.tmbbl.events.profil.settings;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;

public class SettingsEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.REDSTONE)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Settings §7«")){
                    e.setCancelled(true);
                    openInv(p);
                }
            }
        }
    }

    @EventHandler
    public void onClickSettings(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Settings §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR) || e.getCurrentItem() == null) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cZurücksetzen §7«")){
                SettingsFilebuilder.setSetting(p, "Hide", false);
                SettingsFilebuilder.setSetting(p, "Eggboost", true);
                p.sendMessage(Main.prefix + "§cDu hast deinen Einstellungen zurückgesetzt");
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
                inv.setItem(42, new ItemBuilder(Material.REDSTONE).setName("§7» §6Settings §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Verstecker §7«")){
                if(SettingsFilebuilder.getSetting(p, "Hide").equals(true)) {
                    SettingsFilebuilder.setSetting(p, "Hide", false);
                    p.sendMessage(Main.prefix + "§7Du siehst nun §aalle §7Spieler wieder");
                    for(Player all : Bukkit.getOnlinePlayers()){
                        p.showPlayer(Main.instance, all);
                    }
                    openInv(p);
                }else if(SettingsFilebuilder.getSetting(p, "Hide").equals(false)){
                    SettingsFilebuilder.setSetting(p, "Hide", true);
                    SettingsFilebuilder.setSetting(p, "Eggboost", false);
                    p.sendMessage(Main.prefix + "§7Du siehst nun §ckeine §7Spieler mehr");
                    for(Player all : Bukkit.getOnlinePlayers()){
                        p.hidePlayer(Main.instance, all);
                    }
                    openInv(p);
                }
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eggboost Other §7«")){
                if(SettingsFilebuilder.getSetting(p, "Eggboost_other").equals(true)) {
                    SettingsFilebuilder.setSetting(p, "Eggboost_other", false);
                    p.sendMessage(Main.prefix + "§7Du kannst von anderen Spielern nicht geboostet werden");
                    openInv(p);
                }else if(SettingsFilebuilder.getSetting(p, "Eggboost_other").equals(false)){
                    SettingsFilebuilder.setSetting(p, "Eggboost_other", true);
                    p.sendMessage(Main.prefix + "§7Du kannst von anderen Spielern geboostet werden");
                    openInv(p);
                }
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eggboost Self §7«")){
                if(SettingsFilebuilder.getSetting(p, "Eggboost_self").equals(true)) {
                    SettingsFilebuilder.setSetting(p, "Eggboost_self", false);
                    p.sendMessage(Main.prefix + "§7Du kannst dich selbst nicht boosten");
                    openInv(p);
                }else if(SettingsFilebuilder.getSetting(p, "Eggboost_self").equals(false)){
                    SettingsFilebuilder.setSetting(p, "Eggboost_self", true);
                    p.sendMessage(Main.prefix + "§7Du kannst dich selbst boosten");
                    openInv(p);
                }
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Double Jump §7«")){
                if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(true)) {
                    SettingsFilebuilder.setSetting(p, "Doublejump", false);
                    p.sendMessage(Main.prefix + "§7Du kannst nicht doppelt springen");
                    openInv(p);
                }else if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(false)){
                    SettingsFilebuilder.setSetting(p, "Doublejump", true);
                    p.sendMessage(Main.prefix + "§7Du kannst doppelt springen");
                    openInv(p);
                }
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }
        }
    }

    private void openInv(Player p){
        p.closeInventory();
        Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §6Settings §7«");


        for(int i = 36; i < 45; i++){
            inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
        }

        if(SettingsFilebuilder.getSetting(p, "Eggboost_other").equals(true)) {
            inv.setItem(0, new ItemBuilder(Material.EGG).setName("§7» §6Eggboost Other §7«").setLore("§7Du kannst von anderen Spielern geboostet werden").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
        }else if(SettingsFilebuilder.getSetting(p, "Eggboost_other").equals(false)) {
            inv.setItem(0, new ItemBuilder(Material.EGG).setName("§7» §6Eggboost Other §7«").setLore("§7Du kannst von anderen Spielern nicht geboostet werden").build());
        }
        if(SettingsFilebuilder.getSetting(p, "Eggboost_self").equals(true)) {
            inv.setItem(1, new ItemBuilder(Material.EGG).setName("§7» §6Eggboost Self §7«").setLore("§7Du kannst dich selbst boosten").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
        }else if(SettingsFilebuilder.getSetting(p, "Eggboost_self").equals(false)) {
            inv.setItem(1, new ItemBuilder(Material.EGG).setName("§7» §6Eggboost Self §7«").setLore("§7Du kannst dich selbst nicht boosten").build());
        }
        if(SettingsFilebuilder.getSetting(p, "Hide").equals(true)) {
            inv.setItem(2, new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§7» §6Verstecker §7«").setLore("§7Du siehst nun §ckeine §7Spieler mehr").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
        }else if(SettingsFilebuilder.getSetting(p, "Hide").equals(false)) {
            inv.setItem(2, new ItemBuilder(Material.TOTEM_OF_UNDYING).setName("§7» §6Verstecker §7«").setLore("§7Du siehst nun §aalle §7Spieler wieder").build());
        }
        if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(true)) {
            inv.setItem(3, new ItemBuilder(Material.FEATHER).setName("§7» §6Double Jump §7«").setLore("§7Du kannst doppelt springen").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
        }else if(SettingsFilebuilder.getSetting(p, "Doublejump").equals(false)) {
            inv.setItem(3, new ItemBuilder(Material.FEATHER).setName("§7» §6Double Jump §7«").setLore("§7Du kannst nicht doppelt springen").build());
        }

        inv.setItem(52, new ItemBuilder(Material.BARRIER).setName("§7» §cZurücksetzen §7«").build());
        inv.setItem(53, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
    }
}
