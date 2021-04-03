package me.xenodev.tmbbl.main;

import me.xenodev.tmbbl.commands.lobby.BuildCMD;
import me.xenodev.tmbbl.commands.lobby.SpawnCMD;
import me.xenodev.tmbbl.commands.player.OnlinezeitCMD;
import me.xenodev.tmbbl.commands.player.StatsCMD;
import me.xenodev.tmbbl.commands.specialevents.winter.EasterCMD;
import me.xenodev.tmbbl.events.lobby.*;
import me.xenodev.tmbbl.events.navigator.NavigatorEvent;
import me.xenodev.tmbbl.events.player.JoinEvent;
import me.xenodev.tmbbl.events.player.LeaveEvent;
import me.xenodev.tmbbl.events.profil.friend.FriendEvent;
import me.xenodev.tmbbl.events.profil.gadget.enderperle.EnderPerleEvent;
import me.xenodev.tmbbl.events.profil.gadget.enterhaken.EnterhakenEvent;
import me.xenodev.tmbbl.events.profil.gadget.feuerwerk.FeuerwerkEvent;
import me.xenodev.tmbbl.events.profil.gadget.flugstab.FlugstabEvent;
import me.xenodev.tmbbl.events.profil.gadget.main.GadgetEvent;
import me.xenodev.tmbbl.events.profil.gadget.megasprung.MegasprungEvent;
import me.xenodev.tmbbl.events.profil.gadget.pvpschwert.PvPSchwertEvent;
import me.xenodev.tmbbl.events.profil.gadget.specialevents.easter.EasterEvent;
import me.xenodev.tmbbl.events.profil.gadget.tmbdope.TMBDopeEvent;
import me.xenodev.tmbbl.events.profil.head.HeadEvent;
import me.xenodev.tmbbl.events.profil.main.ProfilEvent;
import me.xenodev.tmbbl.events.profil.hide.HiderEvent;
import me.xenodev.tmbbl.events.profil.trail.ender.EnderEvent;
import me.xenodev.tmbbl.events.profil.trail.flame.FlameEvent;
import me.xenodev.tmbbl.events.profil.trail.love.LoveEvent;
import me.xenodev.tmbbl.events.profil.trail.main.TrailEvent;
import me.xenodev.tmbbl.events.profil.trail.note.NoteEvent;
import me.xenodev.tmbbl.events.profil.trail.potion.PotionEvent;
import me.xenodev.tmbbl.events.profil.trail.smoke.SmokeEvent;
import me.xenodev.tmbbl.events.profil.wardrobe.WardrobeEvent;
import me.xenodev.tmbbl.mysql.MySQL;
import me.xenodev.tmbbl.utils.nutzen.TimerBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public int sched;
    public int sched1;
    public int sched2;
    public int sched3;
    public static String prefix = "§8[§5§lTMB§8] ";
    public static String error = "§8[§4ERROR§8] ";

    public static MySQL mysql;

    @Override
    public void onEnable() {
        instance = this;
        ConnectMySQL();

        commands();
        events();
        TimerBuilder.startScoreboard();
        TimerBuilder.startOnlinetime();
        TimerBuilder.startDisplay();
        TimerBuilder.startClearLag();
    }

    @Override
    public void onDisable() {
        mysql.close();
    }

    private void ConnectMySQL() {
        mysql = new MySQL("localhost", "tmbmysql", "tmbmysql", "[BM7A6s5AeZmo6*]");
        mysql.update("CREATE TABLE IF NOT EXISTS Time(UUID VARCHAR(100),HOURS BIGINT,MINUTES INT,SECONDS INT)");
    }

    private void commands() {
        getServer().getPluginCommand("oz").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("ot").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("onlinezeit").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("onlinetime").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("build").setExecutor(new BuildCMD());
        getServer().getPluginCommand("spawn").setExecutor(new SpawnCMD());
        getServer().getPluginCommand("stats").setExecutor(new StatsCMD());
        getServer().getPluginCommand("easter").setExecutor(new EasterCMD());
    }

    private void events() {
        getServer().getPluginManager().registerEvents(new BuildEvent(), this);
        getServer().getPluginManager().registerEvents(new DeathmatchEvent(), this);
        getServer().getPluginManager().registerEvents(new FoodEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemEvent(), this);
        getServer().getPluginManager().registerEvents(new WeatherEvent(), this);

        getServer().getPluginManager().registerEvents(new NavigatorEvent(), this);

        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);

        getServer().getPluginManager().registerEvents(new FriendEvent(), this);
        getServer().getPluginManager().registerEvents(new EnderPerleEvent(), this);
        getServer().getPluginManager().registerEvents(new EnterhakenEvent(), this);
        getServer().getPluginManager().registerEvents(new FeuerwerkEvent(), this);
        getServer().getPluginManager().registerEvents(new GadgetEvent(), this);
        getServer().getPluginManager().registerEvents(new MegasprungEvent(), this);
        getServer().getPluginManager().registerEvents(new EasterEvent(), this);
        getServer().getPluginManager().registerEvents(new PvPSchwertEvent(), this);
        getServer().getPluginManager().registerEvents(new HeadEvent(), this);
        getServer().getPluginManager().registerEvents(new HiderEvent(), this);
        getServer().getPluginManager().registerEvents(new ProfilEvent(), this);
        getServer().getPluginManager().registerEvents(new WardrobeEvent(), this);
        getServer().getPluginManager().registerEvents(new FlugstabEvent(), this);
        getServer().getPluginManager().registerEvents(new TMBDopeEvent(), this);
        getServer().getPluginManager().registerEvents(new TrailEvent(), this);
        getServer().getPluginManager().registerEvents(new EnderEvent(), this);
        getServer().getPluginManager().registerEvents(new LoveEvent(), this);
        getServer().getPluginManager().registerEvents(new NoteEvent(), this);
        getServer().getPluginManager().registerEvents(new PotionEvent(), this);
        getServer().getPluginManager().registerEvents(new FlameEvent(), this);
        getServer().getPluginManager().registerEvents(new SmokeEvent(), this);
        getServer().getPluginManager().registerEvents(new EasterEvent(), this);

    }
}
