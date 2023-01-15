package me.skully.titul.commands;

import me.skully.titul.Main;
import me.skully.titul.cfg.DBConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TitulCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("titul.set")) {
            if(args.length == 0) {
                for(int i = 0; Main.getInstance().getConfig().getStringList("messages.help").size() > i ;i++) {
                    sender.sendMessage(Main.getInstance().getConfig().getStringList("messages.help").get(i));
                }
            }else {
                if(args[0].equalsIgnoreCase("remove")) {
                    sender.sendMessage(Main.getInstance().getConfig().getString("messages.remove"));
                    DBConfig.customFile.set(sender.getName() + ".titul", null);
                    DBConfig.saveConfig();
                }else {
                    DBConfig.setTitul((Player) sender, args[0]);
                    sender.sendMessage(Main.getInstance().getConfig().getString("messages.set"));
                }
            }
        }
        return true;
    }
}
