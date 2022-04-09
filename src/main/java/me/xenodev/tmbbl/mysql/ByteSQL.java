package me.xenodev.tmbbl.mysql;

import me.xenodev.tmbbl.main.Main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ByteSQL {

    public static boolean playerExists(UUID uuid){

        try{
            ResultSet rs = Main.mysql.query("SELECT * FROM Bytes WHERE UUID= '" + uuid + "'");
            if(rs.next()){
                return rs.getString("UUID") != null;
            }
            return false;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }

    public static void createPlayer(UUID uuid){

        if(!(playerExists(uuid))){
            Main.mysql.update("INSERT INTO Bytes(UUID, BYTES) VALUES ('" + uuid + "', '0');");
        }
    }


    public static Integer getBytes(UUID uuid){
        Integer i = 0;

        if(playerExists(uuid)){
            try{
                ResultSet rs = Main.mysql.query("SELECT * FROM Bytes WHERE UUID= '" + uuid + "'");
                if((!rs.next()) || (Integer.valueOf(rs.getInt("BYTES")) == null));
                i = rs.getInt("BYTES");
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            createPlayer(uuid);
            getBytes(uuid);
        }

        return i;
    }

    public static void setBytes(UUID uuid, Integer bytes){
        if(playerExists(uuid)){
            Main.mysql.update("UPDATE Bytes SET BYTES= '" + bytes + "' WHERE UUID= '" + uuid + "';");
        }else{
            createPlayer(uuid);
            setBytes(uuid, bytes);
        }
    }

    public static void addBytes(UUID uuid, Integer bytes){
        if(playerExists(uuid)){
            setBytes(uuid, Integer.valueOf(getBytes(uuid).intValue() + bytes.intValue()));
        }else{
            createPlayer(uuid);
            addBytes(uuid, bytes);
        }
    }

    public static void removeBytes(UUID uuid, Integer bytes){
        if(playerExists(uuid)){
            setBytes(uuid, Integer.valueOf(getBytes(uuid).intValue() - bytes.intValue()));
        }else{
            createPlayer(uuid);
            removeBytes(uuid, bytes);
        }
    }
}
