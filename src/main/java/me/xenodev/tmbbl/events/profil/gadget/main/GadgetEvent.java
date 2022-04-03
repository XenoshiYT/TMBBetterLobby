package me.xenodev.tmbbl.events.profil.gadget.main;

import me.xenodev.tmbbl.file.BuyFilebuilder;
import me.xenodev.tmbbl.file.EventFilebuilder;
import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.mysql.ByteSQL;
import me.xenodev.tmbbl.mysql.CoinSQL;
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

public class GadgetEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.CHEST)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Gadgets §7«")){
                    e.setCancelled(true);
                    setInv(p);
                }
            }
        }
    }

    @EventHandler
    public void onClickKleider(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Gadgets §7«" + "§7Coins: §6" + CoinSQL.getCoins(p.getUniqueId()) + " §8| §7Bytes: §6" + ByteSQL.getBytes(p.getUniqueId()))){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR) || e.getCurrentItem().getType().equals(Material.NETHER_STAR)) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §cGadget löschen §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                SettingsFilebuilder.setSetting(p, "Flugstab", false);
                SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                SettingsFilebuilder.setSetting(p, "Enderperle", false);
                p.sendMessage(Main.prefix + "§7Du hast dein ausgewähltes Gadget gelöscht");
                p.getInventory().setItem(6, new ItemBuilder(Material.BARRIER).setName("§7» §cKein Gadget ausgewählt §7«").build());
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
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Enterhaken §7«")){
                if(BuyFilebuilder.getBuy(p, "enterhaken").equals(true)){
                    SettingsFilebuilder.setSetting(p, "Enterhaken", true);
                    SettingsFilebuilder.setSetting(p, "Flugstab", false);
                    SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                    SettingsFilebuilder.setSetting(p, "Enderperle", false);
                    p.getInventory().setItem(6, new ItemBuilder(Material.FISHING_ROD).setName("§7» §9Enterhaken §7«").setUnbreakable().build());
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }else{
                    if(CoinSQL.getCoins(p.getUniqueId()) >= 2000){
                        p.sendMessage(Main.prefix + "§7Du hast dir das Gadget " + "§7» §9Enterhaken §7«" + " §7gekauft");
                        BuyFilebuilder.setBuy(p, "enterhaken", true);
                        CoinSQL.removeCoins(p.getUniqueId(), 2000);
                        setInv(p);
                    }
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Flugstab §7«")){
                if(BuyFilebuilder.getBuy(p, "flugstab").equals(true)){
                    SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                    SettingsFilebuilder.setSetting(p, "Flugstab", true);
                    SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                    SettingsFilebuilder.setSetting(p, "Enderperle", false);
                    p.getInventory().setItem(6, new ItemBuilder(Material.BLAZE_ROD).setName("§7» §9Flugstab §7«").build());
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }else{
                    if(CoinSQL.getCoins(p.getUniqueId()) >= 2500){
                        p.sendMessage(Main.prefix + "§7Du hast dir das Gadget " + "§7» §9Flugstab §7«" + " §7gekauft");
                        BuyFilebuilder.setBuy(p, "flugstab", true);
                        CoinSQL.removeCoins(p.getUniqueId(), 2500);
                        setInv(p);
                    }
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eggbomb §7«")){
                if(BuyFilebuilder.getBuy(p, "eggbomb").equals(true)){
                    SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                    SettingsFilebuilder.setSetting(p, "Flugstab", false);
                    SettingsFilebuilder.setSetting(p, "Eggbomb", true);
                    SettingsFilebuilder.setSetting(p, "Enderperle", false);
                    p.getInventory().setItem(6, new ItemBuilder(Material.EGG).setName("§7» §9Eggbomb §7«").build());
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }else{
                    if(ByteSQL.getBytes(p.getUniqueId()) >= 40){
                        p.sendMessage(Main.prefix + "§7Du hast dir das Gadget " + "§7» §9Eggbomb §7«" + " §7gekauft");
                        BuyFilebuilder.setBuy(p, "eggbomb", true);
                        CoinSQL.removeCoins(p.getUniqueId(), 40);
                        setInv(p);
                    }
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Enderperle §7«")){
                SettingsFilebuilder.setSetting(p, "Enterhaken", false);
                SettingsFilebuilder.setSetting(p, "Flugstab", false);
                SettingsFilebuilder.setSetting(p, "Eggbomb", false);
                SettingsFilebuilder.setSetting(p, "Enderperle", true);
                p.getInventory().setItem(6, new ItemBuilder(Material.ENDER_PEARL).setName("§7» §9Enderperle §7«").build());
                p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
            }
        }
    }

    private void setInv(Player p){
        p.closeInventory();
        Inventory inv = Bukkit.createInventory(null, 9*4, "§7» §6Gadgets §7«" + "§7Coins: §6" + CoinSQL.getCoins(p.getUniqueId()) + " §8| §7Bytes: §6" + ByteSQL.getBytes(p.getUniqueId()));

        for(int i = 18; i < 27; i++){
            inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
        }

        inv.setItem(0, new ItemBuilder(Material.ENDER_PEARL).setName("§7» §6Enderperle §7«").build());
        if(BuyFilebuilder.getBuy(p, "enterhaken").equals(true)){
            inv.setItem(1, new ItemBuilder(Material.FISHING_ROD).setName("§7» §6Enterhaken §7«").build());
        }else{
            inv.setItem(1, new ItemBuilder(Material.FISHING_ROD).setName("§7» §6Enterhaken §7«").setEnchantment(Enchantment.CHANNELING, 1).setLore("§7Gadgetkosten: §62000 §7Coins").build());
        }
        if(BuyFilebuilder.getBuy(p, "flugstab").equals(true)){
            inv.setItem(2, new ItemBuilder(Material.BLAZE_ROD).setName("§7» §6Flugstab §7«").build());
        }else{
            inv.setItem(2, new ItemBuilder(Material.BLAZE_ROD).setName("§7» §6Flugstab §7«").setEnchantment(Enchantment.CHANNELING, 1).setLore("§7Gadgetkosten: §62500 §7Coins").build());
        }
        if(BuyFilebuilder.getBuy(p, "eggbomb").equals(true)){
            inv.setItem(3, new ItemBuilder(Material.PLAYER_HEAD).setOwnerURL("http://textures.minecraft.net/texture/3ed037452223bda1381a17c3daafa71baac6ed8aa3a71ae36163cfeb61227b47").setName("§7» §6Eggbomb §7«").setLore("§5EasterEgg-Gadget von Ostern 2021").build());
        }else{
            if(EventFilebuilder.getEvent().equalsIgnoreCase("easter")) {
                inv.setItem(3, new ItemBuilder(Material.PLAYER_HEAD).setOwnerURL("http://textures.minecraft.net/texture/badc048a7ce78f7dad72a07da27d85c0916881e5522eeed1e3daf217a38c1a").setName("§7» §9Was ist das wohl? §7«").setEnchantment(Enchantment.CHANNELING, 1).setLore("§5EasterEgg-Gadget von Ostern 2021", "", "§7Gadgetkosten: §640 §7Bytes").build());
            }
        }
        inv.setItem(27, new ItemBuilder(Material.NETHER_STAR).setName("§7» §7Coins: §6 " + CoinSQL.getCoins(p.getUniqueId()) + " §8| §7Bytes: §6" + ByteSQL.getBytes(p.getUniqueId()) + "§7«").build());
        inv.setItem(34, new ItemBuilder(Material.BARRIER).setName("§7» §cGadget löschen §7«").build());
        inv.setItem(35, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

        p.openInventory(inv);
        p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
    }
}
