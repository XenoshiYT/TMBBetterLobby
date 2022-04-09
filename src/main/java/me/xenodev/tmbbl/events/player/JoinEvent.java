package me.xenodev.tmbbl.events.player;

import me.xenodev.tmbbl.commands.specialevents.main.EventCMD;
import me.xenodev.tmbbl.file.EventFilebuilder;
import me.xenodev.tmbbl.file.LocationFilebuilder;
import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.mysql.PlayerSQL;
import me.xenodev.tmbbl.mysql.TimeSQL;
import me.xenodev.tmbbl.utils.player.ScoreBoardBuilder;
import me.xenodev.tmbbl.utils.player.ScoreBoardDisplayBuilder;
import me.xenodev.tmbbl.utils.player.StartItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        p.sendMessage("§8§l―――――――――― §5§lT§deam§5§lM§dega§5§lB§dyte §8§l――――――――――");
        p.sendMessage(" §e§lWillkommen auf dem Bauserver");
        p.sendMessage(" §8§l― §7Teamspeak: §aclan-tmb.de");
        p.sendMessage(" §8§l― §7Discord: §bdiscord.gg/Q4YQ6xQ5qJ");
        p.sendMessage(" §8§l― §7Youtube: §cTeamMegaByte");
        p.sendMessage("§8§l―――――――――― §5§lT§deam§5§lM§dega§5§lB§dyte §8§l――――――――――");

        TimeSQL.createPlayer(p.getUniqueId());
        PlayerSQL.createPlayer(p);
        ScoreBoardBuilder.setScoreboard(p);
        ScoreBoardDisplayBuilder.timerdisplay.put(p, 0);

        if(LocationFilebuilder.cfg.getString("Spawn.World") != null){
            Location loc = LocationFilebuilder.getLocation("Spawn");
            p.teleport(loc);
        }else{
            p.sendMessage(Main.prefix + " §4§lDer Spawn wurde noch nicht gesetzt! Bitte den Spawn setzten mit /spawn set");
        }

        StartItemBuilder.setItem(p);
        for(Player all : Bukkit.getOnlinePlayers()){
            if(SettingsFilebuilder.getSetting(all, "Hide").equals(true)){
                all.hidePlayer(Main.instance, p);
            }else{
                all.showPlayer(Main.instance, p);
            }

            if(SettingsFilebuilder.getSetting(p, "Hide").equals(true)){
                p.hidePlayer(Main.instance, all);
            }else{
                p.showPlayer(Main.instance, all);
            }
        }
        p.setMaxHealth(6);
        p.setHealth(6);
        p.setFoodLevel(40);
        e.setJoinMessage("");
        p.setGameMode(GameMode.ADVENTURE);
        p.setLevel(2022);
        if(EventFilebuilder.getEvent().equalsIgnoreCase("easter")){
            p.sendTitle("§aFrohe Ostern,", "§e§l" + p.getName() + "§7!", 30, 90, 30);
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_WAIT, 1f, 1f);
        }else if(EventFilebuilder.getEvent().equalsIgnoreCase("halloween")){
            p.sendTitle("§6Happy Halloween,", "§e§l" + p.getName() + "§7!", 30, 90, 30);
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_WARD, 1f, 1f);
        }else if(EventFilebuilder.getEvent().equalsIgnoreCase("christmas")){
            p.sendTitle("§bFrohe Weihnachten,", "§e§l" + p.getName() + "§7!", 30, 90, 30);
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_FAR, 1f, 1f);
        }else if(EventFilebuilder.getEvent().equalsIgnoreCase("newyear")){
            p.sendTitle("§cFrohes neues Jahr,", "§e§l" + p.getName() + "§7!", 30, 90, 30);
            p.playSound(p.getLocation(), Sound.MUSIC_DISC_STRAD, 1f, 1f);
        }else if(EventFilebuilder.getEvent().equalsIgnoreCase("none")){
            p.sendTitle("§7Guten Tag,", "§e§l" + p.getName() + "§7!", 30, 90, 30);
        }
    }
}
