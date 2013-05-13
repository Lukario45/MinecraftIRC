package lukario45.MCIRC.src;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.events.MessageEvent;

public class MCIRC extends JavaPlugin implements Listener {

    Logger log;
//work fucking mother fucker!
    @Override
    public void onEnable() {
        this.log = getLogger();
        this.saveDefaultConfig();
        //lol forgot sumtin
        start();
        //xD
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @SuppressWarnings("unused")
    public void start() {
        try {
            PircBotX bot = new PircBotX();
            bot.setName(getConfig().getString("nickname"));
            bot.connect(getConfig().getString("irc-network"));
            for (String s : this.getConfig().getString("channels").split(" ")) {
                bot.joinChannel("#" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
