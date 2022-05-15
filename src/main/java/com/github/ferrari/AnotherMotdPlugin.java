package com.github.ferrari;

import com.github.ferrari.commands.*;
import com.github.ferrari.listener.ServerListener;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import me.saiintbrisson.minecraft.ViewFrame;
import me.saiintbrisson.minecraft.command.message.MessageHolder;
import me.saiintbrisson.minecraft.command.message.MessageType;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.*;

public class AnotherMotdPlugin extends JavaPlugin {


    private BukkitFrame bukkitFrame;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {


        registerCommands();
        registerListeners();
    }

    private void registerCommands() {
       /* getCommand("setarmotd").setExecutor(new MotdCommand());
        getCommand("vermotd").setExecutor(new ShowMotdCommand());
        getCommand("restaurarmotd").setExecutor(new RestoreMotdCommand());
        getCommand("gui").setExecutor(new GuiCommand());*/

        bukkitFrame = new BukkitFrame(this);

        MessageHolder messageHolder = bukkitFrame.getMessageHolder();
        messageHolder.setMessage(
                MessageType.NO_PERMISSION, "§cVocê não tem permissão para executar este comando!"
        );

        bukkitFrame.registerCommands(
                new CommandMotd(this)
        );
    }

    private void registerListeners() {
        PluginManager pluginManager = getPluginManager();

        pluginManager.registerEvents(new ServerListener(this), this );
    }
}

