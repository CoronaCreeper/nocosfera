package nocosfera;

import nocosfera.commands.BorderCommand;
import nocosfera.commands.InfoCommand;
import nocosfera.eventy.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Nocosfera extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getConfig().addDefault("is_enabled", true);
        getConfig().getString("is_enabled");
        getConfig().options().copyDefaults(true);
        saveConfig();
        if(getConfig().getBoolean("is_enabled") == true) {
            File f = new File ("plugins/Nocosfera/spanie.yml");
            YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
            if(yamlFile.get("spiacy")== null) yamlFile.set("spiacy", 0);
            int max = Bukkit.getOnlinePlayers().size();
            yamlFile.set("spiacy",0);
            System.out.println("[Nocosfera] Loaded config!");
            try {
                yamlFile.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.getServer().getPluginManager().registerEvents(this, this);
            this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
            this.getServer().getPluginManager().registerEvents(new deathEvent(), this);
            this.getServer().getPluginManager().registerEvents(new GłówkiEvent(), this);
            this.getServer().getPluginManager().registerEvents(new ChatEvent(), this);
            this.getServer().getPluginManager().registerEvents(new SleepEvent(), this);
            System.out.println("[Nocosfera] Loaded events");
            getCommand("info").setExecutor((CommandExecutor) new InfoCommand());
            getCommand("granica").setExecutor((CommandExecutor) new BorderCommand());
            System.out.println("[Nocosfera] Loaded commands");
        }else {
            System.out.println("[Nocosfera] Plugin zostal wylaczony w configu");
            this.getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
