package base.enemy;

import base.action.Action;
import base.action.ActionRepeat;
import base.action.ActionWait;
import base.GameObject;
import base.renderer.BoxRenderer;
import base.physics.BoxCollider;
import base.physics.Physics;

import java.awt.*;

public class EnemySummoner extends GameObject implements Physics {
    BoxCollider boxCollider;
    Action actionSummon;

    public EnemySummoner() {
        this.boxCollider = new BoxCollider(this.position, this.anchor,20, 40);
        this.position.set(200, 300);
        this.renderer = new BoxRenderer(this.boxCollider, Color.WHITE, true);
        this.actionSummon = this.Summon();
    }

    private Action Summon() {
        Action summonEnemy = new Action() {

            @Override
            public boolean run(GameObject master) {
                Enemy enemy = GameObject.recycle(Enemy.class);
                enemy.position.set(master.position.add(20,0));
                enemy.direction = (int) (Math.random()*4 +1);
                return true;
            }

            @Override
            public void reset() {
            }
        };

        Action actionSummon = new ActionWait(120, summonEnemy);
        Action actionSummonEnemy = new ActionRepeat(actionSummon);
        return actionSummonEnemy;
    }

    @Override
    public void run() {
        super.run();
        this.actionSummon.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
