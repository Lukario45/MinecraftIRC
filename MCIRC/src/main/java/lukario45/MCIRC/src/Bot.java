package lukario45.MCIRC.src;

import org.pircbotx.MultiBotManager;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.managers.ThreadedListenerManager;

/**
 * @author Kevin
 */
public class Bot {
    public static MultiBotManager bots;
    public static PircBotX bot;
    public static String channels;
    public static boolean isRegistered;
    public static String password;

    public static void quit() {
        bots.disconnectAll();
    }

    public static void setup(String name, String network, String channels, boolean isRegistered, String password) {
        bot = new PircBotX();
        Bot.channels = channels;
        Bot.isRegistered = isRegistered;
        Bot.password = password;
        try {
            bots = new MultiBotManager(bot);
            for (String s : network.split(" ")) {
                bots.createBot(s);
            }
            bots.setName(name);
            bots.setListenerManager(new ThreadedListenerManager());
            bots.getListenerManager().addListener(new Listener());
            bots.connectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
