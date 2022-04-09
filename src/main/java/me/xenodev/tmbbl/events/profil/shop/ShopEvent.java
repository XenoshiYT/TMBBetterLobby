package me.xenodev.tmbbl.events.profil.shop;

import me.xenodev.tmbbl.file.BuyFilebuilder;
import me.xenodev.tmbbl.file.EventFilebuilder;
import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.mysql.ByteSQL;
import me.xenodev.tmbbl.mysql.CoinSQL;
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

public class ShopEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.ENDER_CHEST)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Shop §7«")){
                    e.setCancelled(true);
                    openInv(p, "normal");
                }
            }
        }
    }

    @EventHandler
    public void onClickKleider(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase("§7» §6Shop §7«")){
            e.setCancelled(true);
            if(e.getCurrentItem().getType().equals(Material.BLACK_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.GREEN_STAINED_GLASS_PANE) || e.getCurrentItem().getType().equals(Material.AIR) || e.getCurrentItem().getItemMeta() == null) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Gatgets §7«")){
                openInv(p, "gatgets");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Spuren §7«")){
                openInv(p, "spuren");
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Extras §7«")){
                openInv(p, "extras");
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
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Enderperle §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 1000){
                    CoinSQL.removeCoins(p.getUniqueId(), 1000);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "enderperl", true);
                    openInv(p, "gatgets");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Enterhaken §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 2000){
                    CoinSQL.removeCoins(p.getUniqueId(), 2000);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "enterhaken", true);
                    openInv(p, "gatgets");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Flugstab §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 3000){
                    CoinSQL.removeCoins(p.getUniqueId(), 3000);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "flugstab", true);
                    openInv(p, "gatgets");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Eggbomb §7«")){
                if(ByteSQL.getBytes(p.getUniqueId()) >= 50){
                    ByteSQL.removeBytes(p.getUniqueId(), 50);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "eggbomb", true);
                    openInv(p, "gatgets");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Bytes um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Switch Bow §7«")){
                if(ByteSQL.getBytes(p.getUniqueId()) >= 75){
                    ByteSQL.removeBytes(p.getUniqueId(), 75);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "switchbow", true);
                    openInv(p, "gatgets");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Bytes um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Love-Boots §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 250){
                    CoinSQL.removeCoins(p.getUniqueId(), 250);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "loveboots", true);
                    openInv(p, "spuren");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Note-Boots §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 250){
                    CoinSQL.removeCoins(p.getUniqueId(), 250);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "noteboots", true);
                    openInv(p, "spuren");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Flame-Boots §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 250){
                    CoinSQL.removeCoins(p.getUniqueId(), 250);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "flameboots", true);
                    openInv(p, "spuren");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Color-Boots §7«")){
                if(ByteSQL.getBytes(p.getUniqueId()) >= 5){
                    ByteSQL.removeBytes(p.getUniqueId(), 5);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "colorboots", true);
                    openInv(p, "spuren");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Bytes um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Kleiderschrank §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 500){
                    CoinSQL.removeCoins(p.getUniqueId(), 500);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "kleiderschrank", true);
                    openInv(p, "extras");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Köpfe §7«")){
                if(CoinSQL.getCoins(p.getUniqueId()) >= 750){
                    CoinSQL.removeCoins(p.getUniqueId(), 750);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                    BuyFilebuilder.setBuy(p, "köpfe", true);
                    openInv(p, "extras");
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Coins um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Bytes -> Coins §7«")){
                if(ByteSQL.getBytes(p.getUniqueId()) >= 1){
                    ByteSQL.removeBytes(p.getUniqueId(), 1);
                    CoinSQL.addCoins(p.getUniqueId(), 1000);
                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10f, 100f);
                }else{
                    p.sendMessage(Main.prefix + "§cDu hast nicht genügend Bytes um dies zu kaufen");
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 10f, 100f);
                }
            }
        }
    }

    private void openInv(Player p, String invname){
        if(invname.equalsIgnoreCase("gatgets")){
            p.closeInventory();

            Inventory inv = Bukkit.createInventory(null, 9*5, "§7» §6Shop §7«");

            for(int i = 0; i < 44; i++){
                inv.setItem(i, new ItemBuilder(Material.AIR).build());
            }

            for(int i = 27; i < 36; i++){
                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            }

            inv.setItem(1, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
            inv.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            inv.setItem(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());

            inv.setItem(0, new ItemBuilder(Material.CHEST).setName("§7» §6Gatgets §7«").build());
            inv.setItem(9, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());
            inv.setItem(18, new ItemBuilder(Material.BEACON).setName("§7» §6Extras §7«").build());

            if(BuyFilebuilder.getBuy(p, "enderperl").equals(false)){
                inv.addItem(new ItemBuilder(Material.ENDER_PEARL).setName("§7» §6Enderperle §7«").setLore("§7Die §6Enderperle §7kostet §c1000 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
            }
            if(BuyFilebuilder.getBuy(p, "enterhaken").equals(false)){
                inv.addItem(new ItemBuilder(Material.FISHING_ROD).setName("§7» §6Enterhaken §7«").setLore("§7Die §6Enterhaken §7kostet §c2000 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
            }
            if(BuyFilebuilder.getBuy(p, "flugstab").equals(false)){
                inv.addItem(new ItemBuilder(Material.BLAZE_ROD).setName("§7» §6Flugstab §7«").setLore("§7Die §6Flugstab §7kostet §c3000 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
            }
            if(BuyFilebuilder.getBuy(p, "eggbomb").equals(false)){
                inv.addItem(new ItemBuilder(Material.PLAYER_HEAD).setName("§7» §6Eggbomb §7«").setLore("§7Die §6Eggbomb §7kostet §c50 §7Bytes", "", "§oGatget von Ostern 2021").setOwnerURL("http://textures.minecraft.net/texture/3ed037452223bda1381a17c3daafa71baac6ed8aa3a71ae36163cfeb61227b47").build());
            }
            if(BuyFilebuilder.getBuy(p, "switchbow").equals(false)){
                if(EventFilebuilder.getEvent().equalsIgnoreCase("easter")) {
                    inv.addItem(new ItemBuilder(Material.BOW).setName("§7» §6Switch Bow §7«").setLore("§7Der §6Switch Bow §7kostet §c75 §7Bytes", "", "§oGatget von Ostern 2022").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
                }else{
                    inv.addItem(new ItemBuilder(Material.PLAYER_HEAD).setName("§7» §cWas ist das wohl? §7«").setOwnerURL("http://textures.minecraft.net/texture/badc048a7ce78f7dad72a07da27d85c0916881e5522eeed1e3daf217a38c1a").build());
                }
            }

            inv.setItem(36, new ItemBuilder(Material.NETHER_STAR).setName("§7» §7Coins: §6" + CoinSQL.getCoins(p.getUniqueId()) + " §8| §7Bytes: §6" + ByteSQL.getBytes(p.getUniqueId()) + " §7«").build());
            inv.setItem(44, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

            p.openInventory(inv);
            p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
        }else if(invname.equalsIgnoreCase("spuren")){
            p.closeInventory();

            Inventory inv = Bukkit.createInventory(null, 9*5, "§7» §6Shop §7«");

            for(int i = 0; i < 44; i++){
                inv.setItem(i, new ItemBuilder(Material.AIR).build());
            }

            for(int i = 27; i < 36; i++){
                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            }

            inv.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            inv.setItem(10, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());
            inv.setItem(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());

            inv.setItem(0, new ItemBuilder(Material.CHEST).setName("§7» §6Gatgets §7«").build());
            inv.setItem(9, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());
            inv.setItem(18, new ItemBuilder(Material.BEACON).setName("§7» §6Extras §7«").build());

            if(BuyFilebuilder.getBuy(p, "loveboots").equals(false)){
                inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Love-Boots §7«").setLore("§7Die §6Love-Booots §7kosten §c250 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).setFlag(ItemFlag.HIDE_ATTRIBUTES).setColor(Color.RED).build());
            }
            if(BuyFilebuilder.getBuy(p, "noteboots").equals(false)){
                inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Note-Boots §7«").setLore("§7Die §6Note-Booots §7kosten §c250 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).setFlag(ItemFlag.HIDE_ATTRIBUTES).setColor(Color.LIME).build());
            }
            if(BuyFilebuilder.getBuy(p, "flameboots").equals(false)){
                inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Flame-Boots §7«").setLore("§7Die §6Flame-Booots §7kosten §c250 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).setFlag(ItemFlag.HIDE_ATTRIBUTES).setColor(Color.ORANGE).build());
            }
            if(BuyFilebuilder.getBuy(p, "colorboots").equals(false)){
                if(EventFilebuilder.getEvent().equalsIgnoreCase("easter")) {
                    inv.addItem(new ItemBuilder(Material.LEATHER_BOOTS).setName("§7» §6Color-Boots §7«").setLore("§7Die §6Color-Booots §7kosten §c5 §7Bytes", "", "§oBoots von Ostern 2022").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).setFlag(ItemFlag.HIDE_ATTRIBUTES).setColor(Color.YELLOW).build());
                }else{
                    inv.addItem(new ItemBuilder(Material.PLAYER_HEAD).setName("§7» §cWas ist das wohl? §7«").setOwnerURL("http://textures.minecraft.net/texture/badc048a7ce78f7dad72a07da27d85c0916881e5522eeed1e3daf217a38c1a").build());
                }
            }

            inv.setItem(36, new ItemBuilder(Material.NETHER_STAR).setName("§7» §7Coins: §6" + CoinSQL.getCoins(p.getUniqueId()) + " §8| §7Bytes: §6" + ByteSQL.getBytes(p.getUniqueId()) + " §7«").build());
            inv.setItem(44, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

            p.openInventory(inv);
            p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
        }else if(invname.equalsIgnoreCase("extras")){
            p.closeInventory();
            Inventory inv = Bukkit.createInventory(null, 9*5, "§7» §6Shop §7«");

            for(int i = 0; i < 44; i++){
                inv.setItem(i, new ItemBuilder(Material.AIR).build());
            }

            for(int i = 27; i < 36; i++){
                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            }

            inv.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            inv.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            inv.setItem(19, new ItemBuilder(Material.GREEN_STAINED_GLASS_PANE).build());

            inv.setItem(0, new ItemBuilder(Material.CHEST).setName("§7» §6Gatgets §7«").build());
            inv.setItem(9, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());
            inv.setItem(18, new ItemBuilder(Material.BEACON).setName("§7» §6Extras §7«").build());

            if(BuyFilebuilder.getBuy(p, "kleiderschrank").equals(false)){
                inv.addItem(new ItemBuilder(Material.NETHERITE_CHESTPLATE).setName("§7» §6Kleiderschrank §7«").setLore("§7Der §6Kleiderschrank §7kostet §c500 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).setFlag(ItemFlag.HIDE_ATTRIBUTES).build());
            }
            if(BuyFilebuilder.getBuy(p, "köpfe").equals(false)){
                inv.addItem(new ItemBuilder(Material.PLAYER_HEAD).setOwnerURL("http://textures.minecraft.net/texture/9d4c9997ad46fdf900720c189720977fdee3742ab9ae9ffb00e5af9417d0454e").setName("§7» §6Köpfe §7«").setLore("§7Die §6Köpfe §7kosten §c750 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());
            }
            inv.addItem(new ItemBuilder(Material.EMERALD).setName("§7» §6Bytes -> Coins §7«").setLore("§7Wechsle §61 §7Byte zu §c1000 §7Coins").setEnchantment(Enchantment.CHANNELING, 1).setFlag(ItemFlag.HIDE_ENCHANTS).build());

            inv.setItem(36, new ItemBuilder(Material.NETHER_STAR).setName("§7» §7Coins: §6" + CoinSQL.getCoins(p.getUniqueId()) + " §8| §7Bytes: §6" + ByteSQL.getBytes(p.getUniqueId()) + " §7«").build());
            inv.setItem(44, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

            p.openInventory(inv);
            p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
        }else if(invname.equalsIgnoreCase("normal")){
            p.closeInventory();
            Inventory inv = Bukkit.createInventory(null, 9*5, "§7» §6Shop §7«");

            for(int i = 0; i < 44; i++){
                inv.setItem(i, new ItemBuilder(Material.AIR).build());
            }

            for(int i = 27; i < 36; i++){
                inv.setItem(i, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            }

            inv.setItem(1, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            inv.setItem(10, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());
            inv.setItem(19, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).build());

            inv.setItem(0, new ItemBuilder(Material.CHEST).setName("§7» §6Gatgets §7«").build());
            inv.setItem(9, new ItemBuilder(Material.GOLDEN_BOOTS).setName("§7» §6Spuren §7«").build());
            inv.setItem(18, new ItemBuilder(Material.BEACON).setName("§7» §6Extras §7«").build());

            inv.setItem(36, new ItemBuilder(Material.NETHER_STAR).setName("§7» §7Coins: §6" + CoinSQL.getCoins(p.getUniqueId()) + " §8| §7Bytes: §6" + ByteSQL.getBytes(p.getUniqueId()) + " §7«").build());
            inv.setItem(44, new ItemBuilder(Material.ARROW).setName("§7» §6Zurück §7«").build());

            p.openInventory(inv);
            p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
        }
    }

}
