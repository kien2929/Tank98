package base.stage;

import base.GameObject;
import base.Vector2D;
import base.enemy.EnemySummoner;
import base.game.Settings;
import base.obstructor.Wall;
import base.player.Player;
import base.obstructor.Wall;

import java.util.ArrayList;


public class Stage1 extends GameObject {
    ArrayList<Vector2D> wallPositions;
    ArrayList<Wall> walls;

    public Stage1() {
        //Background background = GameObject.recycle(Background.class);
        Player player = GameObject.recycle(Player.class);
        EnemySummoner enemySummoner = GameObject.recycle((EnemySummoner.class));
        this.wallPositions = new ArrayList<>();
        this.walls = new ArrayList<>();
        this.createWall();
    }
//tạo hàm draw theo đường thắng

    private void createWall() {
        //drawWall(7, 10, 7, 15);
        drawWall(7, 10, 10, 10);

    }

    private void drawWall(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            if (y1 < y2) {
                for (int i = 0; i < y2 - y1; i++) {
                    Wall wall = GameObject.recycle(Wall.class);
                    walls.add(wall);
                    wall.position.set(x1 * Settings.WAY_SIZE - 16, (y1 + i) * Settings.WAY_SIZE - 16);
                }
            }
            if(y1>y2){
                for (int i = 0; i < y1 - y2; i++) {
                    Wall wall = GameObject.recycle(Wall.class);
                    walls.add(wall);
                    wall.position.set(x1 * Settings.WAY_SIZE - 16, (y2 + i) * Settings.WAY_SIZE - 16);
                }
            }
        }
        if(y1==y2) {
            if (x1 < x2) {
                for (int i = 0; i < x2 - x1; i++) {
                    Wall wall = GameObject.recycle(Wall.class);
                    walls.add(wall);
                    wall.position.set((x1 + i) * Settings.WAY_SIZE - 16,y1 * Settings.WAY_SIZE - 16 );
                }
            }
            if(x1>x2){
                for (int i = 0; i < x1 - x2; i++) {
                    Wall wall = GameObject.recycle(Wall.class);
                    walls.add(wall);
                    wall.position.set((x2 + i) * Settings.WAY_SIZE - 16,y1 * Settings.WAY_SIZE - 16);
                }
            }
        }
    }
}
