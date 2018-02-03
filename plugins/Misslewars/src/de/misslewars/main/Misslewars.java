package de.misslewars.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.misslewars.Listener.onChat;
import de.misslewars.Listener.onInterAcct;
import de.misslewars.Listener.onInventoryClick;
import de.misslewars.Listener.onJoinListener;
import de.misslewars.api.InventoryAPI;
import de.misslewars.api.SetRadomTeam;
import de.misslewars.enums.GameStates;
import de.misslewars.timetask.Timer;

public class Misslewars extends JavaPlugin{

	GameStates gm;
	public Integer MinPlayer = 1;
	public Integer MaxPlayer = 10;
	public Boolean isActive = true; 
	public Boolean isSettings = false;
	public HashMap<Player, String>Team= new HashMap<>();
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("§3[MissleWars]: §c Ist nun Online!");
		loadInstance(getServer().getPluginManager());
		setGm(GameStates.LOBBY);
		Timer.tick();
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		Timer.Killtask();
		super.onDisable();
	}
	
	public void loadInstance(PluginManager pm) {
		//Commands
		Settings cSettings = new Settings(this);
		getCommand("settings").setExecutor(cSettings);
		//Listener
		pm.registerEvents(new onJoinListener(this), this);
		pm.registerEvents(new onInterAcct(), this);
		pm.registerEvents(new onInventoryClick(this), this);
		pm.registerEvents(new onChat(this), this);
		//Instance
		new Timer(this);
		new InventoryAPI(this);
		new SetRadomTeam(this);
	}
	
	public GameStates getGm() {
		return gm;
	}

	public void setGm(GameStates gm) {
		this.gm = gm;
	}

	public Integer getMinPlayer() {
		return MinPlayer;
	}

	public void setMinPlayer(Integer minPlayer) {
		MinPlayer = minPlayer;
	}

	public Integer getMaxPlayer() {
		return MaxPlayer;
	}

	public void setMaxPlayer(Integer maxPlayer) {
		MaxPlayer = maxPlayer;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsSettings() {
		return isSettings;
	}

	public void setIsSettings(Boolean isSettings) {
		this.isSettings = isSettings;
	}
}
