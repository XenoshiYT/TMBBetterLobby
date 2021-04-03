package me.xenodev.tmbbl.events.lobby;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class WeatherEvent implements Listener {

    @EventHandler
    public void onWeather(WeatherChangeEvent e){
        World world = e.getWorld();
        world.setStorm(false);
        world.setThundering(false);
        e.setCancelled(true);
    }

}
