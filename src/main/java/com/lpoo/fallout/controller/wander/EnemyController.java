package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;

public class EnemyController {
    private final WanderModel model;
    private final MovingEngine engine;
    private int tickCounter;
    private int framesPerSecond;

    public EnemyController(WanderModel model, MovingEngine engine, Integer framesPerSecond) {
        this.model = model;
        this.engine = engine;
        this.framesPerSecond = framesPerSecond;
    }

    public void moveEnemies() {
        tickCounter++;
        if (tickCounter >= framesPerSecond) {
            for (Enemy enemy: model.getEnemies()) {
                Position newPosition = engine.move(enemy.getPosition());
                if (model.isEmpty(newPosition)) {
                    enemy.setPosition(newPosition);
                }
            }
            tickCounter = 0;
        }
    }
}
