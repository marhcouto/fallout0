package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.model.wander.element.Enemy;

import java.io.IOException;

public class BattleController implements Controller {
    private Enemy enemy;

    public BattleController(Enemy enemy) {
        this.enemy = enemy;
    }
    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public void run() throws IOException, InterruptedException {

    }
}
