package com.github.ferrari.util;

import com.github.ferrari.AnotherMotdPlugin;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

        private AnotherMotdPlugin plugin;

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
                    "§6Gerenciar motd's",
                    "§7Clique para setar o motd",
                    null
            ));
            inv.setItem(33, setitem(
                    Material.REDSTONE,
                    "§6Restaurar motd",
                    "§7Clique para restaurar o motd",
                    null
            ));
            return inv;
        }
        public static org.bukkit.inventory.Inventory manageInventory() {
            org.bukkit.inventory.Inventory inv = Bukkit.createInventory(null, 54, "§aGerenciar motd");
            inv.setItem(12, setitem(
                    Material.PAPER,
                    "§6Criar MOTD 1",
                    AnotherMotdPlugin.getPlugin(AnotherMotdPlugin.class).getConfig().getString("motd1").replace("&", "§"),
                    "§7Clique para criar a motd 1 no seu servidor"
            ));
            inv.setItem(13, setitem(
                    Material.PAPER,
                    "§6Criar MOTD 2",
                    AnotherMotdPlugin.getPlugin(AnotherMotdPlugin.class).getConfig().getString("motd2").replace("&", "§"),
                    "§7Clique para criar a motd 2 no seu servidor"
            ));
            inv.setItem(14, setitem(
                    Material.PAPER,
                    "§6Criar MOTD 3",
                    AnotherMotdPlugin.getPlugin(AnotherMotdPlugin.class).getConfig().getString("motd3").replace("&", "§"),
                    "§7Clique para criar a motd 3 no seu servido"
            ));
            inv.setItem(21, setitem(
                    Material.EMERALD_BLOCK,
                    "§6Setar Motd 1",
                    "§7Clique para setar a motd 1 no seu servidor",
                    null
            ));
            inv.setItem(22, setitem(
                    Material.EMERALD_BLOCK,
                    "§6Setar Motd 2",
                    "§7Clique para setar a motd 2 no seu servidor",
                    null
            ));
            inv.setItem(23, setitem(
                    Material.EMERALD_BLOCK,
                    "§6Setar Motd 3",
                    "§7Clique para setar a motd 3 no seu servidor",
                    null
            ));
            inv.setItem(40, setitem(
                    Material.REDSTONE,
                    "§cVoltar",
                    "§7Clique para voltar ao menu anterior",
                    null
            ));
            return inv;
        }
}

