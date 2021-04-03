package me.xenodev.tmbbl.events.profil.gadget.pvpschwert;

import me.xenodev.tmbbl.file.StatsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.*;
import org.bukkit.block.BlockFace;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Firework;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;

public class PvPSchwertEvent implements Listener {

    public static ArrayList<Player> pvpschwert = new ArrayList<Player>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            if(p.isSneaking()) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7» §9PvPSchwert §7«")) {
                        if (pvpschwert.contains(p)) {
                            removePvP(p);
                        } else if (!pvpschwert.contains(p)) {
                            addPvP(p);
                        }

                    }
                }
            }
        } catch (NullPointerException e1) {}
    }

    public static void addPvP(Player p){
        pvpschwert.add(p);
        lookSchword(p);
        p.setMaxHealth(40);
        p.setHealth(40);
        p.sendMessage(Main.prefix + "§7Du hast den Kampfmodus §abetreten");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
    }

    public static void removePvP(Player p){
        pvpschwert.remove(p);
        p.getInventory().setItem(6, new ItemBuilder(Material.DIAMOND_SWORD).setName("§7» §9PvPSchwert §7«").setLore("", "§7Benutze §eSneak + Rechtsklick§7 um den §3Kampfmodus §7zu §abetreten§7/§cverlassen").setUnbreakable().build());
        p.setMaxHealth(6);
        p.setHealth(6);
        for(PotionEffect effect : p.getActivePotionEffects()){
            p.removePotionEffect(effect.getType());
        }
        p.sendMessage(Main.prefix + "§7Du hast den Kampfmodus §cverlassen");
        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1f, 1f);
    }

    public static void lookSchword(Player p){
        for(PotionEffect effect : p.getActivePotionEffects()){
            p.removePotionEffect(effect.getType());
        }
        if(StatsFilebuilder.getStreak(p) >= 15){
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*50, 3));
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*15, 255));
            p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20*40, 1));
            p.getInventory().setItem(6, new ItemBuilder(Material.DIAMOND_SWORD).setName("§7» §9PvPSchwert §7«").setEnchantment(Enchantment.DAMAGE_ALL, 12).setLore("", "§7Benutze §eSneak + Rechtsklick§7 um den §3Kampfmodus §7zu §abetreten§7/§cverlassen").setUnbreakable().build());
        }else if(StatsFilebuilder.getStreak(p) >= 10){
            p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*10*2, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*10*2, 1));
            p.getInventory().setItem(6, new ItemBuilder(Material.DIAMOND_SWORD).setName("§7» §9PvPSchwert §7«").setEnchantment(Enchantment.DAMAGE_ALL, 10).setLore("", "§7Benutze §eSneak + Rechtsklick§7 um den §3Kampfmodus §7zu §abetreten§7/§cverlassen").setUnbreakable().build());
        }else if(StatsFilebuilder.getStreak(p) <= 9 && StatsFilebuilder.getStreak(p) >= 2){
            if(p.getHealth() < 20){
                p.setMaxHealth(20);
                p.setHealth(20);
            }
            p.setFoodLevel(20);
            p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*30*2, 2));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*10*2, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*20*2, 2));
            p.getInventory().setItem(6, new ItemBuilder(Material.DIAMOND_SWORD).setName("§7» §9PvPSchwert §7«").setEnchantment(Enchantment.DAMAGE_ALL, StatsFilebuilder.getStreak(p)).setLore("", "§7Benutze §eSneak + Rechtsklick§7 um den §3Kampfmodus §7zu §abetreten§7/§cverlassen").setUnbreakable().build());
        }else if(StatsFilebuilder.getStreak(p) <= 1){
            p.setMaxHealth(40);
            p.setHealth(40);
            p.setFoodLevel(40);
            p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*60*2, 5));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20*30*2, 3));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*30*2, 3));
            p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 20*10*2, 1));
            p.getInventory().setItem(6, new ItemBuilder(Material.DIAMOND_SWORD).setName("§7» §9PvPSchwert §7«").setEnchantment(Enchantment.DAMAGE_ALL, 1).setLore("", "§7Benutze §eSneak + Rechtsklick§7 um den §3Kampfmodus §7zu §abetreten§7/§cverlassen").setUnbreakable().build());
        }
    }
}
