package base.action;

import base.GameObject;

public interface Action {
    abstract boolean run(GameObject master);
    abstract void reset();
}