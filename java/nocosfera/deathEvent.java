package nocosfera;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class deathEvent implements Listener {

    @EventHandler
    public void onPlayerDeath (PlayerDeathEvent event) {
        Player p = event.getEntity();
        if (p instanceof Player) {
            event.setDeathMessage(ChatColor.RED + p.getName() + " zginął");
        }
    }
}
