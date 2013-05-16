/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lukario45.MCIRC.src;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
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
        String format = String.format("[%s] %s: %s",p.getPlayer().getWorld().getName(), p.getPlayer().getName(), p.getMessage());
        sendMessage(format);
    }
    @EventHandler
    public void onKick(PlayerKickEvent e){
        String format = String.format("%s was kicked for %s", e.getPlayer().getName() , e.getReason());
        sendMessage(format);
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        String format = String.format("%s has left the game", e.getPlayer().getName());
        sendMessage(format);
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        String format = String.format("%s has joined the game", e.getPlayer().getName());
        sendMessage(format);
    }
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        String format = String.format("%s", e.getDeathMessage());
        sendMessage(format);
    }
    
    
    
    public static void sendMessage(final String s){
        Bukkit.getScheduler().runTaskAsynchronously(pl, new Runnable(){
            public void run(){
                for(Channel c : Bot.bot.getChannels()){
                    Bot.bot.sendMessage(c, s);
                }
            }
        });
    }
}

