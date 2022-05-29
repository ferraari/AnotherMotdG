package com.github.ferrari.commands;

import com.github.ferrari.AnotherMotdPlugin;
import com.github.ferrari.util.Inventory;
import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

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
            name = "cancelar",
            permission = "motd.set"
    )
    public void cancelMotd(Context<CommandSender> c) {
        CommandSender sender = c.getSender();
        plugin.players.remove(((Player) sender).getUniqueId());
        sender.sendMessage("§cCancelado com sucesso!");
    }
    @Command(
            name = "motd.gerenciar",
            permission = "motd.set"
    )
    public void motdManage(Context<CommandSender> c) {
        Player p = (Player) c.getSender();
        p.openInventory(Inventory.manageInventory());
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
                String.format("%s", motd).replace("&", "§").replace("@n", "\n")
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
            name = "createmotd",
            permission = "motd.set"
    )
    public void onSet2(Context<CommandSender> context, int number) {
        Player player = (Player) context.getSender();

        if (number == 1) {
            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
            player.sendMessage("§aDigite o motd que deseja setar");
            player.sendMessage("§aDigite §c/cancelar§a para cancelar");
            player.sendMessage("§aUtilize §6@n§a para quebrar linha");
            plugin.m1.add(((Player) context.getSender()).getUniqueId());
        }
        if (number == 2) {
            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
            player.sendMessage("§aDigite o motd que deseja setar");
            player.sendMessage("§aDigite §c/cancelar§a para cancelar");
            player.sendMessage("§aUtilize §6@n§a para quebrar linha");
            plugin.m2.add(((Player) context.getSender()).getUniqueId());
        }
        if (number == 3) {
            player.playSound(player.getLocation(), Sound.NOTE_BASS, 1, 1);
            player.sendMessage("§aDigite o motd que deseja setar");
            player.sendMessage("§aDigite §c/cancelar§a para cancelar");
            player.sendMessage("§aUtilize §6@n§a para quebrar linha");
            plugin.m3.add(((Player) context.getSender()).getUniqueId());
        }
    }
    @Command(
            name = "setmotd",
            permission = "motd.set"
    )
    public void setMotd(Context<CommandSender> c, int number) {
        if (number == 1) {
            plugin.getConfig().set("motd", plugin.getConfig().getString("motd1"));
            c.sendMessage("§aMotd setado com sucesso!");
        }
        if (number == 2) {
            plugin.getConfig().set("motd", plugin.getConfig().getString("motd2"));
            c.sendMessage("§aMotd setado com sucesso!");
        }
        if (number == 3) {
            plugin.getConfig().set("motd", plugin.getConfig().getString("motd3"));
            c.sendMessage("§aMotd setado com sucesso!");
        }
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
