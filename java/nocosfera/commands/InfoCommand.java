package nocosfera.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            String silnik = p.getServer().getVersion();
            int maxgraczy = p.getServer().getMaxPlayers();
            int onlinegraczy = p.getServer().getOnlinePlayers().size();
            String IP = p.getAddress().getHostName();
            UUID UUID = p.getUniqueId();
            p.sendMessage(ChatColor.GREEN + "Informacje o serwerze" +
                    "\nSilnik: " + ChatColor.RED + silnik + ChatColor.GREEN +
                    "\nLokalizacja serwera: " + ChatColor.RED + "Niemcy" + ChatColor.GREEN +
                    "\nGracze: " + ChatColor.RED + onlinegraczy+"/"+maxgraczy + ChatColor.GREEN +
                    "\nTwoje IP: " + ChatColor.RED + IP + ChatColor.GREEN +
                    "\nUUID: " + ChatColor.RED + UUID + ChatColor.GREEN);
        }else System.out.println("Komenda dostepna tylko dla graczy!");
        return false;
    }
}