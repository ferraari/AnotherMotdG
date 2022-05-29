package com.github.ferrari.listener;

import com.github.ferrari.AnotherMotdPlugin;
import com.github.ferrari.util.Inventory;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;



@AllArgsConstructor
public class InventoryListener implements Listener {

    private AnotherMotdPlugin plugin;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§aAnotherMotd")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Ver motd")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "motd ver");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Gerenciar motd's")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "motd gerenciar");
                p.closeInventory();
                p.openInventory(Inventory.manageInventory());
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Restaurar motd")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "motd restaurar");
                p.closeInventory();
            }
        }
        if (e.getInventory().getName().equals("§aGerenciar motd")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Setar Motd 1")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "setmotd 1");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Setar Motd 2")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "setmotd 2");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Setar Motd 3")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "setmotd 3");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Criar MOTD 1")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "createmotd 1");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Criar MOTD 2")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "createmotd 2");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Criar MOTD 3")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "createmotd 3");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cVoltar")) {
                p.closeInventory();
                p.openInventory(Inventory.getInventory());
            }


        }



    }
}
