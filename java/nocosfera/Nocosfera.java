package nocosfera;

import nocosfera.commands.InfoCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nocosfera extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new deathEvent(), this);
        this.getServer().getPluginManager().registerEvents(new sleepEvent(), this);
        this.getServer().getPluginManager().registerEvents(new GłówkiEvent(), this);
        System.out.println("[Nocosfera] Loaded events");
        getCommand("info").setExecutor((CommandExecutor) new InfoCommand());
        getCommand("granica").setExecutor((CommandExecutor) new BorderCommand());
        System.out.println("[Nocosfera] Loaded commands");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
