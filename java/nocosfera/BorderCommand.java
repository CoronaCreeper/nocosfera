package nocosfera;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BorderCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(p.isOp() == true) {
                if(args.length > 0) {
                    p.getWorld().getWorldBorder().setSize(Double.parseDouble(args[0]));
                    p.sendMessage(ChatColor.GREEN + "Ustawiłem border na " + ChatColor.RED + args[0]);
                }else p.sendMessage(ChatColor.RED + "Nie podałeś średnicy bordera");
            }else p.sendMessage(ChatColor.RED + "Nie masz dostępu do tej komendy!");
        } else System.out.println("Komenda dostępna tylko dla graczy!");
        return false;
    }
}
