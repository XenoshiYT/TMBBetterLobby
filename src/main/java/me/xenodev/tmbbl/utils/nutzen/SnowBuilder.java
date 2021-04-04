package me.xenodev.tmbbl.utils.nutzen;

import me.xenodev.tmbbl.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class SnowBuilder {

    private int version;
    float radius = 10;
    int amount = 150;
    boolean realistic;
    Random random;

    public SnowBuilder() {
        this.version = Integer.valueOf(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3].split("_")[1]);
        this.createFlakes();
    }

    private void createFlakes() {
        this.random = new Random();
        new BukkitRunnable() {
            public void run() {
                for (int i = 0; i < SnowBuilder.this.amount; ++i) {
                    final float xAdditive = (SnowBuilder.this.random.nextFloat() - 0.5f) * SnowBuilder.this.radius * 2.0f;
                    final float max = (float)Math.sqrt(SnowBuilder.this.radius * SnowBuilder.this.radius - xAdditive * xAdditive) * 2.0f;
                    final float yAdditive = (SnowBuilder.this.random.nextFloat() - 0.5f) * max;
                    final float zAdditive = (SnowBuilder.this.random.nextFloat() - 0.5f) * max;
                    final Location[] playerLoc = new Location[1];
                    final float n = 0;
                    final float n2 = 0;
                    final float n3 = 0;
                    final Location[] loc = new Location[1];
                    final Exception ex = null;
                    final Exception[] e = new Exception[1];
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        playerLoc[0] = player.getLocation();
                        loc[0] = new Location(player.getWorld(), playerLoc[0].getX() + n, playerLoc[0].getY() + n2, playerLoc[0].getZ() + n3);
                        if (SnowBuilder.this.realistic) {
                            if (loc[0].getWorld().getHighestBlockYAt(loc[0]) >= loc[0].getY()) {
                                return;
                            }
                        }
                        try {
                            if (13 <= SnowBuilder.this.version) {
                                SnowBuilder.this.sendParticles(player, loc[0].getX(), loc[0].getY(), loc[0].getZ(), 0.0, 10);
                            }
                            else {
                                SnowBuilder.this.sendParticles(player, "FIREWORKS_SPARK", (float) loc[0].getX(), (float) loc[0].getY(), (float) loc[0].getZ(), new int[] { 1 });
                            }
                        }
                        catch (ClassNotFoundException | SecurityException | NoSuchMethodException | IllegalArgumentException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchFieldException ex2) {
                            e[0] = ex;
                            e[0].printStackTrace();
                        }
                        return;
                    });
                }
            }
        }.runTaskTimer(Main.instance, 0L, 2L);
    }

    private Class<?> getNMSClass(final String nmsClassString) throws ClassNotFoundException {
        final String version = String.valueOf(Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3]) + ".";
        final String name = "net.minecraft.server." + version + nmsClassString;
        final Class<?> nmsClass = Class.forName(name);
        return nmsClass;
    }

    private Class<?> getCraftPlayerClass() throws ClassNotFoundException {
        final String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        final String name = "org.bukkit.craftbukkit." + version + ".entity.CraftPlayer";
        final Class<?> nmsClass = Class.forName(name.replace("/", "."));
        return nmsClass;
    }

    private Object getConnection(final Player player) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        final Method getHandle = player.getClass().getMethod("getHandle", (Class<?>[])new Class[0]);
        final Object nmsPlayer = getHandle.invoke(player, new Object[0]);
        final Field conField = nmsPlayer.getClass().getField("playerConnection");
        final Object con = conField.get(nmsPlayer);
        return con;
    }

    public void sendParticles(final Player player, final double x, final double y, final double z, final double data, final int amount) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        final Class<?> cpClass = this.getCraftPlayerClass();
        final Class<?> particleClass = Class.forName("org.bukkit.Particle");
        final Method valueOf = particleClass.getMethod("valueOf", String.class);
        final Method spawnParticle = cpClass.getMethod("spawnParticle", particleClass, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
        spawnParticle.invoke(cpClass.cast(player), valueOf.invoke(particleClass, "FIREWORKS_SPARK"), x, y, z, amount, 0.0, 0.0, 0.0, data);
    }

    public void sendParticles(final Player player, final String particle, final float x, final float y, final float z, final int[] amount) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        final Class<?> packetClass = this.getNMSClass("PacketPlayOutWorldParticles");
        final Class<?> particleClass = this.getNMSClass("EnumParticle");
        final Constructor<?> packetConstructor = packetClass.getConstructors()[1];
        final Method valueOf = particleClass.getMethod("valueOf", String.class);
        final Object packet = packetConstructor.newInstance(valueOf.invoke(particleClass, "FIREWORKS_SPARK"), true, x, y, z, 0.0f, 0.0f, 0.0f, 0.0f, 0, amount);
        final Method sendPacket = this.getNMSClass("PlayerConnection").getMethod("sendPacket", this.getNMSClass("Packet"));
        sendPacket.invoke(this.getConnection(player), packet);
    }
}
