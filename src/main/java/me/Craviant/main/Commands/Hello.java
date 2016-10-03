package me.Craviant.main.Commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class Hello extends Command {

    public Hello() {
        super("hello");

    }
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer p = (ProxiedPlayer)sender;

        sender.sendMessage("Hi there " + ChatColor.RED + p.getName() + ChatColor.WHITE + "! You have figured out the secret /hello command! You'll become a hero and great things will be expected from you!");
    }
}
