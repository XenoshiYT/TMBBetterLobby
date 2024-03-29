package me.xenodev.tmbbl.main;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.Particles_1_13;
import com.github.fierioziy.particlenativeapi.api.Particles_1_8;
import com.github.fierioziy.particlenativeapi.plugin.ParticleNativePlugin;
import me.xenodev.tmbbl.commands.lobby.BuildCMD;
import me.xenodev.tmbbl.commands.lobby.SpawnCMD;
import me.xenodev.tmbbl.commands.player.OnlinezeitCMD;
import me.xenodev.tmbbl.commands.player.StatsCMD;
import me.xenodev.tmbbl.commands.specialevents.main.EventCMD;
import me.xenodev.tmbbl.events.lobby.*;
import me.xenodev.tmbbl.events.navigator.NavigatorEvent;
import me.xenodev.tmbbl.events.player.DoppleJumpEvent;
import me.xenodev.tmbbl.events.player.JoinEvent;
import me.xenodev.tmbbl.events.player.LeaveEvent;
import me.xenodev.tmbbl.events.player.MusicMoveEvent;
import me.xenodev.tmbbl.events.profil.gadget.enderperle.EnderperleEvent;
import me.xenodev.tmbbl.events.profil.gadget.enterhaken.EnterhakenEvent;
import me.xenodev.tmbbl.events.profil.gadget.flugstab.FlugstabEvent;
import me.xenodev.tmbbl.events.profil.gadget.main.GadgetEvent;
import me.xenodev.tmbbl.events.profil.gadget.specialevents.easter.EggBombEvent;
import me.xenodev.tmbbl.events.profil.gadget.specialevents.easter.SwitchBow;
import me.xenodev.tmbbl.events.profil.head.HeadEvent;
import me.xenodev.tmbbl.events.profil.main.ProfilEvent;
import me.xenodev.tmbbl.events.profil.music.main.MusicEvent;
import me.xenodev.tmbbl.events.profil.settings.SettingsEvent;
import me.xenodev.tmbbl.events.profil.shop.ShopEvent;
import me.xenodev.tmbbl.events.profil.trail.cloud.CloudEvent;
import me.xenodev.tmbbl.events.profil.trail.event.christmas.SnowEvent;
import me.xenodev.tmbbl.events.profil.trail.event.easter.ColorEvent;
import me.xenodev.tmbbl.events.profil.trail.event.halloween.BarrierEvent;
import me.xenodev.tmbbl.events.profil.trail.flame.FlameEvent;
import me.xenodev.tmbbl.events.profil.trail.love.LoveEvent;
import me.xenodev.tmbbl.events.profil.trail.main.TrailEvent;
import me.xenodev.tmbbl.events.profil.trail.note.NoteEvent;
import me.xenodev.tmbbl.events.profil.trail.soulflame.SoulflameEvent;
import me.xenodev.tmbbl.events.profil.trail.smoke.SmokeEvent;
import me.xenodev.tmbbl.events.profil.wardrobe.WardrobeEvent;
import me.xenodev.tmbbl.file.EventFilebuilder;
import me.xenodev.tmbbl.mysql.MySQL;
import me.xenodev.tmbbl.utils.nutzen.SnowBuilder;
import me.xenodev.tmbbl.utils.nutzen.TimerBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;
    public static String prefix = "§8[§5§lTMB§8] ";
    public static String error = "§8[§4ERROR§8] ";

    public static MySQL mysql;
    public static Particles_1_13 particles_1_13;
    public static Particles_1_8 particles_1_8;

    @Override
    public void onEnable() {
        instance = this;
        ConnectMySQL();

        ParticleNativeAPI api = ParticleNativePlugin.getAPI();
        particles_1_13 = api.getParticles_1_13();
        particles_1_8 = api.getParticles_1_8();

        if(EventFilebuilder.file.exists()) {
            if (EventFilebuilder.getEvent().equalsIgnoreCase("christmas")) {
                new SnowBuilder();
            }
        }else{
            EventFilebuilder.setEvent("none");
        }

        commands();
        events();
        TimerBuilder.startScoreboard();
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
        mysql.update("CREATE TABLE IF NOT EXISTS Coins(UUID VARCHAR(100),COINS BIGINT)");
        mysql.update("CREATE TABLE IF NOT EXISTS Bytes(UUID VARCHAR(100),BYTES BIGINT)");
        mysql.update("CREATE TABLE IF NOT EXISTS Players(UUID VARCHAR(100),NAME VARCHAR(100))");
    }

    private void commands() {
        getServer().getPluginCommand("oz").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("ot").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("onlinezeit").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("onlinetime").setExecutor(new OnlinezeitCMD());
        getServer().getPluginCommand("build").setExecutor(new BuildCMD());
        getServer().getPluginCommand("spawn").setExecutor(new SpawnCMD());
        getServer().getPluginCommand("event").setExecutor(new EventCMD());
        getServer().getPluginCommand("stats").setExecutor(new StatsCMD());
    }

    private void events() {
        getServer().getPluginManager().registerEvents(new BuildEvent(), this);
        getServer().getPluginManager().registerEvents(new FoodEvent(), this);
        getServer().getPluginManager().registerEvents(new ItemEvent(), this);
        getServer().getPluginManager().registerEvents(new WeatherEvent(), this);
        getServer().getPluginManager().registerEvents(new SwitchhandEvent(), this);
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);

        getServer().getPluginManager().registerEvents(new NavigatorEvent(), this);

        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
        getServer().getPluginManager().registerEvents(new DoppleJumpEvent(), this);

        getServer().getPluginManager().registerEvents(new ShopEvent(), this);
        getServer().getPluginManager().registerEvents(new GadgetEvent(), this);
        getServer().getPluginManager().registerEvents(new EggBombEvent(), this);
        getServer().getPluginManager().registerEvents(new EnterhakenEvent(), this);
        getServer().getPluginManager().registerEvents(new EnderperleEvent(), this);
        getServer().getPluginManager().registerEvents(new HeadEvent(), this);
        getServer().getPluginManager().registerEvents(new SettingsEvent(), this);
        getServer().getPluginManager().registerEvents(new ProfilEvent(), this);
        getServer().getPluginManager().registerEvents(new WardrobeEvent(), this);
        getServer().getPluginManager().registerEvents(new FlugstabEvent(), this);
        getServer().getPluginManager().registerEvents(new SwitchBow(), this);
        getServer().getPluginManager().registerEvents(new TrailEvent(), this);
        getServer().getPluginManager().registerEvents(new CloudEvent(), this);
        getServer().getPluginManager().registerEvents(new LoveEvent(), this);
        getServer().getPluginManager().registerEvents(new NoteEvent(), this);
        getServer().getPluginManager().registerEvents(new SoulflameEvent(), this);
        getServer().getPluginManager().registerEvents(new FlameEvent(), this);
        getServer().getPluginManager().registerEvents(new SmokeEvent(), this);
        getServer().getPluginManager().registerEvents(new EggBombEvent(), this);
        getServer().getPluginManager().registerEvents(new MusicEvent(), this);
        getServer().getPluginManager().registerEvents(new BarrierEvent(), this);
        getServer().getPluginManager().registerEvents(new ColorEvent(), this);
        getServer().getPluginManager().registerEvents(new SnowEvent(), this);
        getServer().getPluginManager().registerEvents(new MusicMoveEvent(), this);

    }
}
