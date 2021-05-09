package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.wander.element.Enemy;

import java.io.IOException;

public class BattleController extends Controller {
    private Enemy enemy;

    public BattleController(Game game, Enemy enemy)  {
        super(game);
        this.enemy = enemy;
    }
    public Enemy getEnemy() {
        return enemy;
    }

    @Override
    public void run() throws IOException {
        System.out.println("BATTLE BEGINS... NOT YET IMPLEMENTED...");
        getGame().popController();
    }

    @Override
    public void react() throws IOException {

    }
}
