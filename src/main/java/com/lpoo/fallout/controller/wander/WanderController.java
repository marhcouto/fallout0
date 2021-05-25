package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.states.BattleState;

import java.util.AbstractQueue;
import java.util.Random;

public class WanderController extends MainController<WanderModel> {
    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;

    public WanderController(WanderModel model) {
        super(model);
        vaultBoyController = new VaultBoyController(getModel());
        enemyController = new EnemyController(getModel(), new RandomMovingEngine());
    }

    private Enemy checkFight() {
        AbstractQueue<Enemy> enemies = getModel().getArena().getOrderedEnemies(getModel().getVaultBoy().getPosition());
        while(!enemies.isEmpty()) {
            Enemy curEnemy = enemies.poll();
            if (curEnemy.insideAttackRadius(getModel().getVaultBoy()) &&
                getModel().getArena().hasClearSight(getModel().getVaultBoy().getPosition(), curEnemy.getPosition()))
            {
                return curEnemy;
            }
        }
        return null;
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        switch (action) {
            case NONE: {
                break;
            }
            case QUIT: {
                game.clearControllers();
                break;
            }
            default: {
                vaultBoyController.move(action);
            }
        }
        enemyController.moveEnemies(time);
        Enemy fightingEnemy = checkFight();
        if (fightingEnemy != null) {
            game.pushController(new BattleState(new BattleModel(getModel().getVaultBoy(), fightingEnemy, new Random())));
        }
    }
}
