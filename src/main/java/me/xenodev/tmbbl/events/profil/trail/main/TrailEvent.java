package me.xenodev.tmbbl.events.profil.trail.main;

import me.xenodev.tmbbl.file.BuyFilebuilder;
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

                    if(BuyFilebuilder.getBuy(p, "loveboots").equals(true)){
                        inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Love-Boots §7«").setColor(Color.RED).setFlag(ItemFlag.HIDE_ATTRIBUTES).build());
                    }
                    if(BuyFilebuilder.getBuy(p, "noteboots").equals(true)){
                        inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Note-Boots §7«").setColor(Color.LIME).setFlag(ItemFlag.HIDE_ATTRIBUTES).build());
                    }
                    if(BuyFilebuilder.getBuy(p, "flameboots").equals(true)){
                        inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Flame-Boots §7«").setColor(Color.ORANGE).setFlag(ItemFlag.HIDE_ATTRIBUTES).build());
                    }
                    if(BuyFilebuilder.getBuy(p, "colorboots").equals(true)){
                        inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Color-Boots §7«").setLore("§oBoots von Ostern 2022").setColor(Color.YELLOW).setFlag(ItemFlag.HIDE_ATTRIBUTES).build());
                    }

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
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR) || e.getCurrentItem() == null) return;
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
                p.sendMessage(Main.prefix + "§cDu hast deine ausgewählte Spur gelöscht");
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
