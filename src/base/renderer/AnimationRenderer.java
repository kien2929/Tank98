package base.renderer;

import base.FrameCounter;
import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AnimationRenderer extends  Renderer{
    ArrayList<BufferedImage> images;
    FrameCounter countAnimation;
    int currentImageIndex;
    boolean isOnce;

    public AnimationRenderer(ArrayList<BufferedImage> images) {
        this(images, 10, false);
    }

    public AnimationRenderer(ArrayList<BufferedImage> images, int maxFramecount) {
        this(images, maxFramecount, false);
    }

    public AnimationRenderer (ArrayList<BufferedImage> images, int maxFramecount, boolean isOnce) {
        this.images = images;
        currentImageIndex = 0;
        this.countAnimation = new FrameCounter(maxFramecount);
        this.isOnce = isOnce;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage currentImage = this.images.get(currentImageIndex);
        int x = (int) (master.position.x - master.anchor.x * currentImage.getWidth());
        int y = (int) (master.position.y - master.anchor.y * currentImage.getHeight());

        g.drawImage(this.images.get(currentImageIndex), x, y, null);
        if (this.countAnimation.run()) {
            this.currentImageIndex++;
            if (this.currentImageIndex >= this.images.size()
             && this.isOnce) {
                master.destroy();
            }
            if (this.currentImageIndex >= this.images.size()) {
                this.currentImageIndex = 0;
            }
            this.countAnimation.reset();
        }
    }
}
