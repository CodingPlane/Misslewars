package de.misslewars.timetask;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import de.misslewars.api.HasMapAPI;
import de.misslewars.api.SetRadomTeam;
import de.misslewars.enums.GameStates;
import de.misslewars.main.Misslewars;

public class Timer extends HasMapAPI{

	private static Misslewars main;
	private static Integer i;

	public static Integer getCountDown = 20;
	
	@SuppressWarnings("static-access")
	public Timer(Misslewars misslewars) {
		this.main = misslewars;
	}

	public static void tick() {
		i = Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
			
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				switch(main.getGm()) {
					case LOBBY:
						for(Player p : Bukkit.getOnlinePlayers()) {
							if(main.isActive) {
								if(getPlayers() >= main.getMinPlayer()) {
									if(getPlayers() >= main.getMaxPlayer()){
										if(getCountDown >= 10) {
											getCountDown = 10;
										}
									}
									if(getCountDown == 50) {
										p.sendMessage("§3[Misslewars]:§6 Das Spiel startet in 50 Sekunden!");
									}
									if(getCountDown == 10) {
										if(!main.Team.containsKey(p)) {
											SetRadomTeam.SetRadomTeams(p);
											System.out.println("test");
										}
										p.sendMessage("§3[Misslewars]:§6 Das Spiel startet in 10 Sekunden");
										p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1, 1);
									}
									if(getCountDown == 5) {
										p.sendMessage("§3[Misslewars]: §6Das Spiel startet in 5 Sekunden!");
										p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1, 1);
									}
									if(getCountDown == 4) {
										p.sendMessage("§3[Misslewars]: §6Das Spiel startet in 4 Sekunden!");
									}
									if(getCountDown == 3) {
										p.sendMessage("§3[Misslewars]: §6Das Spiel startet in 3 Sekunden!");
									}
									if(getCountDown == 2) {
										p.sendMessage("§3[Misslewars]: §6Das Spiel startet in 2 Sekunden!");
									}
									if(getCountDown == 1) {
										p.sendMessage("§3[Misslewars]: §6Das Spiel startet in 1 Sekunden!");
										p.playSound(p.getLocation(), Sound.CHEST_CLOSE, 1, 1);
									}
									if(getCountDown == 0) {
										p.getInventory().clear();
										setSpawn();
										main.setGm(GameStates.INGAME);
										getCountDown = 50;
									}
									p.setLevel(getCountDown);
									getCountDown --;
								}else {
									getCountDown = 20;
									p.sendMessage("§3[Misslewars]:§6 Der Spielstart wurde gestopt!");
									System.out.println("test");
								}
							}
						}
					break;
					case INGAME:
					
					break;
					case RESET:
						
						break;
				}
			}
		}, 0, 20);
	}
	
	public static void setSpawn() {
		if(main.getConfig().get("Config.Spawn.Blue") == null) {return;}
		if(main.getConfig().get("Config.Spawn.Red") == null) {return;}
		Location locBlue = (Location) main.getConfig().get("Config.Spawn.Blue");
		Location locRed = (Location) main.getConfig().get("Config.Spawn.Red");
		for(Player player: Bukkit.getOnlinePlayers()) {
			if(main.Team.containsKey(player)) {
				if(main.Team.get(player).equalsIgnoreCase("Blue")) {
					player.teleport(locBlue);
				}else if(main.Team.get(player).equalsIgnoreCase("Red")) {
					player.teleport(locRed);
				}
			}
		}
	}
	
	public static void Killtask() {
		Bukkit.getScheduler().cancelTask(i);
	}
}
