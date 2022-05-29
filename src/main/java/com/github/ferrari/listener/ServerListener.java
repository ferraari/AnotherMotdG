package com.github.ferrari.listener;

import com.github.ferrari.AnotherMotdPlugin;
import lombok.AllArgsConstructor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.server.ServerListPingEvent;


@AllArgsConstructor
public class ServerListener implements Listener {

    private AnotherMotdPlugin plugin;



    @EventHandler
    public void ServerPing(ServerListPingEvent e) {
        FileConfiguration config = plugin.getConfig();
        if ( !config.contains("motd")) {
            return;
        }

        e.setMotd(config.getString("motd").replace("&", "§" ).replace("@n", "\n"));
        e.setMaxPlayers(e.getNumPlayers() + 1);
    }

    @EventHandler
    public void getString(AsyncPlayerChatEvent e) {
        if (plugin.players.contains(e.getPlayer().getUniqueId())) {

            TextComponent aqui = new TextComponent(" §aClique §naqui§a para ver seu MOTD!");
            aqui.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/motd ver"));
            aqui.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aClique aqui para ver o motd").create()));
            FileConfiguration config = plugin.getConfig();

            config.set("motd", e.getMessage());
            e.getPlayer().sendMessage("§aMOTD setado com sucesso!");
            e.getPlayer().spigot().sendMessage(aqui);
            plugin.players.remove(e.getPlayer().getUniqueId());
            plugin.saveConfig();
        }
    }
    @EventHandler
    public void mutePlayer(AsyncPlayerChatEvent e) {
        if (plugin.players.contains(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }
}