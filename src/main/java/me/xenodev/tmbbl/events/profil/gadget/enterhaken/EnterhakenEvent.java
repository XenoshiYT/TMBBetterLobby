package me.xenodev.tmbbl.events.profil.gadget.enterhaken;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class EnterhakenEvent implements Listener {

    @EventHandler
    public void onPlayerFish(PlayerFishEvent e) {
        Player p = e.getPlayer();
        FishHook h = e.getHook();

        if((e.getState().equals(PlayerFishEvent.State.IN_GROUND)
                || (e.getState().equals(PlayerFishEvent.State.CAUGHT_ENTITY)
                || (e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT)))
                && (Bukkit.getWorld(p.getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.AIR))){
            Location lc = p.getLocation();
            Location to = h.getLocation();

            lc.setY(lc.getY() + 0.5D);
            p.teleport(lc);

            double g = -0.08D;
            double d = to.distance(lc);
            double t = d;
            double v_x = (1.0D + 0.07D * t) * (to.getX() - lc.getX()) / t;
            double v_y = (1.0D + 0.03D * t) * (to.getY() - lc.getY()) / t - 0.5D * g * t;
            double v_z = (1.0D + 0.07D * t) * (to.getZ() - lc.getZ()) / t;
            Vector v = p.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            p.setVelocity(v);
        }
    }

}
