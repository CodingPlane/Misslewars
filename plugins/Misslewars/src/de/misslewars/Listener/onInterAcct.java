package de.misslewars.Listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.misslewars.api.InventoryAPI;

public class onInterAcct implements Listener {

	@EventHandler
	public void onInter(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			switch(p.getItemInHand().getItemMeta().getDisplayName()) {
				case "§3Teams§8(§cRechtsklick§8)":
					InventoryAPI.Inventorys(Bukkit.createInventory(null, 9,"§3Teams"), 1, p);
				break;
			}
		}
	}
	
}
