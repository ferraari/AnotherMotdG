package com.github.ferrari.commands;

import com.github.ferrari.AnotherMotdPlugin;
import lombok.AllArgsConstructor;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.annotation.Optional;
import me.saiintbrisson.minecraft.command.command.Context;
import me.saiintbrisson.minecraft.command.target.CommandTarget;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.lang.StringUtils;
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
        context.sendMessage(new String[] {
                "v1.0 §6AnotherMotd§8 - Lista de Comandos",
                "§f - §6/motd ver§8 - Mostra o MOTD",
                "§f - §6/motd setar <argumento> §8 - Seta o MOTD",
                "§f - §6/motd restaurar§8 - Restaura o MOTD"
        });
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
            permission = "motd.set"
    )
    public void onSet(Context<CommandSender> context, @Optional String[] args) {
        if (args == null) {
            context.sendMessage("§cVocê precisa digitar um argumento, exemplo: /motd setar <argumento>");
            return;
        }

        FileConfiguration config = plugin.getConfig();
        String message = StringUtils.join(args, " ", 0, args.length);
        config.set("motd", message);
        plugin.saveConfig();

        CommandSender sender = context.getSender();

        if (sender instanceof Player) {
            TextComponent aqui = new TextComponent(" §aClique §naqui§a para ver seu MOTD!");
            aqui.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/motd ver"));
            aqui.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aClique aqui para ver o motd").create()));



            ((Player) sender).sendMessage("§aVocê setou o seu motd com sucesso,");
            ((Player) sender).spigot().sendMessage(aqui);
            ((Player) sender).playSound(((Player) sender).getLocation(), Sound.NOTE_BASS, 1, 1);
            return;
        }

        context.sendMessage("§aO motd foi atualizado com sucesso!");
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
