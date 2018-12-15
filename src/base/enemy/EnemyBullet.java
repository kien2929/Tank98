package base.enemy;

import base.GameObject;
import base.renderer.BoxRenderer;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;

import java.awt.*;

public class EnemyBullet extends GameObject implements Physics {
    BoxCollider boxCollider;
    int direction;

    public EnemyBullet() {
        super();
        this.boxCollider = new BoxCollider(this.position, this.anchor,30, 30);
        this.renderer = new BoxRenderer(this.boxCollider, Color.LIGHT_GRAY, true);

    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.destroyIfNeeded();
    }

    private void move() {
        if (this.direction == 1) {
            this.position.addThis(0, -Settings.WAY_SIZE);
        }
        if (this.direction == 2) {
            this.position.addThis(0, Settings.WAY_SIZE);
        }
        if (this.direction == 3) {
            this.position.addThis(-Settings.WAY_SIZE, 0);
        }
        if (this.direction == 4) {
            this.position.addThis(Settings.WAY_SIZE, 0);
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
