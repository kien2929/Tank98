package base.action;

import base.GameObject;

public class ActionRepeat implements Action {
    Action action;

    public ActionRepeat (Action action) {
        this.action = action;
    }
    @Override
    public boolean run(GameObject master) {
        if(this.action.run(master)) {
            this.action.reset();
        }
        return false;
    }

    @Override
    public void reset() {
    }
}
