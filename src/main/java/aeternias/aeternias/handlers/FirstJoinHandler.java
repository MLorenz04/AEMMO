package aeternias.aeternias.handlers;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.Bukkit;
import aeternias.aeternias.Aeternias;
import aeternias.aeternias.Properties;

public class FirstJoinHandler implements Listener {
    public FirstJoinHandler(Aeternias a1) {
        Bukkit.getPluginManager().registerEvents(this, a1);
    }

    @EventHandler
    public void PlayerJoin(PlayerLoginEvent event) {
        if(!event.getPlayer().hasPlayedBefore()) {
            Player p = event.getPlayer();
            List<Cathegory> list = new ArrayList<>();
            list.add(new Cathegory("mining", 0, 1));
            list.add(new Cathegory("lumberjacking", 0, 1));
            list.add(new Cathegory("building", 0, 1));
            list.add(new Cathegory("digging", 0, 1));
            SerializationHandler.serializeCathegories(list, "plugins/AEMMO/users/" + p.getPlayer().getUniqueId() + ".yaml");
            Bukkit.getLogger().info(Properties.prefix + "Soubor vytvoren");
        }
    }
}
