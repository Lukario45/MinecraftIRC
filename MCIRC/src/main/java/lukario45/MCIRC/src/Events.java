/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lukario45.MCIRC.src;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.pircbotx.Channel;
/**
 *
 * @author Kevin
 */
public class Events implements Listener {
    public static Plugin pl;
    public Events(Plugin pl) {
        Events.pl = pl;
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent p) {
        String w = p.getPlayer().getWorld().toString();
        String[] worldpart = w.split("=");
        String[] worldpart2 = worldpart[1].split("}");
        String world = worldpart2[0];
        String format = "["+ world + "] " + p.getPlayer().getName()+ ": " + p.getMessage();
        sendMessage(format);
    }
    public static void sendMessage(final String s){
        Bukkit.getScheduler().runTaskAsynchronously(MCIRC.plugin, new Runnable(){
            public void run(){
                for(Channel c : Bot.bot.getChannels()){
                    Bot.bot.sendMessage(c, s);
                }
            }
        });
    }
}

