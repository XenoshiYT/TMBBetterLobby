package me.xenodev.tmbbl.file;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class EventFilebuilder {

    public static File file = new File("plugins//TMBLobby", "event.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setEvent(String event){
        cfg.set("Event", event);
        save();
    }

    public static String getEvent(){
        return cfg.getString("Event");
    }

    private static void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
