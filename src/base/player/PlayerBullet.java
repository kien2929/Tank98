package base.player;

import base.GameObject;
import base.KeyEventPress;
import base.renderer.BoxRenderer;
import base.enemy.Enemy;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int damage;
    int direction;

    public PlayerBullet() {
        super();
        this.boxCollider = new BoxCollider(this.position, this.anchor, 8, 8);
        this.createrenderer();
        this.damage = 3;
    }

    private void createrenderer() {
        this.turn();
        BufferedImage image1 = SpriteUtils.loadImage("F:\\Tank-fix-box-collider&rotate-image\\ci-begin-master\\assets\\Image\\bullet\\bullet_up.png");
        BufferedImage image2 = SpriteUtils.loadImage("F:\\Tank-fix-box-collider&rotate-image\\ci-begin-master\\assets\\Image\\bullet\\bullet_down.png");
        BufferedImage image3 = SpriteUtils.loadImage("F:\\Tank-fix-box-collider&rotate-image\\ci-begin-master\\assets\\Image\\bullet\\bullet_left.png");
        BufferedImage image4 = SpriteUtils.loadImage("F:\\Tank-fix-box-collider&rotate-image\\ci-begin-master\\assets\\Image\\bullet\\bullet_right.png");
            this.renderer = new SingleImageRenderer(image1);
    }

    private void turn() {
        if (KeyEventPress.isUpPress) {
            this.direction = 1;
        }
        if (KeyEventPress.isDownPress) {
            this.direction = 2;
        }
        if (KeyEventPress.isLeftPress) {
            this.direction = 3;
        }

        if (KeyEventPress.isRightPress) {
            this.direction = 4;
        }
    }

    public void run() {
        super.run();
        this.hitEnemy();
        this.destroyIfNeeded();
    }

    private void hitEnemy() {
        Enemy enemy = GameObject.intersects(Enemy.class, this.boxCollider);
        if (enemy != null) {
            enemy.takeDamage(this.damage);
            this.destroy();
        }
    }

    private void destroyIfNeeded() {
        if (this.position.y < -20 || this.position.y > Settings.SCREEN_HEIGHT || this.position.x < -20 || this.position.x > Settings.SCREEN_WIDTH) {
            this.destroy();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
