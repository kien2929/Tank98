package base.renderer;

import base.GameObject;
import base.physics.BoxCollider;

import java.awt.*;

public class BoxRenderer extends Renderer {
    BoxCollider boxCollider;
    Color color;
    boolean isFill;

    public BoxRenderer (BoxCollider boxCollider, Color color, boolean isFill) {
        this.boxCollider = boxCollider;
        this.color = color;
        this.isFill = isFill;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        int x = (int) (master.position.x - master.anchor.x * boxCollider.width);
        int y = (int) (master.position.y - master.anchor.y * boxCollider.height);
        g.setColor(this.color);
        if (this.isFill) {
            g.fillRect(x, y, this.boxCollider.width, this.boxCollider.height);
        } else {
            g.drawRect(x, y, this.boxCollider.width, this.boxCollider.height);
        }

    }
}
