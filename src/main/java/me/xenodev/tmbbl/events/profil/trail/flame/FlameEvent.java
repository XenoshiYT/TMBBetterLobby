package me.xenodev.tmbbl.events.profil.trail.flame;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FlameEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (SettingsFilebuilder.getArmor(p, "Spur", "Flame").equals(true)) {
            p.getWorld().playEffect(p.getLocation().add(0, 0.25, 0), Effect.MOBSPAWNER_FLAMES, 1);
        }
    }
}
