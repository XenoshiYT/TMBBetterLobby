package me.xenodev.tmbbl.events.profil.music.main;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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

                    inv.setItem(34, new ItemBuilder(Material.BARRIER).setName("§7» §cMusik stoppen §7«").build());
                    inv.setItem(35, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

                    p.openInventory(inv);
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }
            }
        }
    }

    @EventHandler
    public void onClickMusik(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Musik §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR)) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cMusik stoppen §7«")){
                clearmusic(p);
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
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha 13 §7«")){
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_13, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Cat §7«")){
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_CAT, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Blocks §7«")){
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_BLOCKS, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Chirp §7«")){
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_CHIRP, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Far §7«")){
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_FAR, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Mall §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_MALL, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Mellohi §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_MELLOHI, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Stal §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_STAL, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Strad §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_STRAD, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Ward §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_WARD, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha 11 §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_11, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Wait §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_WAIT, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Volume Alpha Pigstep §7«")) {
                clearmusic(p);
                p.playSound(p.getLocation(), Sound.MUSIC_DISC_PIGSTEP, 1f, 1f);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }
        }
    }

    private void clearmusic(Player p){
        p.stopSound(Sound.MUSIC_DISC_13);
        p.stopSound(Sound.MUSIC_DISC_CAT);
        p.stopSound(Sound.MUSIC_DISC_BLOCKS);
        p.stopSound(Sound.MUSIC_DISC_CHIRP);
        p.stopSound(Sound.MUSIC_DISC_FAR);
        p.stopSound(Sound.MUSIC_DISC_MALL);
        p.stopSound(Sound.MUSIC_DISC_MELLOHI);
        p.stopSound(Sound.MUSIC_DISC_STAL);
        p.stopSound(Sound.MUSIC_DISC_STRAD);
        p.stopSound(Sound.MUSIC_DISC_WARD);
        p.stopSound(Sound.MUSIC_DISC_11);
        p.stopSound(Sound.MUSIC_DISC_WAIT);
        p.stopSound(Sound.MUSIC_DISC_PIGSTEP);
    }
}
