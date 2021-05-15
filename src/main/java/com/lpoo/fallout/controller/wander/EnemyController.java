package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;

public class EnemyController {
    private final WanderModel model;
    private final MovingEngine engine;
    private long lastMovement;
    private final long MOVE_TIME_MS = 800;

    public EnemyController(WanderModel model, MovingEngine engine) {
        this.model = model;
        this.engine = engine;
        lastMovement = 0;
    }

    public void moveEnemies(long time) {
        if ((time - lastMovement) >= MOVE_TIME_MS) {
            for (Enemy enemy: model.getArena().getEnemies()) {
                Position newPosition = engine.move(enemy.getPosition());
                if (model.getArena().isSpaceEmpty(newPosition)) {
                    enemy.setPosition(newPosition);
                }
            }
            lastMovement = time;
        }
    }
}
