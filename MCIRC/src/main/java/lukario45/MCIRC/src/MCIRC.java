package lukario45.MCIRC.src;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

public class MCIRC extends JavaPlugin implements Listener {

    Logger log;
    public static Plugin plugin;
//work fucking mother fucker!
    @Override
    public void onEnable() {
        this.log = getLogger();
        MCIRC.plugin = this;
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Events(plugin), plugin);
        String name = getConfig().getString("nickname");
        String network = getConfig().getString("irc-network");
        String channels = getConfig().getString("channels");
        Bot bot = new Bot(name, network, channels);
    }

    @Override
    public void onDisable() { 
        Bot.quit();
    }

   
    
    
}
