package me.xenodev.tmbbl.events.profil.trail.main;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class TrailEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.GOLDEN_BOOTS)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Spuren §7«")){
                    e.setCancelled(true);
                    p.closeInventory();
                    Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §6Spuren §7«");


                    for(int i = 36; i < 45; i++){
                        inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                    }

                    inv.setItem(0, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.RED).setName("§7» §6Love §7«").build());
                    inv.setItem(1, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.LIME).setName("§7» §6Note §7«").build());
                    inv.setItem(2, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.WHITE).setName("§7» §6Cloud §7«").build());
                    inv.setItem(3, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.ORANGE).setName("§7» §6Flame §7«").build());
                    inv.setItem(4, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.AQUA).setName("§7» §6Soulflame §7«").build());
                    inv.setItem(5, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.GRAY).setName("§7» §6Smoke §7«").build());
                    inv.setItem(6, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.YELLOW).setName("§7» §6Color §7«").setLore("§5EasterEgg-Boots von Ostern 2021").build());
                    inv.setItem(7, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.RED).setName("§7» §9Coming soon §7«").build());
                    inv.setItem(8, new ItemBuilder(Material.LEATHER_BOOTS).setColor(Color.WHITE).setName("§7» §9Coming soon §7«").build());

                    inv.setItem(52, new ItemBuilder(Material.BARRIER).setName("§7» §cSpur löschen §7«").build());
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
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Spuren §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR)) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cSpur löschen §7«")){
                p.getInventory().setHelmet(null);
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.sendMessage(Main.prefix + "§7Du hast deine ausgewählte Spur gelöscht");
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Zurück §7«")) {
                p.closeInventory();
                Inventory inv = Bukkit.createInventory(null, 9*6, "§7» §aProfil §7«");

                for(int i = 0; i < 53; i++){
                    inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
                }

                inv.setItem(12, new ItemBuilder(Material.REDSTONE).setName("§7» §6Musik §7«").build());
                inv.setItem(14, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());
                inv.setItem(19, new ItemBuilder(Material.PLAYER_HEAD).setName("§7» §6Köpfe §7«").build());
                inv.setItem(25, new ItemBuilder(Material.PLAYER_HEAD).setOwner(p.getName()).setName("§7» §6Freunde §7«").build());
                inv.setItem(31, new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Kleiderschrank §7«").build());
                inv.setItem(38, new ItemBuilder(Material.CHEST).setName("§7» §6Gadgets §7«").build());
                inv.setItem(42, new ItemBuilder(Material.REDSTONE).setName("§7» §6Settings §7«").build());

                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Love §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Love-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Note §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Note-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Cloud §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Cloud-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Flame §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Flame-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Smoke §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Smoke-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Soulflame §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Soulflame-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Color §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Color-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Barrier §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", true);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", false);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §6Barrier-Spur §7ausgewählt");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Snow §7«")){
                SettingsFilebuilder.setArmor(p, "Spur", "Love", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Note", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Cloud", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Flame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Smoke", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Soulflame", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Color", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Barrier", false);
                SettingsFilebuilder.setArmor(p, "Spur", "Snow", true);
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                p.sendMessage(Main.prefix + "§7Du hast die §7Snow-Spur §7ausgewählt");
            }
        }
    }
}
