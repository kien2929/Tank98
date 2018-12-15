package base.player;

import base.FrameCounter;
import base.GameObject;
import base.KeyEventPress;
import base.enemy.Enemy;
import base.obstructor.SteelWall;
import base.obstructor.Wall;
import base.renderer.BoxRenderer;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject implements Physics {
    BoxCollider boxCollider;
    FrameCounter moveCounter;
    int direction;
    FrameCounter fireCounter;

    public Player() {
        this.position.set(210, 310);
        this.boxCollider = new BoxCollider(this.position, this.anchor, 16, 16);
//        this.renderer = new BoxRenderer(this.boxCollider, Color.CYAN, true);
        this.createRenderer();
        this.moveCounter = new FrameCounter(4);
        this.fireCounter = new FrameCounter(15);
        this.direction = 1;
    }

    private void createRenderer() {
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/Image/player/1/tank_player1_left_c0_t1_s1.png"));
        images.add(SpriteUtils.loadImage("assets/Image/player/1/tank_player1_left_c0_t2_s1.png"));
        this.renderer = new PlayerAnimator(images, 5);
    }

    @Override
    public void run() {
        this.turn();
        this.move();
        if(this.fireCounter.run() && KeyEventPress.isFirePress) {
            this.fire();
        }
        super.run();
    }

    private void turn() {
        if(KeyEventPress.isUpPress) { this.direction = 1; }

        if(KeyEventPress.isDownPress) { this.direction = 2; }

        if(KeyEventPress.isLeftPress) { this.direction = 3; }

        if(KeyEventPress.isRightPress) { this.direction = 4; }
    }

    private void move() {
        if (moveCounter.run()) {
            if(KeyEventPress.isUpPress) {
                this.position.addThis(0, -Settings.WAY_SIZE/2);
                Wall wall = GameObject.intersects(Wall.class, this.boxCollider);
                if (wall != null){
                    this.position.substractThis(0, -Settings.WAY_SIZE/2);
                }
                SteelWall steelWal = GameObject.intersects(SteelWall.class, this.boxCollider);
                if (steelWal != null){
                    this.position.substractThis(0, -Settings.WAY_SIZE/2);
                }
            }

            if(KeyEventPress.isDownPress) {
                this.position.addThis(0, Settings.WAY_SIZE/2);
                Wall wall = GameObject.intersects(Wall.class, this.boxCollider);
                if (wall != null){
                    this.position.substractThis(0, Settings.WAY_SIZE/2);
                }
                SteelWall steelWal = GameObject.intersects(SteelWall.class, this.boxCollider);
                if (steelWal != null){
                    this.position.substractThis(0, Settings.WAY_SIZE/2);
                }
            }

            if(KeyEventPress.isLeftPress) {
                this.position.addThis(-Settings.WAY_SIZE/2, 0);
                Wall wall = GameObject.intersects(Wall.class, this.boxCollider);
                if (wall != null){
                    this.position.substractThis(-Settings.WAY_SIZE/2, 0);
                }
                SteelWall steelWal = GameObject.intersects(SteelWall.class, this.boxCollider);
                if (steelWal != null){
                    this.position.substractThis(-Settings.WAY_SIZE/2, 0);
                }
            }

            if(KeyEventPress.isRightPress) {
                this.position.addThis(Settings.WAY_SIZE/2, 0);
                Wall wall = GameObject.intersects(Wall.class, this.boxCollider);
                if (wall != null){
                    this.position.substractThis(Settings.WAY_SIZE/2, 0);
                }
                SteelWall steelWal = GameObject.intersects(SteelWall.class, this.boxCollider);
                if (steelWal != null){
                    this.position.substractThis(Settings.WAY_SIZE/2, 0);
                }
            }
            moveCounter.reset();
        }
    }

    private void fire() {
        GameObject playerBullet = GameObject.recycle(PlayerBullet.class);
        playerBullet.position.set(this.position);
        if (this.direction == 1) {
            playerBullet.velocity.set(0,-5);
        }
        if (this.direction == 2) {
            playerBullet.velocity.set(0,5);
        }
        if (this.direction == 3) {
            playerBullet.velocity.set(-5, 0);
        }
        if (this.direction == 4) {
            playerBullet.velocity.set(5,0);
        }
        this.fireCounter.reset();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
