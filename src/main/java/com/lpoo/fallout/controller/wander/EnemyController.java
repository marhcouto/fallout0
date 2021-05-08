package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;

public class EnemyController {
    private WanderModel model;

    EnemyController(WanderModel model) {
        this.model = model;
    }
    void moveEnemies() {
        for (Enemy enemy: model.getEnemies()) {
            Position newPosition = enemy.getMovingEngine().move(enemy.getPosition());
            if (model.isEmpty(newPosition)) {
                enemy.setPosition(newPosition);
            }
        }
    }
}
