package base.game;

import base.KeyEventPress;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public GameWindow() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setSize(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        this.setTitle("Game Touhou");
        this.setResizable(false);
        this.addKeyEvent();
    }

    private void addKeyEvent() {

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = true;
                if (e.getKeyCode() == Settings.UP_BUTTON) {
                    KeyEventPress.isUpPress = true;
                }
                if (e.getKeyCode() == Settings.DOWN_BUTTON) {
                    KeyEventPress.isDownPress = true;
                }
                if (e.getKeyCode() == Settings.LEFT_BUTTON) {
                    KeyEventPress.isLeftPress = true;
                }
                if (e.getKeyCode() == Settings.RIGHT_BUTTON) {
                    KeyEventPress.isRightPress = true;
                }
                if (e.getKeyCode() == Settings.FIRE_BUTTON) {
                    KeyEventPress.isFirePress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyEventPress.isAnyKeyPress = false;
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    KeyEventPress.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    KeyEventPress.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    KeyEventPress.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    KeyEventPress.isRightPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    KeyEventPress.isFirePress = false;
                }
            }
        });

    }
}
