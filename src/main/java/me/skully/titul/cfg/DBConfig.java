package me.skully.titul.cfg;

import me.skully.titul.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class DBConfig {


    public static FileConfiguration customFile;
    private static File file;

    public static void createFile() {
        file = new File(Main.getInstance().getDataFolder(), "database.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {
                file.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static void saveConfig() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setTitul(Player sender, String titul) {
            customFile.set(sender.getName() + ".titul", titul.replace("&","§"));
            saveConfig();
    }
}
