package me.xenodev.tmbbl.commands.lobby;

import me.xenodev.tmbbl.file.LocationFilebuilder;
import me.xenodev.tmbbl.main.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("spawn")){
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("set")){
                    if(p.hasPermission("tmb.setspawn")){
                        LocationFilebuilder.setLocation("Spawn", p.getLocation());
                        p.sendMessage(Main.prefix + "§7Du hast den §6Spawn §7gesetzt");
                    }else{
                        p.sendMessage(Main.error + "§cDazu hast du keine Rechte");
                    }
                }
            }else{
                Location loc = LocationFilebuilder.getLocation("Spawn");
                p.teleport(loc);
                p.sendMessage(Main.prefix + "§7Du hast dich zum §6Spawn §7teleportiert");
            }
        }


        return false;
    }

}
