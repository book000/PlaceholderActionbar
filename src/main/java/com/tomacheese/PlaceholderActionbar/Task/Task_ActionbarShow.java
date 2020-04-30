package com.tomacheese.PlaceholderActionbar.Task;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.tomacheese.PlaceholderActionbar.Main;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

public class Task_ActionbarShow extends BukkitRunnable {
	@Override
	public void run() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (!Main.isOn(player.getName())) {
				continue;
			}
			String ActionbarText = Main.ActionbarText;
			ActionbarText = PlaceholderAPI.setPlaceholders(player, ActionbarText);
			sendActionbar(player, ActionbarText);
		}
	}

	public static void sendActionbar(Player player, String msg) {
		BaseComponent[] component = TextComponent.fromLegacyText(msg);
		player.spigot().sendMessage(ChatMessageType.ACTION_BAR, component);
	}
}
