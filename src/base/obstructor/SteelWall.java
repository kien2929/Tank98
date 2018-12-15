package base.obstructor;
import base.physics.BoxCollider;
import base.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class SteelWall extends Wall {
    public SteelWall(){
        this.boxCollider=new BoxCollider(this.position,this.anchor,32,32);
        this.createRender();
        this.position.set(200,200);
    }
    private void createRender(){
        BufferedImage image = SpriteUtils.loadImage("assets/Image/objects/steel.png");
        this.renderer=new SingleImageRenderer(image);
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
