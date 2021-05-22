package nocosfera.eventy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SleepEvent implements Listener {

    @EventHandler
    public void onSleep(PlayerBedEnterEvent event) {
        Player p = event.getPlayer();
        if(p.getWorld().getTime() > 12539) {
            File f = new File ("plugins/Nocosfera/spanie.yml");
            YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
            if(yamlFile.get("spiacy")== null) yamlFile.set("spiacy", 0);
            int max = Bukkit.getOnlinePlayers().size();
            yamlFile.set("spiacy", yamlFile.getInt("spiacy")+1);
            try {
                yamlFile.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int sleeping = yamlFile.getInt("spiacy");
            if( max % 2 == 0 ) {
                int wymagane = max / 2;
                Bukkit.broadcastMessage(ChatColor.GOLD + p.getName() + ChatColor.GREEN + " teraz śpi! Na serwerze jest łącznie " + ChatColor.RED + sleeping + ChatColor.GREEN + " śpiących osób. " +
                        "\nDo pominięcia nocy wymagane jest " + ChatColor.RED + max + ChatColor.GREEN + " śpiących osób");
                if(sleeping >= max) {
                    p.getWorld().setTime(0);
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Noc została pominięta!");
                    yamlFile.set("spiacy",0);
                    try {
                        yamlFile.save(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {

                int wymagane = (int) (max + 0.5);
                Bukkit.broadcastMessage(ChatColor.GOLD + p.getName() + ChatColor.GREEN + " teraz śpi! Na serwerze jest łącznie " + ChatColor.RED + sleeping + ChatColor.GREEN + " śpiących osób. " +
                        "\nDo pominięcia nocy wymagane jest " + ChatColor.RED + max + ChatColor.GREEN + " śpiących osób");
                yamlFile.set("spiacy",0);
                try {
                    yamlFile.save(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(sleeping >= max) {
                    p.getWorld().setTime(0);
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Noc została pominięta!");
                    yamlFile.set("spiacy",0);
                    try {
                        yamlFile.save(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onStopSleep(PlayerBedLeaveEvent event) {
        Player p = event.getPlayer();
        if(p.getWorld().getTime() > 12539) {
            File f = new File("plugins/Nocosfera/spanie.yml");
            YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
            if (yamlFile.get("spiacy") == null) yamlFile.set("spiacy", 0);
            int max = Bukkit.getOnlinePlayers().size();
            yamlFile.set("spiacy", yamlFile.getInt("spiacy") - 1);
            try {
                yamlFile.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int sleeping = yamlFile.getInt("spiacy");
            if (max % 2 == 0) {
                int wymagane = max / 2;
                Bukkit.broadcastMessage(ChatColor.GOLD + p.getName() + ChatColor.GREEN + " już nie śpi! Na serwerze jest łącznie " + ChatColor.RED + sleeping + ChatColor.GREEN + " śpiących osób. " +
                        "\nDo pominięcia nocy wymagane jest " + ChatColor.RED + max + ChatColor.GREEN + " śpiących osób");
            } else {

                int wymagane = (int) (max + 0.5);
                Bukkit.broadcastMessage(ChatColor.GOLD + p.getName() + ChatColor.GREEN + " już nie śpi! Na serwerze jest łącznie " + ChatColor.RED + sleeping + ChatColor.GREEN + " śpiących osób. " +
                        "\nDo pominięcia nocy wymagane jest " + ChatColor.RED + max + ChatColor.GREEN + " śpiących osób");
            }
        }
    }
}

