package nocosfera;

import jdk.internal.loader.BuiltinClassLoader;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class sleepEvent implements Listener {

    @EventHandler
    public void playerGoSleep (PlayerBedEnterEvent event) {
        Player p = event.getPlayer();
        Player all = (Player) Bukkit.getOnlinePlayers();
        int czas = (int) Bukkit.getWorld("world").getTime();

        if(czas > 12540) {
            int allliczba = Bukkit.getOnlinePlayers().size();
            int gracze = allliczba / 2;
        }
    }
}