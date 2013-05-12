package lukario45.MCIRC.src;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.pircbotx.PircBotX;
import org.pircbotx.User;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.MessageEvent;

public class MCIRC extends JavaPlugin {

    Logger log;
//work fucking mother fucker!
    @Override
    public void onEnable() {
        this.log = getLogger();
        this.saveDefaultConfig();
        //lol forgot sumtin
        start();
        //xD

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
            String channel = "#" + getConfig().getString("channel");
            String channel2 = "#" + getConfig().getString("channel2");
            for (String s : this.getConfig().getString("channels").split(" ")) {
                bot.joinChannel("#" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMessage(MessageEvent e) {
        String format = String.format("[%s] %s: %s", e.getChannel().getName(), e.getUser().getNick(), e.getMessage());
        Bukkit.broadcastMessage(format);
    }
}
