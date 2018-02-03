package de.misslewars.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.misslewars.api.HasMapAPI;
import de.misslewars.api.SetItems;
import de.misslewars.enums.GameStates;
import de.misslewars.main.Misslewars;

public class onJoinListener extends HasMapAPI implements Listener {

	private Misslewars main;

	public onJoinListener(Misslewars misslewars) {
		this.main = misslewars;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if(main.isSettings) {if(!p.hasPermission("misslewars.ignoresetting")) {p.kickPlayer("§cDer Server wird zurzeit bearbeitet!"); return;}}
		if(getPlayers() < main.getMaxPlayer()) {
			if(main.getGm().equals(GameStates.LOBBY)) {
				SetItems.SetItem(p);
				addPlayer(p);
				e.setJoinMessage("§3[Misslewars]: §6 Spieler §c" + p.getName()  + " §6 hast den Server betreten!");
			}else {
				//OutSpawn!
			}
		}else {
			//Hier spawnen
		}
		
	}
	
}
