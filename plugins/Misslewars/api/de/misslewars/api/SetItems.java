package de.misslewars.api;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetItems {
	
	public static void SetItem(Player p) {
		ItemStack i;
		ItemMeta im;
		
		i = new ItemStack(Material.CHEST);
		im = (ItemMeta) i.getItemMeta();
		im.setDisplayName("§3Teams§8(§cRechtsklick§8)");
		i.setItemMeta(im);
		p.getInventory().setItem(1, i);
		
		i = new ItemStack(Material.BARRIER);
		im = (ItemMeta) i.getItemMeta();
		im.setDisplayName("§cZurück zur Lobby");
		i.setItemMeta(im);
		
		p.getInventory().setItem(7, i);
	}
	
}
