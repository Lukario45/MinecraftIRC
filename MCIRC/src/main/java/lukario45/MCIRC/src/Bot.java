package lukario45.MCIRC.src;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.exception.NickAlreadyInUseException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kevin
 */
public class Bot {
        public static PircBotX bot;
        public Bot(String name, String network, String channels , boolean isRegistered , String password) {
        try {
            bot = new PircBotX();
            bot.setName(name);
            bot.connect(network);
            if (isRegistered == true){
                bot.identify(password);
            }
            bot.getListenerManager().addListener(new Listener());
            for (String s : channels.split(" ")) {
                bot.joinChannel("#" + s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
        public static void quit(){
            bot.shutdown(true);
        }
    
}
