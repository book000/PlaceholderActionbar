package com.tomacheese.PlaceholderActionbar;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import com.tomacheese.PlaceholderActionbar.Command.Cmd_PlaceholderActionbar;
import com.tomacheese.PlaceholderActionbar.Task.Task_ActionbarShow;

public class Main extends JavaPlugin {
	private static JavaPlugin JavaPlugin;
	public static String ActionbarText;
	public static int RefreshTick;
	public static BukkitTask task = null;
	public static HashMap<String, Boolean> OnOff;

	/**
	 * called when enable plugin
	 * @author mine_book000
	 * @since 2020/04/17
	 */
	@Override
	public void onEnable() {
		JavaPlugin = this;
		getLogger().info("PlaceholderActionbar created by Tomachi (mine_book000)");
		getLogger().info("ProjectPage: https://github.com/book000/PlaceholderActionbar");

		getConfig().options().copyDefaults(true);
		saveDefaultConfig();

		FileConfiguration conf = getConfig();
		if (conf.contains("ActionbarText") && conf.isString("ActionbarText")) {
			ActionbarText = conf.getString("ActionbarText");
		} else {
			getLogger().warning("ActionbarText is not defined in the config, or an invalid value is set.");
			getLogger().warning("Use the default value.");
			ActionbarText = conf.getDefaults().getString("ActionbarText");
		}
		if (conf.contains("RefreshTick") && conf.isInt("RefreshTick")) {
			RefreshTick = conf.getInt("RefreshTick");
		} else {
			getLogger().warning("RefreshTick is not defined in the config, or an invalid value is set.");
			getLogger().warning("Use the default value.");
			RefreshTick = conf.getDefaults().getInt("RefreshTick");
		}

		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI");

		if (plugin == null || !plugin.isEnabled()) {
			getLogger().warning("PlaceholderAPI is not enabled. This plugin does not work.");
			return;
		}

		File file = new File(getDataFolder(), "playerOnOff.yml");
		if (!file.exists()) {
			try {
				new YamlConfiguration().save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileConfiguration onoffconfig = YamlConfiguration.loadConfiguration(file);
		OnOff = new HashMap<String, Boolean>();
		for (String key : onoffconfig.getKeys(false)) {
			OnOff.put(key, onoffconfig.getBoolean(key));
		}

		getCommand("placeholderactionbar").setExecutor(new Cmd_PlaceholderActionbar(this));

		if (task != null && !task.isCancelled())
			task.cancel();
		task = new Task_ActionbarShow().runTaskTimer(this, 0L, RefreshTick);
	}

	public static JavaPlugin getJavaPlugin() {
		return JavaPlugin;
	}

	public static boolean isOn(String name) {
		if (OnOff.containsKey(name)) {
			return OnOff.get(name);
		}
		return true;
	}

	public static void setOnOff(CommandSender sender, boolean bool) {
		OnOff.put(sender.getName(), bool);
		File file = new File(Main.getJavaPlugin().getDataFolder(), "playerOnOff.yml");
		FileConfiguration onoffconfig = YamlConfiguration.loadConfiguration(file);
		onoffconfig.set(sender.getName(), bool);
		try {
			onoffconfig.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
