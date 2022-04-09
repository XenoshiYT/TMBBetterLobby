package me.xenodev.tmbbl.commands.specialevents.main;

import me.xenodev.tmbbl.file.EventFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.player.StartItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class EventCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("event")){
            if(p.hasPermission("tmb.event.admin")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("easter")) {
                        EventFilebuilder.setEvent("easter");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.kickPlayer("§7Die Lobby hat nun das Event §aEaster §7gesetzt");
                        }
                        Main.instance.getServer().shutdown();
                    } else if (args[0].equalsIgnoreCase("halloween")) {
                        EventFilebuilder.setEvent("halloween");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.kickPlayer("§7Die Lobby hat nun das Event §6Halloween §7gesetzt");
                        }
                        Main.instance.getServer().shutdown();
                    } else if (args[0].equalsIgnoreCase("christmas")) {
                        EventFilebuilder.setEvent("christmas");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.kickPlayer("§7Die Lobby hat nun das Event §bChristmas §7gesetzt");
                        }
                        Main.instance.getServer().shutdown();
                    } else if (args[0].equalsIgnoreCase("newyear")) {
                        EventFilebuilder.setEvent("newyear");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.kickPlayer("§7Die Lobby hat nun das Event §cNew Year §7gesetzt");
                        }
                        Main.instance.getServer().shutdown();
                    } else if (args[0].equalsIgnoreCase("none")) {
                        EventFilebuilder.setEvent("none");
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.kickPlayer("§7Die Lobby hat nun kein Event mehr gesetzt");
                        }
                        Main.instance.getServer().shutdown();
                    } else {
                        p.sendMessage(Main.error + "§cDieses Event gibt es nicht");
                        p.sendMessage(Main.prefix + "§7Benutze /event <easter,halloween,christmas,newyear,none>");
                    }
                } else {
                    p.sendMessage(Main.prefix + "§7Benutze /event <easter,halloween,christmas,newyear,none>");
                }
            }else{
                p.sendMessage(Main.error + "§cDazu hast du keine Rechte");
            }
        }


        return false;
    }
}
