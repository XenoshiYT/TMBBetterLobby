package me.xenodev.tmbbl.events.profil.music.main;

import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class MusicEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.MUSIC_DISC_PIGSTEP)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Musik §7«")){
                    e.setCancelled(true);
                    p.closeInventory();
                    Inventory inv = Bukkit.createInventory(null, 9*4, "§7» §6Musik §7«");


                    for(int i = 18; i < 27; i++){
                        inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    }

                    inv.setItem(0, new ItemBuilder(Material.MUSIC_DISC_13).setName("§7» §6Volume Alpha 13 §7«").build());
                    inv.setItem(1, new ItemBuilder(Material.MUSIC_DISC_CAT).setName("§7» §6Volume Alpha Cat §7«").build());
                    inv.setItem(2, new ItemBuilder(Material.MUSIC_DISC_BLOCKS).setName("§7» §6Volume Alpha Blocks §7«").build());
                    inv.setItem(3, new ItemBuilder(Material.MUSIC_DISC_CHIRP).setName("§7» §6Volume Alpha Chirp §7«").build());
                    inv.setItem(4, new ItemBuilder(Material.MUSIC_DISC_FAR).setName("§7» §6Volume Alpha Far §7«").build());
                    inv.setItem(5, new ItemBuilder(Material.MUSIC_DISC_MALL).setName("§7» §6Volume Alpha Mall §7«").build());
                    inv.setItem(6, new ItemBuilder(Material.MUSIC_DISC_MELLOHI).setName("§7» §6Volume Alpha Mellohi §7«").build());
                    inv.setItem(7, new ItemBuilder(Material.MUSIC_DISC_STAL).setName("§7» §6Volume Alpha Stal §7«").build());
                    inv.setItem(8, new ItemBuilder(Material.MUSIC_DISC_STRAD).setName("§7» §6Volume Alpha Strad §7«").build());
                    inv.setItem(9, new ItemBuilder(Material.MUSIC_DISC_WARD).setName("§7» §6Volume Alpha Ward §7«").build());
                    inv.setItem(10, new ItemBuilder(Material.MUSIC_DISC_11).setName("§7» §6Volume Alpha 11 §7«").build());
                    inv.setItem(11, new ItemBuilder(Material.MUSIC_DISC_WAIT).setName("§7» §6Volume Alpha Wait §7«").build());
                    inv.setItem(12, new ItemBuilder(Material.MUSIC_DISC_PIGSTEP).setName("§7» §6Volume Alpha Pigstep §7«").build());

                    inv.setItem(34, new ItemBuilder(Material.BARRIER).setName("§7» §cMusik löschen §7«").build());
                    inv.setItem(35, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                    p.openInventory(inv);
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }
            }
        }
    }
}
