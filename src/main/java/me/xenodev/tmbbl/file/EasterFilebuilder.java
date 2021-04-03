package me.xenodev.tmbbl.file;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class EasterFilebuilder {

    public static File file = new File("plugins//TMBLobby", "eggs.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setEggs(Player p, Integer amount) {
        cfg.set(p.getUniqueId() + ".Eggs", amount);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addEggs(Player p, Integer amount) {
        setEggs(p, amount + 1);
    }

    public static Integer getEggs(Player p) {
        return cfg.getInt(p.getUniqueId() + ".Eggs");
    }

    public static void setMaxEggs(Integer amount) {
        cfg.set("MaxEggs", amount);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer getMaxEggs() {
        return cfg.getInt("MaxEggs");
    }
}
