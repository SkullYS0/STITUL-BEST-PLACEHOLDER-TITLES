package me.skully.titul;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.skully.titul.cfg.DBConfig;
import org.bukkit.entity.Player;

public class TitulHolder extends PlaceholderExpansion {

    public String getAuthor() {
        return "skully";
    }

    public String getIdentifier() {
        return "stitles";
    }

    public String getVersion() {
        return "1.0.0";
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        if (identifier.equals("titul")) {
            if(!DBConfig.customFile.contains(p.getName() + ".titul")) {
                return Main.getInstance().getConfig().getString("messages.none");
            }else if(DBConfig.customFile.getString(p.getName()+".titul").equalsIgnoreCase("THIS TITUL HAS BEEN REMOVED") ){
                return Main.getInstance().getConfig().getString("messages.none");
            }else{
                return DBConfig.customFile.getString(p.getName() + ".titul");
            }
        } else {
            return "ERROR";
        }
    }
}
