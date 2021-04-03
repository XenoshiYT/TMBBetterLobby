package me.xenodev.tmbbl.commands.player;

import me.xenodev.tmbbl.file.StatsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.mysql.TimeSQL;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("stats")){
            if(args.length > 2){
                if(args[0].equalsIgnoreCase("set")){
                    if(p.hasPermission("tmb.stats.set")){
                        if(args[1].equalsIgnoreCase("kills")){
                            Integer amount = Integer.valueOf(args[2]);
                            StatsFilebuilder.setKills(p, amount);
                            p.sendMessage(Main.prefix + "§7Kills wurden gesetzt");
                        }else if(args[1].equalsIgnoreCase("deaths")){
                            Integer amount = Integer.valueOf(args[2]);
                            StatsFilebuilder.setDeaths(p, amount);
                            p.sendMessage(Main.prefix + "§7Deaths wurden gesetzt");
                        }else if(args[1].equalsIgnoreCase("streak")){
                            Integer amount = Integer.valueOf(args[2]);
                            StatsFilebuilder.setStreak(p, amount);
                            p.sendMessage(Main.prefix + "§7Streak wurden gesetzt");
                        }
                    }
                }
            }else if(args.length == 1){
                if(args[0].equalsIgnoreCase("reset")){
                    StatsFilebuilder.resetStreak(p);
                    StatsFilebuilder.resetDeaths(p);
                    StatsFilebuilder.resetKills(p);
                    p.sendMessage(Main.prefix + "§7Du hast deine PvPSchwert-Stats zurückgesetzt");
                }else{
                    OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
                    p.sendMessage("");
                    p.sendMessage("§7----------» §e§lStatsinformationen §7«----------");
                    p.sendMessage("");
                    p.sendMessage(Main.prefix + "§7Die Stats von §a§l" + t.getName() + "§7:");
                    p.sendMessage("  §8§l» §7Kills: §e" + StatsFilebuilder.getKills(t));
                    p.sendMessage("  §8§l» §7Deaths: §e" + StatsFilebuilder.getDeaths(t));
                    p.sendMessage("  §8§l» §7Streak: §e" + StatsFilebuilder.getStreak(t));
                    p.sendMessage("");
                    p.sendMessage("§7----------» §e§lStatsinformationen §7«----------");
                    p.sendMessage("");
                }
            }else{
                p.sendMessage("");
                p.sendMessage("§7----------» §e§lStatsinformationen §7«----------");
                p.sendMessage("");
                p.sendMessage(Main.prefix + "§7Die Stats von §a§l" + "Dir" + "§7:");
                p.sendMessage("  §8§l» §7Kills: §e" + StatsFilebuilder.getKills(p));
                p.sendMessage("  §8§l» §7Deaths: §e" + StatsFilebuilder.getDeaths(p));
                p.sendMessage("  §8§l» §7Streak: §e" + StatsFilebuilder.getStreak(p));
                p.sendMessage("");
                p.sendMessage("§7----------» §e§lStatsinformationen §7«----------");
                p.sendMessage("");
            }
        }
        return false;
    }
}
