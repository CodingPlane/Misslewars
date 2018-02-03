package de.misslewars.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.misslewars.api.InventoryAPI;
import de.misslewars.main.Misslewars;

public class onInventoryClick implements Listener {

	@SuppressWarnings("unused")
	private Misslewars main;

	public onInventoryClick(Misslewars misslewars) {
		this.main = misslewars;
	}

	@EventHandler
	public void onInv(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if(e.getClickedInventory() == null) {
			return;
		}
		if(e.getCurrentItem() == null) {
			return;
		}
		if(e.getCurrentItem().getItemMeta() == null) {
			return;
		}
		if(e.getInventory().getName().equalsIgnoreCase("§3Teams")) {
			e.setCancelled(true);
			switch(e.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§9Blau":
					InventoryAPI.Inventorys(Bukkit.createInventory(null, 54, "§9Blau"), 2, p);
				break;
				case "§cRot":
					InventoryAPI.Inventorys(Bukkit.createInventory(null, 54, "§cRot"), 3, p);
				break;
			}
		}else if(e.getInventory().getName().equalsIgnoreCase("§9Blau")) {
			e.setCancelled(true);
			switch(e.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§3Team Joinen!":
					if(main.Team.containsKey(p)) {
						if(main.Team.get(p).equalsIgnoreCase("Blue")) {p.sendMessage("§3[Misslewars]: §cDu bist bereits im Blauen Team!"); p.closeInventory(); return;}
						main.Team.remove(p);
						main.Team.put(p, "Blue");
						sendTeamMessage(p);
						p.setPlayerListName("§9"+p.getName());
					}else {main.Team.put(p, "Blue"); p.sendMessage("§3[Misslewars]: §cDu bist dem Blauen Team beigetreten!"); sendTeamMessage(p); p.setPlayerListName("§9"+p.getName());}
					p.closeInventory();
				break;
			}
		}else if(e.getInventory().getName().equalsIgnoreCase("§cRot")) {
			e.setCancelled(true);
			switch(e.getCurrentItem().getItemMeta().getDisplayName()) {
				case "§3Team Joinen!":
					if(main.Team.containsKey(p)) {
						if(main.Team.get(p).equalsIgnoreCase("Red")) {p.sendMessage("§3[Misslewars]: §cDu bist bereits im Blauen Team!"); p.closeInventory(); return;}
						main.Team.remove(p);
						main.Team.put(p, "Red");
						sendTeamMessage(p);
						p.setPlayerListName("§c"+p.getName());
					}else {main.Team.put(p, "Red"); p.sendMessage("§3[Misslewars]: §cDu bist dem Blauen Team beigetreten!"); sendTeamMessage(p); p.setPlayerListName("§c"+p.getName());}
					p.closeInventory();
				break;
			}
		}
	}
	
	public void sendTeamMessage(Player p) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(main.Team.containsKey(player)) {
				if(main.Team.get(player).equalsIgnoreCase("Blue")) {
					if(player == p) {return;}
					player.sendMessage("§9[Team]: §c" + p.getName() + " ist dem Team beigetreten!");
				}
			}
		}
	}
	
}
