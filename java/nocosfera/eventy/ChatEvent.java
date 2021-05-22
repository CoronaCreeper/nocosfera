package nocosfera.eventy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        event.setFormat(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.GREEN + " >> " + ChatColor.GRAY + event.getMessage());
    }
}
