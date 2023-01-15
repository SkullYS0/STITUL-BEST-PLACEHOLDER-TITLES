package me.skully.titul;

import me.skully.titul.cfg.DBConfig;
import me.skully.titul.commands.TitulCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    TitulHolder titulHold = new TitulHolder();

    private static Main instance;

    @Override
    public void onEnable() {

        System.out.println("\n" +
                "░██████╗██╗░░██╗██╗░░░██╗██╗░░░░░██╗░░░░░██╗░░░██╗░██████╗██████╗░░█████╗░░█████╗░███████╗\n" +
                "██╔════╝██║░██╔╝██║░░░██║██║░░░░░██║░░░░░╚██╗░██╔╝██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝\n" +
                "╚█████╗░█████═╝░██║░░░██║██║░░░░░██║░░░░░░╚████╔╝░╚█████╗░██████╔╝███████║██║░░╚═╝█████╗░░\n" +
                "░╚═══██╗██╔═██╗░██║░░░██║██║░░░░░██║░░░░░░░╚██╔╝░░░╚═══██╗██╔═══╝░██╔══██║██║░░██╗██╔══╝░░\n" +
                "██████╔╝██║░╚██╗╚██████╔╝███████╗███████╗░░░██║░░░██████╔╝██║░░░░░██║░░██║╚█████╔╝███████╗\n" +
                "╚═════╝░╚═╝░░╚═╝░╚═════╝░╚══════╝╚══════╝░░░╚═╝░░░╚═════╝░╚═╝░░░░░╚═╝░░╚═╝░╚════╝░╚══════╝\n" +
                "\n" +
                "░██████╗████████╗██╗████████╗██╗░░░██╗██╗░░░░░\n" +
                "██╔════╝╚══██╔══╝██║╚══██╔══╝██║░░░██║██║░░░░░\n" +
                "╚█████╗░░░░██║░░░██║░░░██║░░░██║░░░██║██║░░░░░\n" +
                "░╚═══██╗░░░██║░░░██║░░░██║░░░██║░░░██║██║░░░░░\n" +
                "██████╔╝░░░██║░░░██║░░░██║░░░╚██████╔╝███████╗\n" +
                "╚═════╝░░░░╚═╝░░░╚═╝░░░╚═╝░░░░╚═════╝░╚══════╝\n" +
                "ENABLED ( https://skully.space )");

        instance = this;
        saveDefaultConfig();
        DBConfig.createFile();
        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            titulHold.register();
        }
        getServer().getPluginCommand("settitul").setExecutor(new TitulCommand());
    }

    @Override
    public void onDisable() {
        instance = null;
        titulHold.unregister();
    }

    public static Main getInstance() {
        return instance;
    }
}
