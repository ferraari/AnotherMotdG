package com.github.ferrari.util;

import me.saiintbrisson.minecraft.command.annotation.Optional;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

        public static ItemStack setitem(Material material, String name, @Optional String lore, @Optional String lore2) {
            ItemStack item = new ItemStack(material);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(name);
            ArrayList<String> lores = new ArrayList<>();
            lores.add(lore);
            lores.add(lore2);
            meta.setLore(lores);
            item.setItemMeta(meta);
            return item;
        }
        public static org.bukkit.inventory.Inventory getInventory() {
            org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 54, "§aAnotherMotd");
            inv.setItem(29, setitem(
                    Material.PAPER,
                    "§6Ver motd",
                    "§7Clique para ver o motd",
                    null
            ));
            inv.setItem(22, setitem(
                    Material.SIGN,
                    "§6Setar motd",
                    "§7Clique para setar o motd",
                    null
            ));
            inv.setItem(33, setitem(
                    Material.BOOK,
                    "§6Restaurar motd",
                    "§7Clique para restaurar o motd",
                    null
            ));
            return inv;
        }
}

