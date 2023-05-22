package aeternias.aeternias.handlers;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.Material;
import aeternias.aeternias.Aeternias;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Handler implements Listener {

    public HashMap<Material, Integer>  mining_blocks = new HashMap<>();
    public HashMap<Material, Integer> lumberjacking_blocks = new HashMap<>();
    public HashMap<Material, Integer>  building_block =  new HashMap<>();
    public HashMap<Material, Integer> digging_blocks = new HashMap<>();

    public List<HashMap<Material, Integer>> list = new ArrayList<>();
    public Handler(Aeternias p1) {
        Bukkit.getPluginManager().registerEvents(this, p1);
        this.mining_blocks.put(Material.STONE, 1);
        this.lumberjacking_blocks.put(Material.OAK_WOOD,3);
        this.building_block.put(Material.OAK_PLANKS,1);
        this.digging_blocks.put(Material.GRASS_BLOCK,2);
        this.list.add(this.mining_blocks);
        this.list.add(this.lumberjacking_blocks);
        this.list.add(this.building_block);
        this.list.add(this.digging_blocks);
    }

    @EventHandler
    public void checkForBreak(BlockBreakEvent breakEvent) {
        // INDEXY
        // Mining - 0
        // Lumberjacking - 1
        // Building - 2
        // Digging - 3
        int index = 0;
        int exp;
        for (HashMap<Material, Integer> hashMap : list) {
            if(hashMap.containsKey(breakEvent.getBlock().getType())) {
                exp = hashMap.get(breakEvent.getBlock().getType());
                Bukkit.getLogger().info("Přidávám expy pro kategorii" + index);
                SerializationHandler.updateYaml("plugins/AEMMO/users/" + breakEvent.getPlayer().getUniqueId() + ".yaml",index,exp);
                break;
            }
            index++;
        }
    }
    @EventHandler
    public void checkForPlace(BlockPlaceEvent placeEvent) {
        // INDEXY
        // Mining - 0
        // Lumberjacking - 1
        // Building - 2
        // Digging - 3
        int index = 0;
        int exp;
        for (HashMap<Material, Integer> hashMap : list) {
            if(hashMap.containsKey(placeEvent.getBlock().getType())) {
                exp = hashMap.get(placeEvent.getBlock().getType());
                Bukkit.getLogger().info("Přidávám expy pro kategorii" + index);
                SerializationHandler.updateYaml("plugins/AEMMO/users/" + placeEvent.getPlayer().getUniqueId() + ".yaml",index,exp);
                break;
            }
            index++;
        }
    }
}
