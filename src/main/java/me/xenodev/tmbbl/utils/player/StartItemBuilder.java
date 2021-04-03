package me.xenodev.tmbbl.utils.player;

import me.xenodev.tmbbl.file.SettingsFilebuilder;
import me.xenodev.tmbbl.main.Main;
import me.xenodev.tmbbl.utils.nutzen.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StartItemBuilder {

    public static void setItem(Player p){
        p.getInventory().clear();
        setArmor(p);
        new BukkitRunnable(){
            @Override
            public void run(){
                p.getInventory().setItem(1, new ItemBuilder(Material.NETHER_STAR).setName("§7» §cSpielmodi §7«").build());
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
            }
        }.runTaskLaterAsynchronously(Main.instance, 10L);

        new BukkitRunnable(){
            @Override
            public void run(){
                p.getInventory().setItem(2, new ItemBuilder(Material.COMPASS).setName("§7» §6Navigator §7«").build());
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
            }
        }.runTaskLaterAsynchronously(Main.instance, 20L);

        new BukkitRunnable(){
            @Override
            public void run(){
                if(SettingsFilebuilder.getSetting(p, "Enterhaken").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.FISHING_ROD).setName("§7» §9Enterhaken §7«").setUnbreakable().build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "Enderperle").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.ENDER_PEARL).setName("§7» §9Enderperle §7«").build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "Megasprung").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.FEATHER).setName("§7» §9Megasprung §7«").build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "Feuerwerk").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.FIREWORK_ROCKET).setName("§7» §9Feuerwerk §7«").build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "PvPSchwert").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.DIAMOND_SWORD).setName("§7» §9PvPSchwert §7«").setUnbreakable().setLore("", "§7Benutze §eSneak + Rechtsklick§7 um den §3Kampfmodus §7zu §abetreten§7/§cverlassen").build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "Flugstab").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.BLAZE_ROD).setName("§7» §9Flugstab §7«").setUnbreakable().build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "TMBDope").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.SUGAR).setName("§7» §9TMBDope §7«").setUnbreakable().build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "Farbbombe").equals(true)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.EGG).setName("§7» §9Farbbombe §7«").setLore("EasterEgg-Gadget von Ostern 2021").build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }else if(SettingsFilebuilder.getSetting(p, "Farbbombe").equals(false) && SettingsFilebuilder.getSetting(p, "TMBDope").equals(false) && SettingsFilebuilder.getSetting(p, "Flugstab").equals(false) && SettingsFilebuilder.getSetting(p, "PvPSchwert").equals(false) && SettingsFilebuilder.getSetting(p, "Enterhaken").equals(false) && SettingsFilebuilder.getSetting(p, "Enderperle").equals(false) && SettingsFilebuilder.getSetting(p, "Megasprung").equals(false) && SettingsFilebuilder.getSetting(p, "Feuerwerk").equals(false)){
                    p.getInventory().setItem(6, new ItemBuilder(Material.BARRIER).setName("§7» §cKein Gadget ausgewählt §7«").build());
                    p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
                }
            }
        }.runTaskLaterAsynchronously(Main.instance, 30L);

        new BukkitRunnable(){
            @Override
            public void run(){
                p.getInventory().setItem(7, new ItemBuilder(Material.PLAYER_HEAD).setOwner(p.getName()).setName("§7» §aProfil §7«").build());
                p.playSound(p.getLocation(), Sound.ENTITY_CHICKEN_EGG, 1f, 1f);
            }
        }.runTaskLaterAsynchronously(Main.instance, 40L);
    }

    public static void setArmor(Player p){
        if(SettingsFilebuilder.getArmor(p, "Helm", "Schildkrötenhelm").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.TURTLE_HELMET).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Helm", "Kettenhelm").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.CHAINMAIL_HELMET).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Helm", "Eisenhelm").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.IRON_HELMET).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Helm", "Diamanthelm").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.DIAMOND_HELMET).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Helm", "Goldhelm").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.GOLDEN_HELMET).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Helm", "Netherithelm").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.NETHERITE_HELMET).setUnbreakable().build());
        }

        if(SettingsFilebuilder.getArmor(p, "Brustplatte", "Kettenbrustplatte").equals(true)){
            p.getInventory().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Brustplatte", "Eisenbrustplatte").equals(true)){
            p.getInventory().setChestplate(new ItemBuilder(Material.IRON_CHESTPLATE).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Brustplatte", "Diamantbrustplatte").equals(true)){
            p.getInventory().setChestplate(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Brustplatte", "Goldbrustplatte").equals(true)){
            p.getInventory().setChestplate(new ItemBuilder(Material.GOLDEN_CHESTPLATE).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Brustplatte", "Netheritbrustplatte").equals(true)){
            p.getInventory().setChestplate(new ItemBuilder(Material.NETHERITE_CHESTPLATE).setUnbreakable().build());
        }

        if(SettingsFilebuilder.getArmor(p, "Hose", "Kettenhose").equals(true)){
            p.getInventory().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Hose", "Eisenhose").equals(true)){
            p.getInventory().setLeggings(new ItemBuilder(Material.IRON_LEGGINGS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Hose", "Diamanthose").equals(true)){
            p.getInventory().setLeggings(new ItemBuilder(Material.DIAMOND_LEGGINGS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Hose", "Goldhose").equals(true)){
            p.getInventory().setLeggings(new ItemBuilder(Material.GOLDEN_LEGGINGS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Hose", "Netherithose").equals(true)){
            p.getInventory().setLeggings(new ItemBuilder(Material.NETHERITE_LEGGINGS).setUnbreakable().build());
        }

        if(SettingsFilebuilder.getArmor(p, "Schuhe", "Kettenschuhe").equals(true)){
            p.getInventory().setBoots(new ItemBuilder(Material.CHAINMAIL_BOOTS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Schuhe", "Eisenschuhe").equals(true)){
            p.getInventory().setBoots(new ItemBuilder(Material.IRON_BOOTS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Schuhe", "Diamantschuhe").equals(true)){
            p.getInventory().setBoots(new ItemBuilder(Material.DIAMOND_BOOTS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Schuhe", "Goldschuhe").equals(true)){
            p.getInventory().setBoots(new ItemBuilder(Material.GOLDEN_BOOTS).setUnbreakable().build());
        }else if(SettingsFilebuilder.getArmor(p, "Schuhe", "Netheritschuhe").equals(true)){
            p.getInventory().setBoots(new ItemBuilder(Material.NETHERITE_BOOTS).setUnbreakable().build());
        }

        if(SettingsFilebuilder.getArmor(p, "Kopf", "Clashi").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Clashi").build());
        }else if(SettingsFilebuilder.getArmor(p, "Kopf", "Gondii").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Gondii").build());
        }else if(SettingsFilebuilder.getArmor(p, "Kopf", "Malette").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TMB_Malette").build());
        }else if(SettingsFilebuilder.getArmor(p, "Kopf", "Xenoshi").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("XenoshiYT").build());
        }else if(SettingsFilebuilder.getArmor(p, "Kopf", "Lucas").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TheLucas777").build());
        }else if(SettingsFilebuilder.getArmor(p, "Kopf", "Reaper").equals(true)){
            p.getInventory().setHelmet(new ItemBuilder(Material.PLAYER_HEAD).setOwner("TheReaperGER").build());
        }
    }
}
