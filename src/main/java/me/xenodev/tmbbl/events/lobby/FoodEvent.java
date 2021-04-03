package me.xenodev.tmbbl.events.lobby;

import me.xenodev.tmbbl.events.profil.gadget.pvpschwert.PvPSchwertEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodEvent implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        Player p = (Player) e.getEntity();
        if(PvPSchwertEvent.pvpschwert.contains(p)){
            p.setSaturation(0);
            e.setCancelled(false);
        }else{
            p.setFoodLevel(20);
            p.setSaturation(20);
            e.setCancelled(true);
        }
    }

}
