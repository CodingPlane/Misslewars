package de.misslewars.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import de.misslewars.main.Misslewars;

@SuppressWarnings("deprecation")
public class onChat implements Listener {

	private Misslewars main;

	public onChat(Misslewars misslewars) {
		this.main = misslewars;
	}

	@EventHandler
	public void onChatlist(PlayerChatEvent e) {
		Player p = e.getPlayer();
		if(e.getMessage().equalsIgnoreCase("red")) {
			e.setCancelled(true);
			main.getConfig().set("Config.Spawn.Red", p.getLocation());
			main.saveConfig();
			p.sendMessage("§3[Misslewars]: §6 Der Spawn für Team Rot wurde gesetzt!\n §cx:§6 " + p.getLocation().getX() + " §cy:§6 " + p.getLocation().getY() + " §cz§6: " + p.getLocation().getBlockZ());
			return;
		}else if(e.getMessage().equalsIgnoreCase("blue")) {
			e.setCancelled(true);
			main.getConfig().set("Config.Spawn.Blue", p.getLocation());
			main.saveConfig();
			p.sendMessage("§3[Misslewars]: §6 Der Spawn für Team Blau wurde gesetzt!\n §cx:§6 " + p.getLocation().getX() + " §cy:§6 " + p.getLocation().getY() + " §cz§6: " + p.getLocation().getBlockZ());
			return;
		}else if(e.getMessage().equalsIgnoreCase("spec")) {
			e.setCancelled(true);
			main.getConfig().set("Config.Spawn.Spec", p.getLocation());
			main.saveConfig();
			p.sendMessage("§3[Misslewars]: §6 Der Spawn für die Spectator wurde gesetzt!\n §cx:§6 " + p.getLocation().getX() + " §cy:§6 " + p.getLocation().getY() + " §cz§6: " + p.getLocation().getBlockZ());
			return;
		}else if(e.getMessage().equalsIgnoreCase("fertig")) {
			e.setCancelled(true);
			p.sendMessage("§3[Misslewars]: §6 Das Spiel geht nun weiter!");
			main.setIsActive(true);
			main.setIsSettings(false);
			return;
		}else if(e.getMessage().equalsIgnoreCase("lobby")) {
			e.setCancelled(true);
			main.getConfig().set("Config.Spawn.Lobby", p.getLocation());
			main.saveConfig();
			p.sendMessage("§3[Misslewars]: §6 Der Lobby Spawn wurde gesetzt!\n §cx:§6 " + p.getLocation().getX() + " §cy:§6 " + p.getLocation().getY() + " §cz§6: " + p.getLocation().getBlockZ());
		}
	}
	
}
