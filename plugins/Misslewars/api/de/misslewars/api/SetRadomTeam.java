package de.misslewars.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.misslewars.main.Misslewars;

public class SetRadomTeam {

	private static Misslewars main;

	@SuppressWarnings("static-access")
	public SetRadomTeam(Misslewars misslewars) {
		this.main = misslewars;
	}

	public static void SetRadomTeams(Player p) {
		int freeslotblue = 0;
		int freeslotred = 0;
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(main.Team.containsKey(player)) {
				if(main.Team.get(player).equalsIgnoreCase("Blue")) {freeslotblue ++;}
				if(main.Team.get(player).equalsIgnoreCase("Red")) {freeslotred ++;}
			}
		}
		if(freeslotblue < 5) {main.Team.put(p, "Blue"); return;}
		if(freeslotred < 5) {main.Team.put(p, "Red"); return;}
	}
}
