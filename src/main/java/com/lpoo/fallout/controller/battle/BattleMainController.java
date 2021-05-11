package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.wander.element.Enemy;

import java.io.IOException;

public class BattleMainController implements MainController {
    private Enemy enemy;
    private Game game;

    public BattleMainController(Game game, Enemy enemy) {
        this.enemy = enemy;
        this.game = game;
    }
    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public void run() throws IOException, InterruptedException {
        System.out.println("BATTLE BEGINS... NOT YET IMPLEMENTED...");
        game.popController();
    }

    @Override
    public void react() throws IOException {

    }
}
