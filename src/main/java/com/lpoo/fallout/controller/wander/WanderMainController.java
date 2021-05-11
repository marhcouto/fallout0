package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.battle.BattleMainController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.view.wander.WanderViewer;

import java.io.IOException;
import java.util.AbstractQueue;

public class WanderMainController implements MainController {
    private WanderModel model;
    private WanderViewer viewer;
    private final Game game;

    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;


    public WanderMainController(Game game) throws IOException, ClassNotFoundException {
        this(game, FileHandler.createWanderModel("gamestat"));
    }

    public WanderMainController(Game game, WanderModel model) {
        this.model = model;
        this.enemyController = new EnemyController(model, new RandomMovingEngine(), Game.getFps());
        this.viewer = new WanderViewer(game.getGui(), model);
        this.game = game;
        this.vaultBoyController = new VaultBoyController(model);
    }

    private Enemy checkFight() {
        AbstractQueue<Enemy> enemies = model.getArena().getOrderedEnemies(model.getVaultBoy().getPosition());
        while(!enemies.isEmpty()) {
            Enemy curEnemy = enemies.poll();
            if (curEnemy.insideAttackRadius(model.getVaultBoy())) {
                if (model.getArena().hasClearSight(model.getVaultBoy().getPosition(), curEnemy.getPosition()))
                    return curEnemy;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void run() throws IOException {
        this.react();
        this.enemyController.moveEnemies();
        Enemy fightingEnemy = checkFight();
        if (fightingEnemy != null) {
            game.pushController(new BattleMainController(this.game, fightingEnemy));
        }
        this.viewer.draw();
    }

    @Override
    public void react() throws IOException {
        LanternaGUI.ACTION nextAction = this.game.getGui().getAction();
        switch (nextAction) {
            case UP: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().up());
                break;
            }
            case DOWN: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().down());
                break;
            }
            case RIGHT: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().right());
                break;
            }
            case LEFT: {
                this.vaultBoyController.moveVaultBoy(this.model.getVaultBoy().getPosition().left());
                break;
            }
            case NONE: {
                break;
            }
            case QUIT: {
                this.game.clearControllers();
                break;
            }
        }
    }
}
