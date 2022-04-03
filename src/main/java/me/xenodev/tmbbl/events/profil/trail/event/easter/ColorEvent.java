package me.xenodev.tmbbl.events.profil.trail.event.easter;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class ColorEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (SettingsFilebuilder.getArmor(p, "Spur", "Color").equals(true)) {
            if (SettingsFilebuilder.getSetting(p, "Hide").equals(false)) {
                if (p.getGameMode().equals(GameMode.ADVENTURE) || p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.CREATIVE)) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (SettingsFilebuilder.getSetting(all, "Hide").equals(true)) {
                            Random random = new Random();
                            Integer randomZahl = random.nextInt(5);
                            Location location = p.getLocation().add(0, 0.5, 0);
                            Object packet = null;

                            if(randomZahl == 0){
                                packet = Main.particles_1_13.DUST().color(Color.RED, 2.5).packet(true, location);
                            }else if(randomZahl == 1){
                                packet = Main.particles_1_13.DUST().color(Color.BLUE, 2.5).packet(true, location);
                            }else if(randomZahl == 2){
                                packet = Main.particles_1_13.DUST().color(Color.YELLOW, 2.5).packet(true, location);
                            }else if(randomZahl == 3){
                                packet = Main.particles_1_13.DUST().color(Color.GREEN, 2.5).packet(true, location);
                            }else if(randomZahl == 4){
                                packet = Main.particles_1_13.DUST().color(Color.WHITE, 2.5).packet(true, location);
                            }else if(randomZahl == 5){
                                packet = Main.particles_1_13.DUST().color(Color.BLACK, 2.5).packet(true, location);
                            }
                            Main.particles_1_13.sendPacket(p, packet);
                        } else {
                            Random random = new Random();
                            Integer randomZahl = random.nextInt(5);
                            Location location = p.getLocation().add(0, 0.5, 0);
                            Object packet = null;

                            if(randomZahl == 0){
                                packet = Main.particles_1_13.DUST().color(Color.RED, 2.5).packet(true, location);
                            }else if(randomZahl == 1){
                                packet = Main.particles_1_13.DUST().color(Color.BLUE, 2.5).packet(true, location);
                            }else if(randomZahl == 2){
                                packet = Main.particles_1_13.DUST().color(Color.YELLOW, 2.5).packet(true, location);
                            }else if(randomZahl == 3){
                                packet = Main.particles_1_13.DUST().color(Color.GREEN, 2.5).packet(true, location);
                            }else if(randomZahl == 4){
                                packet = Main.particles_1_13.DUST().color(Color.WHITE, 2.5).packet(true, location);
                            }else if(randomZahl == 5){
                                packet = Main.particles_1_13.DUST().color(Color.BLACK, 2.5).packet(true, location);
                            }
                            Main.particles_1_13.sendPacket(all, packet);
                        }
                    }
                } else {
                    Random random = new Random();
                    Integer randomZahl = random.nextInt(5);
                    Location location = p.getLocation().add(0, 0.5, 0);
                    Object packet = null;

                    if(randomZahl == 0){
                        packet = Main.particles_1_13.DUST().color(Color.RED, 2.5).packet(true, location);
                    }else if(randomZahl == 1){
                        packet = Main.particles_1_13.DUST().color(Color.BLUE, 2.5).packet(true, location);
                    }else if(randomZahl == 2){
                        packet = Main.particles_1_13.DUST().color(Color.YELLOW, 2.5).packet(true, location);
                    }else if(randomZahl == 3){
                        packet = Main.particles_1_13.DUST().color(Color.GREEN, 2.5).packet(true, location);
                    }else if(randomZahl == 4){
                        packet = Main.particles_1_13.DUST().color(Color.WHITE, 2.5).packet(true, location);
                    }else if(randomZahl == 5){
                        packet = Main.particles_1_13.DUST().color(Color.BLACK, 2.5).packet(true, location);
                    }
                    Main.particles_1_13.sendPacket(p, packet);
                }
            } else {
                Random random = new Random();
                Integer randomZahl = random.nextInt(5);
                Location location = p.getLocation().add(0, 0.5, 0);
                Object packet = null;

                if(randomZahl == 0){
                    packet = Main.particles_1_13.DUST().color(Color.RED, 2.5).packet(true, location);
                }else if(randomZahl == 1){
                    packet = Main.particles_1_13.DUST().color(Color.BLUE, 2.5).packet(true, location);
                }else if(randomZahl == 2){
                    packet = Main.particles_1_13.DUST().color(Color.YELLOW, 2.5).packet(true, location);
                }else if(randomZahl == 3){
                    packet = Main.particles_1_13.DUST().color(Color.GREEN, 2.5).packet(true, location);
                }else if(randomZahl == 4){
                    packet = Main.particles_1_13.DUST().color(Color.WHITE, 2.5).packet(true, location);
                }else if(randomZahl == 5){
                    packet = Main.particles_1_13.DUST().color(Color.BLACK, 2.5).packet(true, location);
                }
                Main.particles_1_13.sendPacket(p, packet);
            }
        }
    }
}
