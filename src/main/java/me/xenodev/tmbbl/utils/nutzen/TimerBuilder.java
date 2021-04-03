package me.xenodev.tmbbl.utils.nutzen;

import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.mysql.TimeSQL;
import me.xenodev.tmbbl.utils.player.ScoreBoardBuilder;
import me.xenodev.tmbbl.utils.player.ScoreBoardDisplayBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

public class TimerBuilder {

    private static int sched1;
    private static int sched2;
    private static int sched3;
    private static int sched4;
    private static int sched5;

    public static void startScoreboard() {
    if (!Bukkit.getScheduler().isCurrentlyRunning(sched1)) {
        sched1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, (Runnable)new Runnable() {
            @Override
            public void run() {
                for (final Player all : Bukkit.getOnlinePlayers()) {
                    ScoreBoardBuilder.updateScoreboard(all);
                }
            }
        }, 0L, 20L);
    }
}

    public static void startOnlinetime() {
        if (!Bukkit.getScheduler().isCurrentlyRunning(sched2)) {
            sched2 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    for (final Player all : Bukkit.getOnlinePlayers()) {
                        TimeSQL.addSeconds(all.getUniqueId(), 1);
                        if(TimeSQL.getSeconds(all.getUniqueId()) == 60){
                            TimeSQL.addMinutes(all.getUniqueId(), 1);
                            TimeSQL.setSeconds(all.getUniqueId(), 0);
                        }

                        if(TimeSQL.getMinutes(all.getUniqueId()) == 60){
                            TimeSQL.addHours(all.getUniqueId(), 1);
                            TimeSQL.setMinutes(all.getUniqueId(), 0);
                        }
                    }
                }
            }, 0L, 20L);
        }
    }

    public static void startDisplay() {
        if (!Bukkit.getScheduler().isCurrentlyRunning(sched3)) {
            sched3 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    for(Player all : Bukkit.getOnlinePlayers()){
                        ScoreBoardDisplayBuilder.updateScoreName(all);
                    }
                }
            }, 0L, 5L);
        }
    }

    public static void startClearLag() {
        if (!Bukkit.getScheduler().isCurrentlyRunning(sched4)) {
            sched4 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.instance, (Runnable)new Runnable() {
                @Override
                public void run() {
                    for(Entity entity : Bukkit.getWorld("gaming").getEntities()){
                        if(entity instanceof Item){
                            entity.remove();
                        }
                    }
                }
            }, 0L, 10*20L);
        }
    }
}
