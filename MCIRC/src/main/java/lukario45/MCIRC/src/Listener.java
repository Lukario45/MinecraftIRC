/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lukario45.MCIRC.src;

import org.bukkit.Bukkit;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;

/**
 *
 * @author Kevin
 */
public class Listener extends ListenerAdapter {
    @Override
    public void onMessage(MessageEvent e) {
        String format = String.format("[%s] %s: %s", e.getChannel().getName(), e.getUser().getNick(), e.getMessage());
        Bukkit.broadcastMessage(format);
    }
}
