package com.github.ferrari.commands;

import com.github.ferrari.AnotherMotdPlugin;
import com.github.ferrari.util.Inventory;
import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommandYamlParser;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEditBookEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


@AllArgsConstructor
public class CommandMotd {

    private AnotherMotdPlugin plugin;

    @Command(
            name = "motd",
            permission = "motd.set",
            description = "Set you motd"
    )
    public void onMotd(Context<CommandSender> context) {
        Player p = (Player) context.getSender();
        p.openInventory(Inventory.getInventory());

    }

    @Command(
            name = "motd.ver",
            aliases = {"ver", "view", "mostrar"},
            description = "Show u motd",
            permission = "motd.set"
    )
    public void onShow(Context<CommandSender> context) {
        FileConfiguration config = plugin.getConfig();

        if (!config.contains("motd")) {
            context.sendMessage("§cNão existe um motd atualmente, use /motd setar <argumento>");
            return;
        }

        String motd = config.getString("motd");

        context.sendMessage(new String[] {
                "§aSeu motd é:",
                String.format("%s", motd)
        });
    }

    @Command(
            name = "motd.setar",
            aliases = {"set", "colocar"},
            description = "Set u motd",
            permission = "motd.set",
            target = CommandTarget.PLAYER
    )
    public void onSet(Context<CommandSender> context, @Optional String[] args) {
        CommandSender sender = context.getSender();

            Player player = (Player) sender;
            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
            player.sendMessage("§aDigite o motd que deseja setar");
            player.sendMessage("§aDigite §c/cancelar§a para cancelar");
            player.sendMessage("§aUtilize §6@n§a para quebrar linha");
            plugin.players.add(((Player) sender).getUniqueId());
    }

    @Command(
            name = "motd.restaurar",
            aliases = {"restaurar", "resetar"},
            description = "Restore u motd",
            permission = "motd.set"
    )
    public void onRestore(Context<CommandSender> context) {
        FileConfiguration config = plugin.getConfig();
        config.set("motd", "Default Another Motd Plugin");
        plugin.saveConfig();

        CommandSender sender = context.getSender();
        sender.sendMessage("§aO motd foi restaurada com sucesso!");

    }
}
