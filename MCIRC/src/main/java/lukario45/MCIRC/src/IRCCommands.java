/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lukario45.MCIRC.src;

import org.bukkit.entity.Player;

/**
 *
 * @author Kevin
 */
public class IRCCommands {
    public static void kick(Player target, String reason){
        target.kickPlayer(reason);
    }
    
}
