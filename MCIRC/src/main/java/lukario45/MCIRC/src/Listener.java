/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lukario45.MCIRC.src;

import org.bukkit.Bukkit;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PartEvent;

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
            String format = String.format("[%s] ~ %s has left the channel (%s)", e.getChannel().getName(), e.getUser().getNick(), e.getReason());
            tellWorld(format);
        } 
        else {
            String format = String.format("[%s] ~ %s has left the channel", e.getChannel().getName(), e.getUser().getNick());
        }
    }
    
    public static void tellWorld(String msg){
        Bukkit.broadcastMessage(msg);
    }
}
