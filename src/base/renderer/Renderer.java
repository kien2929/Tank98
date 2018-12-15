package base.renderer;

import base.GameObject;

import java.awt.*;

public abstract class Renderer {
    public abstract void render (Graphics g, GameObject master);
}
