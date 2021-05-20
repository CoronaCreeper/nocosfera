package nocosfera;

import nocosfera.commands.SerwerCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nocosfera extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new deathEvent(), this);
        System.out.println("[Nocosfera] Loaded events");
        getCommand("serwer").setExecutor((CommandExecutor) new SerwerCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
