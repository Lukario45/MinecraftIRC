package lukario45.MCIRC.src;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.pircbotx.MultiBotManager;
import org.pircbotx.MultiBotManager.BotBuilder;
import org.pircbotx.PircBotX;
import org.pircbotx.exception.IrcException;
import org.pircbotx.exception.NickAlreadyInUseException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Kevin
 */
public class Bot {
    public static MultiBotManager bot;
    public static PircBotX myBots;

    public Bot(String name, String network, String channels, boolean isRegistered, String password) {
        BotBuilder b;
        try {
            b = new BotBuilder(myBots);
            myBots = new PircBotX();
            bot = new MultiBotManager(myBots);
            bot.setName(name);

            for (String s : network.split(" ")) {
                bot.createBot(s);
            }
            for (String s : channels.split(" ")) {
                //BotBuilder b = new BotBuilder(myBots);
                b.addChannel("#" + s);
                myBots.joinChannel("#" + s);
            }
            bot.connectAll();
            if (isRegistered == true) {
                bot.setLogin(password);
            }
            bot.getListenerManager().addListener(new Listener());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        bot.disconnectAll();
    }

}
