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
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Setar motd")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "motd setar");
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Restaurar motd")) {
                plugin.getServer().dispatchCommand(e.getWhoClicked(), "motd restaurar");
                p.closeInventory();
            }

        }



    }
}
