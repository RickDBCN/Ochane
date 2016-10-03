package me.Craviant.main.Commands;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChat extends Command {
public StaffChat()
{
    super("sc");

}
    public void execute(CommandSender sender, String[] args)
    {
        ProxiedPlayer p = (ProxiedPlayer)sender;
        if (args.length <1 && p.hasPermission("ochane.staff"))
        {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Use: /sc <message>"));
            return;

        }
        else {
            sender.sendMessage(new TextComponent(ChatColor.RED + "Fool!"));
        }
        for (ProxiedPlayer pl : ProxyServer.getInstance().getPlayers())
            if (pl.hasPermission("ochane.staff")) {
                StringBuilder chatBuilder = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    chatBuilder.append(args[i]).append(" ");

                }
                String chatOld = ChatColor.translateAlternateColorCodes('&', chatBuilder.toString().trim());
                pl.sendMessage(new TextComponent(ChatColor.BLUE + "[" + ChatColor.DARK_RED + "STAFF" + ChatColor.BLUE + "] " + p.getName() + ": " + chatOld));
            }
    }
}
