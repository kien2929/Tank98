package base.obstructor;

import base.GameObject;
import base.game.Settings;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Forest extends GameObject {
    public Forest(){
        this.createRender();
        this.position.set(Settings.WAY_SIZE*10, Settings.WAY_SIZE*1);
        this.anchor.set(0,0);
    }

    private void createRender() {
        BufferedImage image = SpriteUtils.loadImage("assets/Image/objects/forest.png");
        this.renderer=new SingleImageRenderer(image);
    }
}
