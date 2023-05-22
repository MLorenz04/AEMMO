package aeternias.aeternias;
import aeternias.aeternias.handlers.Handler;
import aeternias.aeternias.handlers.FirstJoinHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Aeternias extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Thread.currentThread().setContextClassLoader(this.getClassLoader());
        Bukkit.getLogger().info(Properties.prefix + "Zapínám! :)");
        //Nastavení fungujícího /aemmo commandu
        getCommand("aemmo").setExecutor(new CommandMenu());
        //Vytvoření handleru na eventy, jako těžení a podobné
        Handler h1 = new Handler(this);
        //Nastavení handleru na první připojení a řešení vytváření souborů.
        FirstJoinHandler f1 = new FirstJoinHandler(this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info( Properties.prefix + "Vypínám! :(");
    }
}
