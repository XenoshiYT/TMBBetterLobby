package me.xenodev.tmbbl.file;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SettingsFilebuilder {

    public static File file = new File("plugins//TMBLobby", "settings.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public static void setSetting(Player p, String setting, Boolean bool){
        cfg.set(p.getUniqueId() + "." + setting, bool);
        save();
    }

    public static Boolean getSetting(Player p, String setting){
        return cfg.getBoolean(p.getUniqueId() + "." + setting);
    }

    public static void setArmor(Player p, String setting, String armor, Boolean bool){
        cfg.set(p.getUniqueId() + "." + setting + "." + armor, bool);
        save();
    }

    public static Boolean getArmor(Player p, String setting, String armor){
        return cfg.getBoolean(p.getUniqueId() + "." + setting + "." + armor);
    }

    private static void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
