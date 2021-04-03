package me.xenodev.tmbbl.events.player;

import me.xenodev.tmbbl.file.LocationFilebuilder;
import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.mysql.TimeSQL;
import me.xenodev.tmbbl.utils.player.ScoreBoardBuilder;
import me.xenodev.tmbbl.utils.player.ScoreBoardDisplayBuilder;
import me.xenodev.tmbbl.utils.player.StartItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
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
        ScoreBoardBuilder.setScoreboard(p);
        ScoreBoardDisplayBuilder.timerdisplay.put(p, 0);

        Location loc = LocationFilebuilder.getLocation("Spawn");
        p.teleport(loc);

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
        p.setMaxHealth(6);
        p.setHealth(6);
    }

}
