package de.misslewars.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Settings implements CommandExecutor {

	private Misslewars main;

	public Settings(Misslewars misslewars) {
		this.main = misslewars;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		Player p = (Player) sender;
		if(args.length == 0) {
			if(!p.hasPermission("misslewars.settings")) {p.sendMessage("§3[Misslewars]: §cAchtung der Zugriff auf diesen Command wurde verweigert!");}
			main.setIsActive(false);
			main.setIsSettings(true);
			p.sendMessage("§cDu kannst nun dies in den Chat schreiben:\n -red: setzt den Spawn für Team Rot!\n -blue: setzt den Spawn für Team Blau!\n -spec: setzt den Spawn für Spectator!\n -fertig: beendet das Settingsmenü!\n-lobby: setzt die lobby!");
			for(Player player : Bukkit.getOnlinePlayers()) {
				if(player != p) {
					player.kickPlayer("§cDer Server wird zurzeit bearbeitet!");
				}
			}
		}
		return true;
	}

}
