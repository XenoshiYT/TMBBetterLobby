package me.xenodev.tmbbl.commands.specialevents.winter;

import me.xenodev.tmbbl.file.EasterFilebuilder;
import me.xenodev.tmbbl.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EasterCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        // /easter name - fragt eier ab
        // /easter name/max amount - setzt eier/setzt die maximalen eier
        
        if (cmd.getName().equalsIgnoreCase("easter")) {
            if (args.length == 2) {
                if (args[0].equalsIgnoreCase("max")) {
                    Integer amount = Integer.valueOf(args[1]);
                    EasterFilebuilder.setMaxEggs(amount);
                    sender.sendMessage(Main.prefix + "§aDu hast die maximalen Ostereier auf§e§l " + amount + "§a gesetzt");
                }else {
                    if (!(sender instanceof Player)) {
                        Player t = Bukkit.getPlayerExact(args[0]);
                        Integer amount = Integer.valueOf(args[1]);
                        EasterFilebuilder.addEggs(t, amount);

                        Integer current = EasterFilebuilder.getEggs(t);
                        Integer max = EasterFilebuilder.getMaxEggs();
                        t.sendMessage(Main.prefix + "§7Du hast §e" + current + " §7von §e" + max + " §aOstereier §7gefunden");
                    } else {
                        sender.sendMessage(Main.error + "§cDu darfst den Command als Spieler nicht benutzen");
                    }
                }
            } else if (args.length == 1) {
                if (!(sender instanceof Player)) {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    Integer current = EasterFilebuilder.getEggs(t);
                    Integer max = EasterFilebuilder.getMaxEggs();
                    t.sendMessage(Main.prefix + "§7Du hast §e" + current + " §7von §e" + max + " §aOstereier §7gefunden");
                } else {
                    sender.sendMessage(Main.error + "§cDu darfst den Command als Spieler nicht benutzen");
                }
            }
        }
        return false;
    }
}
