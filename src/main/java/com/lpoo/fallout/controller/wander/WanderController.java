package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.Controller;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.battle.BattleController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.view.wander.WanderViewer;

import java.io.IOException;
import java.util.AbstractQueue;

public class WanderController implements Controller {
    private WanderModel map;
    private WanderViewer viewer;
    private final Game game;

    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;

    public WanderController(Game game) {
        this.map = new FileWanderFactory("arena1", new VaultBoy(new Position(5, 5))).createWanderModel();
        this.enemyController = new EnemyController(map, new RandomMovingEngine(), Game.getFps());
        this.viewer = new WanderViewer(game.getGui(), map);
        this.game = game;
        this.vaultBoyController = new VaultBoyController(map);
    }

    private Enemy checkFight() {
        AbstractQueue<Enemy> enemies = map.getOrderedEnemies(map.getVaultBoy().getPosition());
        while(!enemies.isEmpty()) {
            Enemy curEnemy = enemies.poll();
            if (curEnemy.insideAttackRadius(map.getVaultBoy())) {
                if (map.hasClearSight(map.getVaultBoy().getPosition(), curEnemy.getPosition()))
                    return curEnemy;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void run() throws IOException {
        LanternaGUI.ACTION nextAction = this.game.getGui().getAction();
        if (nextAction == LanternaGUI.ACTION.QUIT) {
            this.game.clearControllers();
        } else {
            this.enemyController.moveEnemies();
            this.vaultBoyController.action(nextAction);
            Enemy fightingEnemy = checkFight();
            if (fightingEnemy != null) {
                game.pushController(new BattleController(fightingEnemy));
            }
            this.viewer.draw();
        }
    }
}
