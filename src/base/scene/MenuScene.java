package base.scene;

import base.CoverMenuScene;
import base.GameObject;

public class MenuScene extends Scene {
    @Override
    public void init() {
        GameObject cover = GameObject.recycle(CoverMenuScene.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
