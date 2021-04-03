package me.xenodev.tmbbl.commands.lobby;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.player.StartItemBuilder;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BuildCMD implements CommandExecutor {


    public static ArrayList<Player> build = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        if(cmd.getName().equalsIgnoreCase("build")){
            if(p.hasPermission("tmb.build")){
                if(build.contains(p)){
                    build.remove(p);
                    p.sendMessage(Main.prefix + "§7Du hast den Buildingmodus §cverlassen");
                    p.setGameMode(GameMode.ADVENTURE);
                    p.getInventory().clear();
                    StartItemBuilder.setItem(p);
                }else{
                    build.add(p);
                    p.sendMessage(Main.prefix + "§7Du hast den Buildingmodus §cbetreten");
                    p.setGameMode(GameMode.CREATIVE);
                    p.getInventory().clear();
                }
            }else{
                p.sendMessage(Main.error + "§cDazu hast du keine Rechte");
            }
        }


        return false;
    }

}
