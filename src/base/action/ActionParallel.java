package base.action;

import base.GameObject;

import java.util.ArrayList;
import java.util.Arrays;

public class ActionParallel implements Action{
    ArrayList<Action> actions;

    public ActionParallel(Action... actions) {
        this.actions = new ArrayList<>((Arrays.asList(actions)));
    }

    @Override
    public boolean run(GameObject master) {
        boolean isDone = true;
        for (int i = 0; i <this.actions.size(); i++) {
            isDone= this.actions.get(i).run(master) && isDone;
        }
        return isDone;
    }

    @Override
    public void reset() {
        for (int i = 0; i < this.actions.size(); i++) {
            this.actions.get(i).reset();
        }
    }
}
