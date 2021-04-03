package me.xenodev.tmbbl.events.lobby;

import me.xenodev.tmbbl.commands.lobby.BuildCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildEvent implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(BuildCMD.build.contains(p)){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(BuildCMD.build.contains(p)){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

}
