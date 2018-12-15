package base.action;

import base.GameObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionSequence implements Action{
    ArrayList<Action> actions;
    int currentActionIndex;
    public ActionSequence(Action... actions) {
        this.actions = new ArrayList<>(Arrays.asList(actions));
        this.currentActionIndex = 0;
    }
    @Override
    public boolean run(GameObject master) {
        if (this.actions.size() > 0) {
            Action currentAction = this.actions.get(this.currentActionIndex);
            boolean currentActionIsDone = currentAction.run(master);
            if (currentActionIsDone) {
                this.currentActionIndex++;
                if (this.currentActionIndex >= this.actions.size()){
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public void reset() {
    }
}
