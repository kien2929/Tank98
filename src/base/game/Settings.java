package base.game;

import java.awt.event.KeyEvent;

public class Settings {
    public static int SCREEN_WIDTH = 400;
    public static int SCREEN_HEIGHT = 400;
    public static int WAY_SIZE = 20;
    public static int ROW_COUNT = SCREEN_HEIGHT/WAY_SIZE;
    public static int COLUMN_COUNT = SCREEN_WIDTH/WAY_SIZE;
    public static int UP_BUTTON = KeyEvent.VK_W;
    public static int DOWN_BUTTON = KeyEvent.VK_S;
    public static int LEFT_BUTTON = KeyEvent.VK_A;
    public static int RIGHT_BUTTON = KeyEvent.VK_D;
    public static int FIRE_BUTTON = KeyEvent.VK_SPACE;
}
