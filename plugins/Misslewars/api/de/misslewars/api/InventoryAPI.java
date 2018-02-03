package de.misslewars.api;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import de.misslewars.main.Misslewars;

public class InventoryAPI {

	private static Misslewars main;

	@SuppressWarnings("static-access")
	public InventoryAPI(Misslewars misslewars) {
		this.main = misslewars;
	}

	public static void Inventorys(Inventory inventory, Integer in,Player p) {
		Inventory inv = inventory;
		ItemStack i;
		ItemMeta im;
		switch(in) {
			case 1:
				int teamblue= 0;
				int teamred = 0;
				ArrayList<String>Lore = new ArrayList<>();
				for(Player player : Bukkit.getOnlinePlayers()) {
					if(main.Team.containsKey(player)) {
						if(main.Team.get(player).equalsIgnoreCase("Blue")) {
							teamblue++;
						}else if(main.Team.get(player).equalsIgnoreCase("Red")) {
							teamred ++;
						}
					}
				}
				Lore.add("§c" + teamblue + "/5 Spielern");
				i = new ItemStack(Material.WOOL,1,(short)11);
				im = (ItemMeta) i.getItemMeta();
				im.setDisplayName("§9Blau");
				im.setLore(Lore);
				i.setItemMeta(im);
				inv.setItem(1, i);
				Lore.clear();
				
				Lore.add("§c" + teamred + "/5 Spielern");
				i = new ItemStack(Material.WOOL,1,(short)14);
				im = (ItemMeta)i.getItemMeta();
				im.setDisplayName("§cRot");
				im.setLore(Lore);
				i.setItemMeta(im);
				inv.setItem(7, i);
				
				p.openInventory(inv);
			break;
			case 2:
				int freeSlot = 0;
				i = new ItemStack(Material.SKULL_ITEM,1,(short)3);
				SkullMeta si = (SkullMeta) i.getItemMeta();
				for(Player player : Bukkit.getOnlinePlayers()) {
					if(main.Team.containsKey(player)) {
						if(main.Team.get(player).equalsIgnoreCase("Blue")) {
							si.setOwner(player.getName());
							si.setDisplayName("§9"+player.getName());
							i.setItemMeta(si);
							if(freeSlot == 0) {
								inv.setItem(20, i);
								
							}else if(freeSlot == 1) {
								inv.setItem(22, i);
							}else if(freeSlot == 2) {
								inv.setItem(24, i);
							}else if(freeSlot == 3) {
								inv.setItem(30, i);
							}else if(freeSlot == 4) {
								inv.setItem(32, i);
							}
							freeSlot ++;
						}
					}
				}
				
				i = new ItemStack(Material.BARRIER);
				im = (ItemMeta) i.getItemMeta();
				im.setDisplayName("§cFrei");
				i.setItemMeta(im);
				if(freeSlot == 0) {
					inv.setItem(20, i);
					inv.setItem(22, i);
					inv.setItem(24, i);
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot == 1) {
					inv.setItem(22, i);
					inv.setItem(24, i);
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot == 2) {
					inv.setItem(24, i);
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot == 3) {
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot == 4) {
					inv.setItem(32, i);
				}
				
				i = new ItemStack(Material.WOOL,1,(short)13);
				im = (ItemMeta) i.getItemMeta();
				im.setDisplayName("§3Team Joinen!");
				i.setItemMeta(im);
				inv.setItem(53, i);
				
				
				p.closeInventory();
				p.openInventory(inv);
			break;
			case 3:
				int freeSlot1 = 0;
				i = new ItemStack(Material.SKULL_ITEM,1,(short)3);
				SkullMeta si1 = (SkullMeta) i.getItemMeta();
				for(Player player : Bukkit.getOnlinePlayers()) {
					if(main.Team.containsKey(player)) {
						if(main.Team.get(player).equalsIgnoreCase("Red")) {
							si1.setOwner(player.getName());
							si1.setDisplayName("§c"+player.getName());
							i.setItemMeta(si1);
							if(freeSlot1 == 0) {
								inv.setItem(20, i);
								
							}else if(freeSlot1 == 1) {
								inv.setItem(22, i);
							}else if(freeSlot1 == 2) {
								inv.setItem(24, i);
							}else if(freeSlot1 == 3) {
								inv.setItem(30, i);
							}else if(freeSlot1 == 4) {
								inv.setItem(32, i);
							}
							freeSlot1 ++;
						}
					}
				}
				
				i = new ItemStack(Material.BARRIER);
				im = (ItemMeta) i.getItemMeta();
				im.setDisplayName("§cFrei");
				i.setItemMeta(im);
				if(freeSlot1 == 0) {
					inv.setItem(20, i);
					inv.setItem(22, i);
					inv.setItem(24, i);
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot1 == 1) {
					inv.setItem(22, i);
					inv.setItem(24, i);
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot1 == 2) {
					inv.setItem(24, i);
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot1 == 3) {
					inv.setItem(30, i);
					inv.setItem(32, i);
				}else if(freeSlot1 == 4) {
					inv.setItem(32, i);
				}
				
				i = new ItemStack(Material.WOOL,1,(short)13);
				im = (ItemMeta) i.getItemMeta();
				im.setDisplayName("§3Team Joinen!");
				i.setItemMeta(im);
				inv.setItem(53, i);
				
				
				p.closeInventory();
				p.openInventory(inv);
			break;
		}
	}
}
