package aeternias.aeternias.commands;

import aeternias.aeternias.Properties;
import aeternias.aeternias.handlers.Cathegory;
import aeternias.aeternias.handlers.SerializationHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Aemmo {
    public static void showMessages(Player p1) {
                List<Cathegory> list = SerializationHandler.deserializeCathegories("plugins/AEMMO/users/" + p1.getUniqueId() + ".yaml");
                try {
                    p1.sendMessage(ChatColor.GREEN + Properties.header);
                    p1.sendMessage(ChatColor.AQUA + "Těžení: " + list.get(0).getExp());
                    p1.sendMessage(ChatColor.AQUA + "Dřevorubectví: " + list.get(1).getExp());
                    p1.sendMessage(ChatColor.AQUA + "Stavění: " + list.get(2).getExp());
                    p1.sendMessage(ChatColor.AQUA + "Kopání: " + list.get(3).getExp());
                } catch(Exception e) {
                    e.printStackTrace();
                }
        }
    }
