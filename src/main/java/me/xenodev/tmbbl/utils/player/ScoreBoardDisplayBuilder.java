package me.xenodev.tmbbl.utils.player;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;

public class ScoreBoardDisplayBuilder {

    public static HashMap<Player, Integer> timerdisplay = new HashMap<Player, Integer>();
    public static void updateScoreName(Player p){
        Scoreboard board = p.getScoreboard();
        Objective obj = board.getObjective("main");

        if(timerdisplay.get(p) == 1){
            obj.setDisplayName("§7» §5§lT§deam§5§lM§dega§5§lB§dyte §7«");
        }else if(timerdisplay.get(p) == 2){
            obj.setDisplayName("§7» §dT§5§le§damM§5§le§dgaB§5§ly§dte §7«");
        }else if(timerdisplay.get(p) == 3){
            obj.setDisplayName("§7» §dTe§5§la§dmMe§5§lg§daBy§5§lt§de §7«");
        }else if(timerdisplay.get(p) == 4){
            obj.setDisplayName("§7» §dTea§5§lm§dMeg§5§la§dByt§5§le §7«");
        }else if(timerdisplay.get(p) == 5){
            obj.setDisplayName("§7» §5§lT§deam§5§lM§dega§5§lB§dyte §7«");
        }else if(timerdisplay.get(p) == 6){
            obj.setDisplayName("§7» §dT§5§le§damM§5§le§dgaB§5§ly§dte §7«");
        }else if(timerdisplay.get(p) == 7){
            obj.setDisplayName("§7» §dTe§5§la§dmMe§5§lg§daBy§5§lt§de §7«");
        }else if(timerdisplay.get(p) == 8){
            obj.setDisplayName("§7» §dTea§5§lm§dMeg§5§la§dByt§5§le §7«");
        }else if(timerdisplay.get(p) == 9){
            obj.setDisplayName("§7» §5§lT§deam§5§lM§dega§5§lB§dyte §7«");
        }else if(timerdisplay.get(p) == 10){
            obj.setDisplayName("§7» §dT§5§le§damM§5§le§dgaB§5§ly§dte §7«");
        }else if(timerdisplay.get(p) == 11){
            obj.setDisplayName("§7» §dTe§5§la§dmMe§5§lg§daBy§5§lt§de §7«");
        }else if(timerdisplay.get(p) == 12){
            obj.setDisplayName("§7» §dTea§5§lm§dMeg§5§la§dByt§5§le §7«");
        }else if(timerdisplay.get(p) == 13){
            obj.setDisplayName("§7» §5§lT§deam§5§lM§dega§5§lB§dyte §7«");
        }else if(timerdisplay.get(p) == 14){
            obj.setDisplayName("§7» §5§lT§deam§5§lM§dega §7«");
        }else if(timerdisplay.get(p) == 15){
            obj.setDisplayName("§7» §5§lT§deam §7«");
        }else if(timerdisplay.get(p) == 16){
            obj.setDisplayName("§7»  §7«");
        }else if(timerdisplay.get(p) == 17){
            obj.setDisplayName("§7» §5§lT§deam §7«");
        }else if(timerdisplay.get(p) == 18){
            obj.setDisplayName("§7» §5§lT§deam§5§lM§dega §7«");
            timerdisplay.remove(p);
            timerdisplay.put(p, 0);
        }
        timerdisplay.replace(p, timerdisplay.get(p), timerdisplay.get(p) + 1);
    }

}
