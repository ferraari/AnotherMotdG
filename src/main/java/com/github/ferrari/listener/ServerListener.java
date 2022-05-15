package com.github.ferrari.listener;

import com.github.ferrari.AnotherMotdPlugin;
import lombok.AllArgsConstructor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

        e.setMotd(config.getString("motd").replace("&", "§" ).replace("$n", "\n"));
        e.setMaxPlayers(e.getNumPlayers() + 1);
    }
}