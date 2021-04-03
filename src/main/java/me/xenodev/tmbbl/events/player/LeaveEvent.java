package me.xenodev.tmbbl.events.player;

import me.xenodev.tmbbl.events.profil.gadget.pvpschwert.PvPSchwertEvent;
import me.xenodev.tmbbl.utils.player.ScoreBoardDisplayBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();

        e.setQuitMessage("");
        ScoreBoardDisplayBuilder.timerdisplay.remove(p);
        PvPSchwertEvent.pvpschwert.remove(p);
        for(PotionEffect effect : p.getActivePotionEffects()){
            p.removePotionEffect(effect.getType());
        }
    }

}
