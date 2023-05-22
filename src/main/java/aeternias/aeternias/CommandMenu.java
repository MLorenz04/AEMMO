package aeternias.aeternias;

import aeternias.aeternias.commands.Aemmo;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMenu implements CommandExecutor {
    @Override

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            return false;
        }

        Player p1 = (Player) sender;
        switch(label) {
            case "aemmo":
                Aemmo.showMessages(p1);
            case "mining":

        }
        return true;
    }
}
