package base.game;


import base.GameObject;
import base.BackGround;
import base.obstructor.SteelWall;
import base.stage.Stage1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    public GameCanvas(){
        BackGround backGround = GameObject.recycle(BackGround.class);
        this.setPreferredSize(new Dimension(Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT));
        Stage1 stage1 = GameObject.recycle(Stage1.class);
        SteelWall steelWall =GameObject.recycle(SteelWall.class);

        //Player player = GameObject.recycle(Player.class);
        //Wall wall = GameObject.recycle(Wall.class);

//        SceneManager.signNewScene(new MenuScene());
    }

    @Override
    protected void paintComponent(Graphics g) {
//        for (GameObject gameObject: GameObject.gameObjects) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Settings.SCREEN_WIDTH, Settings.SCREEN_HEIGHT);
        for (int i =0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }

    public void gameLoop() {
        int delay = 1000/60;
        long lastRun = 0;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastRun > delay) {
                this.runAll();
                this.renderAll();
                lastRun = currentTime;
            }
        }
    }

    public void runAll() {
//        for(GameObject gameObject: GameObject.gameObjects) {
        for (int i=0; i < GameObject.gameObjects.size(); i++) {
            GameObject gameObject = GameObject.gameObjects.get(i);
            if (gameObject.isActive) {
                gameObject.run();
            }
        }
    }

    public void renderAll() {
        this.repaint();
    }
}
