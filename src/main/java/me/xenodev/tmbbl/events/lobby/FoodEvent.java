package me.xenodev.tmbbl.events.lobby;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        Player p = (Player) e.getEntity();
        p.setFoodLevel(20);
        p.setSaturation(20);
        e.setCancelled(true);
    }

}
