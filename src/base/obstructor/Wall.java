package base.obstructor;

import base.GameObject;
import base.renderer.BoxRenderer;
import base.game.Settings;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Wall extends GameObject implements Physics {
    BoxCollider boxCollider;
    int hp;

    public Wall(){
        super();
        this.boxCollider = new BoxCollider(this.position, this.anchor, 32, 32);
        //this.renderer = new BoxRenderer(this.boxCollider, Color.GREEN, true);
        this.createRender();
        this.position.set(Settings.WAY_SIZE*10, Settings.WAY_SIZE*1);
        this.anchor.set(0,0);
        this.hp = 6;
    }

    private void createRender() {
        BufferedImage image = SpriteUtils.loadImage("assets/Image/objects/brick.png");
        this.renderer=new SingleImageRenderer(image);
    }

    @Override
    public void run() {
        super.run();
        this.destroyIfNeeded();
    }

    private void destroyIfNeeded() {
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
