package me.xenodev.tmbbl.file;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class BuyFilebuilder {

    public static File file = new File("plugins//TMBLobby", "buys.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setBuy(Player p, String label, Boolean bool){
        cfg.set(p.getUniqueId().toString() + "." + label, bool);
        save();
    }

    public static Boolean getBuy(Player p, String label){
        return cfg.getBoolean(p.getUniqueId().toString() + "." + label);
    }

    private static void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
