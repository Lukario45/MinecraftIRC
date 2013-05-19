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


    //test
    @Override
    public void onEnable() {
        this.log = getLogger();
        MCIRC.plugin = this;
        this.saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new Events(plugin), plugin);
        String name = getConfig().getString("nickname");
        String networks = getConfig().getString("irc-network");
        String channels = getConfig().getString("channels");
        boolean isRegistered = getConfig().getBoolean("isRegistered");
        String password;
        password = getConfig().getString("password");
        Bot.setup(name, networks, channels, isRegistered, password);
    }

    @Override
    public void onDisable() {
        Bot.quit();
    }

    public String getString(String string) {
        return getConfig().getString(string);
    }


}
