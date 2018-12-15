package base.action;

import base.FrameCounter;
import base.GameObject;

public class ActionWait implements Action {
    FrameCounter waitTime;
    Action action;

    public ActionWait (int countMax, Action action) {
        this.waitTime = new FrameCounter(countMax);
        this.action = action;
    }

    @Override
    public boolean run(GameObject master) {
        if(this.waitTime.run()) {
            this.action.run(master);
            this.waitTime.reset();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void reset() {
    }
}
