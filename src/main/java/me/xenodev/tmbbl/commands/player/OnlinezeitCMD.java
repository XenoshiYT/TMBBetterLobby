package me.xenodev.tmbbl.commands.player;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.mysql.TimeSQL;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OnlinezeitCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("oz") || cmd.getName().equalsIgnoreCase("onlinezeit") || cmd.getName().equalsIgnoreCase("onlinetime") || cmd.getName().equalsIgnoreCase("ot")){
            if(args.length == 1){
                OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
                p.sendMessage("");
                p.sendMessage("§7----------» §e§lOnlinetimeinformationen §7«----------");
                p.sendMessage("");
                p.sendMessage(Main.prefix + "§7Die Onlinetime von §a§l" + t.getName() + "§7:");
                p.sendMessage("  §8§l» §7Stunden: §e" + TimeSQL.getHours(t.getUniqueId()));
                p.sendMessage("  §8§l» §7Minuten: §e" + TimeSQL.getMinutes(t.getUniqueId()));
                p.sendMessage("  §8§l» §7Sekunden: §e" + TimeSQL.getSeconds(t.getUniqueId()));
                p.sendMessage("");
                p.sendMessage("§7----------» §e§lOnlinetimeinformationen §7«----------");
                p.sendMessage("");
            }else{
                p.sendMessage("");
                p.sendMessage("§7----------» §e§lOnlinetimeinformationen §7«----------");
                p.sendMessage("");
                p.sendMessage(Main.prefix + "§7Die Onlinetime von §a§l" + "Dir" + "§7:");
                p.sendMessage("  §8§l» §7Stunden: §e" + TimeSQL.getHours(p.getUniqueId()));
                p.sendMessage("  §8§l» §7Minuten: §e" + TimeSQL.getMinutes(p.getUniqueId()));
                p.sendMessage("  §8§l» §7Sekunden: §e" + TimeSQL.getSeconds(p.getUniqueId()));
                p.sendMessage("");
                p.sendMessage("§7----------» §e§lOnlinetimeinformationen §7«----------");
                p.sendMessage("");
            }
        }
        return false;
    }
}
