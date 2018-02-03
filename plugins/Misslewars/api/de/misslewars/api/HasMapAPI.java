package de.misslewars.api;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class HasMapAPI {
	static ArrayList<Player>joinPlayer = new ArrayList<>();
	
	public boolean playerExist(Player p) {return joinPlayer.contains(p);}
	
	public void addPlayer(Player p) {joinPlayer.add(p);}
	
	public void removePlayer(Player p) {joinPlayer.remove(p);}
	
	public void clearList() {joinPlayer.clear();}
	
	public static Integer getPlayers() {return joinPlayer.size();}
}
