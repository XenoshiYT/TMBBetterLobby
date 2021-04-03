package me.xenodev.tmbbl.events.profil.hide;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HiderEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("§7» §aProfil §7«")) {
            if(e.getCurrentItem().getType().equals(Material.TOTEM_OF_UNDYING)){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §6Verstecker §7«")){
                    e.setCancelled(true);
                    if(SettingsFilebuilder.getSetting(p, "Hide").equals(true)) {
                        SettingsFilebuilder.setSetting(p, "Hide", false);
                        p.sendMessage(Main.prefix + "§7Du siehst nun §aalle §7Spieler wieder");
                        for(Player all : Bukkit.getOnlinePlayers()){
                            p.showPlayer(Main.instance, all);
                        }
                        p.closeInventory();
                    }else if(SettingsFilebuilder.getSetting(p, "Hide").equals(false)){
                        SettingsFilebuilder.setSetting(p, "Hide", true);
                        p.sendMessage(Main.prefix + "§7Du siehst nun §ckeine §7Spieler mehr");
                        for(Player all : Bukkit.getOnlinePlayers()){
                            p.hidePlayer(Main.instance, all);
                        }
                        p.closeInventory();
                    }
                    p.playSound(p.getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10f, 100f);
                }
            }
        }
    }

}
