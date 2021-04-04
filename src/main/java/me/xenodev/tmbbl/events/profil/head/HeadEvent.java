package me.xenodev.tmbbl.events.profil.head;

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

public class HeadEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.PLAYER_HEAD)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Köpfe §7«")){
                    e.setCancelled(true);
                    p.closeInventory();
                    Inventory inv = Bukkit.createInventory(null, 9*5, "§7» §6Köpfe §7«");


                    for(int i = 27; i < 36; i++){
                        inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    }

                    inv.setItem(0, new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Clashi").setName("§7» §6Kopf von Clashi §7«").build());
                    inv.setItem(1, new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Gondii").setName("§7» §6Kopf von Gondii §7«").build());
                    inv.setItem(2, new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Malette").setName("§7» §6Kopf von Malette §7«").build());
                    inv.setItem(3, new ItemBuilder(Material.PLAYER_HEAD).setOwner("XenoshiYT").setName("§7» §6Kopf von Xenoshi §7«").build());
                    inv.setItem(4, new ItemBuilder(Material.PLAYER_HEAD).setOwner("TheLucas777").setName("§7» §6Kopf von Lucas §7«").build());
                    inv.setItem(5, new ItemBuilder(Material.PLAYER_HEAD).setOwner("The_Reaper").setName("§7» §6Kopf von Reaper §7«").build());

                    inv.setItem(43, new ItemBuilder(Material.BARRIER).setName("§7» §cKopf löschen §7«").build());
                    inv.setItem(44, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                    p.openInventory(inv);
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }
            }
        }
    }

    @EventHandler
    public void onClickKleider(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Köpfe §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR)) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cKopf löschen §7«")){
                p.getInventory().setHelmet(null);
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                p.sendMessage(Main.prefix + "§7Du hast deinen ausgewählten Kopf gelöscht");
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
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kopf von Clashi §7«")){
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", true);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Clashi").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kopf von Gondii §7«")){
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", true);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Gondii").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kopf von Malette §7«")){
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", true);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Malette").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kopf von Xenoshi §7«")){
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", true);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("XenoshiYT").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kopf von Lucas §7«")){
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", true);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TheLucas777").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kopf von Reaper §7«")) {
                SettingsFilebuilder.setArmor(p, "Kopf", "Clashi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Gondii", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Malette", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Xenoshi", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Lucas", false);
                SettingsFilebuilder.setArmor(p, "Kopf", "Reaper", true);
                SettingsFilebuilder.setArmor(p, "Helm", "Schildkrötenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Kettenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Eisenhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Diamanthelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Goldhelm", false);
                SettingsFilebuilder.setArmor(p, "Helm", "Netherithelm", false);
                p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TheReaperGER").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }
        }
    }
}
