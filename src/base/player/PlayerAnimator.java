package base.player;

import base.FrameCounter;
import base.GameObject;
import base.renderer.Renderer;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerAnimator extends Renderer {
    ArrayList<BufferedImage> images;
    FrameCounter countAnimation;
    int currentImageIndex;
    //rotate
    double angle;
    AffineTransform transform;
    AffineTransform emptyTransform;

    public PlayerAnimator (ArrayList<BufferedImage> images, int maxFramecount) {
        this.images = images;
        this.currentImageIndex = 0;
        this.countAnimation = new FrameCounter(maxFramecount);
        this.angle = 0;
        this.transform = new AffineTransform();
        this.emptyTransform = new AffineTransform();
    }

    @Override
    public void render(Graphics g, GameObject master) {
        Player player = (Player) master; // rotate
        Graphics2D g2D = (Graphics2D) g;

        BufferedImage currentImage = this.images.get(currentImageIndex);
        this.syncTransform(player, currentImage);
        g2D.drawImage(currentImage, this.transform, null);

        if (this.countAnimation.run()) {
            this.currentImageIndex++;
            if (this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.countAnimation.reset();
        }
    }

    public void syncTransform(Player master, BufferedImage image) {
        this.transform.setTransform(this.emptyTransform);

        double x = master.position.x - image.getWidth() * master.anchor.x;
        double y = master.position.y - image.getHeight() * master.anchor.y;
        this.transform.translate(x, y);

        switch(master.direction) {
            case 1:
                this.angle = Math.PI / 2;
                break;
            case 2:
                this.angle = -Math.PI / 2;
                break;
            case 3:
                this.angle = 0;
                break;
            case 4:
                this.angle = Math.PI;
                break;
        }
        this.transform.rotate(this.angle, image.getWidth() / 2
                , image.getHeight() / 2);
    }
}
