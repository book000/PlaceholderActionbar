package com.tomacheese.PlaceholderActionbar.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.tomacheese.PlaceholderActionbar.Main;

public class Cmd_PlaceholderActionbar implements CommandExecutor {
	JavaPlugin plugin;

	public Cmd_PlaceholderActionbar(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (!player.hasPermission("placeholderactionbar.placeholderactionbar")) {
					sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
							+ "You do not have permission to use this command.");
					return true;
				}
			}
			String onoff = Main.OnOff.containsKey(sender.getName()) && !Main.OnOff.get(sender.getName()) ? "off" : "on";
			sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
					+ "The actionbar display is now " + onoff + ".");
			return true;
		}
		if (args.length == 1 && args[0].equalsIgnoreCase("on")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (!player.hasPermission("placeholderactionbar.on")) {
					sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
							+ "You do not have permission to use this command.");
					return true;
				}
			}
			Main.setOnOff(sender, true);
			sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
					+ "The actionbar display is now on.");
			return true;
		} else if (args.length == 1 && args[0].equalsIgnoreCase("off")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (!player.hasPermission("placeholderactionbar.off")) {
					sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
							+ "You do not have permission to use this command.");
					return true;
				}
			}
			Main.setOnOff(sender, false);
			sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
					+ "The actionbar display is now off.");
			return true;
		} else if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
			// config reload.
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (!player.hasPermission("placeholderactionbar.reload")) {
					sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
							+ "You do not have permission to use this command.");
					return true;
				}
			}
			plugin.reloadConfig();

			FileConfiguration conf = plugin.getConfig();
			if (conf.contains("ActionbarText") && conf.isString("ActionbarText")) {
				Main.ActionbarText = conf.getString("ActionbarText");
			} else {
				sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
						+ "ActionbarText is not defined in the config, or an invalid value is set.");
				sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN + "Use the default value.");
				Main.ActionbarText = conf.getDefaults().getString("ActionbarText");
			}
			if (conf.contains("RefreshTick") && conf.isInt("RefreshTick")) {
				Main.RefreshTick = conf.getInt("RefreshTick");
			} else {
				sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN
						+ "RefreshTick is not defined in the config, or an invalid value is set.");
				sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN + "Use the default value.");
				Main.RefreshTick = conf.getDefaults().getInt("RefreshTick");
			}
			sender.sendMessage("[PlaceholderActionbar] " + ChatColor.GREEN + "Config reloaded.");
			return true;
		}
		return false;
	}

}
