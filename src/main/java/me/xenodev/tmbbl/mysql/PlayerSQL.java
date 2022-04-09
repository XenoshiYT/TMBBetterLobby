package me.xenodev.tmbbl.mysql;

import me.xenodev.tmbbl.main.Main;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerSQL {

    public static boolean playerExists(UUID uuid){

        try{
            ResultSet rs = Main.mysql.query("SELECT * FROM Players WHERE UUID= '" + uuid + "'");
            if(rs.next()){
                return rs.getString("UUID") != null;
            }
            return false;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(Player p){

        if(!(playerExists(p.getUniqueId()))){
            Main.mysql.update("INSERT INTO Players(UUID, NAME) VALUES ('" + p.getUniqueId() + "', '" + p.getName() + "');");
        }else{
            setName(p);
        }
    }


    public static String getName(UUID uuid){
        String i = null;

        if(playerExists(uuid)){
            try{
                ResultSet rs = Main.mysql.query("SELECT * FROM Players WHERE UUID= '" + uuid + "'");
                if((!rs.next()) || (rs.getString("NAME") == null));
                i = rs.getString("NAME");
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }

        return i;
    }

    public static void setName(Player p){
        if(playerExists(p.getUniqueId())){
            Main.mysql.update("UPDATE Players SET NAME= '" + p.getName() + "' WHERE UUID= '" + p.getUniqueId() + "';");
        }else{
            createPlayer(p);
            setName(p);
        }
    }
}
