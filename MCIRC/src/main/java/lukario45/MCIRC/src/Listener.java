/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lukario45.MCIRC.src;

import org.bukkit.Bukkit;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.JoinEvent;
import org.pircbotx.hooks.events.KickEvent;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.ModeEvent;
import org.pircbotx.hooks.events.NickChangeEvent;
import org.pircbotx.hooks.events.PartEvent;
import org.pircbotx.hooks.events.QuitEvent;

/**
 *
 * @author Kevin
 */
public class Listener extends ListenerAdapter {
    @Override
    public void onMessage(MessageEvent e) {
        String format = String.format("[%s] %s: %s", e.getChannel().getName(), e.getUser().getNick(), e.getMessage());
        tellWorld(format);
    }
    @Override
    public void onPart(PartEvent e){
        if (!e.getReason().isEmpty()){
            String format = String.format("[%s] %s has left the channel (%s)", e.getChannel().getName(), e.getUser().getNick(), e.getReason());
            tellWorld(format);
        } 
        else {
            String format = String.format("[%s] %s has left the channel", e.getChannel().getName(), e.getUser().getNick());
        }
    }
    @Override
    public void onJoin(JoinEvent e){
        String format = String.format("%s has joined %s", e.getUser().getNick(), e.getChannel().getName());
        tellWorld(format);
    }
     @Override
    public void onKick(KickEvent e) {
        if (!e.getReason().isEmpty()) {
            String format = String.format("[%s] ~ %s has kicked %s (%s)", e.getChannel().getName(), e.getSource().getNick(), e.getRecipient().getNick(), e.getReason());
            Bukkit.broadcastMessage(format);
        } else {
            String format = String.format("[%s] ~ %s has kicked %s from the channel", e.getChannel().getName(), e.getSource().getNick(), e.getRecipient().getNick());
            Bukkit.broadcastMessage(format);
        }
    }
     @Override
     public void onQuit(QuitEvent e){
         String format = String.format("%s has quit %s", e.getUser().getNick(), e.getReason());
         tellWorld(format);
     }
     @Override
     public void onMode(ModeEvent e){
         String format = String.format("%s has set mode for %s in %s", e.getUser().getNick(), e.getMode(), e.getChannel().getName());
         tellWorld(format);
     }
     @Override
     public void onNickChange(NickChangeEvent e){
         String format = String.format("%s is now known as %s", e.getOldNick(), e.getNewNick());
         tellWorld(format);
     }
    
    public static void tellWorld(String msg){
        Bukkit.broadcastMessage(msg);
    }
}