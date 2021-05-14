package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.battle.BattleController;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.view.wander.WanderViewer;

import java.io.IOException;
import java.util.AbstractQueue;

public class WanderController extends MainController {
    private WanderModel model;
    private WanderViewer viewer;

    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;


    public WanderController(Game game) throws IOException, ClassNotFoundException {
        this(game, FileHandler.createWanderModel("gamestat"));
    }

    public WanderController(Game game, Attributes vaultBoyAttributes) throws IOException, ClassNotFoundException {
        this(game, FileHandler.createWanderModel("gamestat"));
        model.getVaultBoy().setAttributes(vaultBoyAttributes);
    }

    public WanderController(Game game, WanderModel model)  {
        super(game);
        this.model = model;
        this.enemyController = new EnemyController(model, new RandomMovingEngine(), Game.getFps());
        this.viewer = new WanderViewer(game.getGui(), model);
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
            this.getGame().pushController(new BattleController(this.getGame(), fightingEnemy));
        }
        this.viewer.draw();
    }

    @Override
    public void react() throws IOException {
        LanternaGUI.ACTION nextAction = this.getGame().getGui().getAction();
        switch (nextAction) {
            case NONE: {
                break;
            }
            case QUIT: {
                this.getGame().clearControllers();
                break;
            }
            default: {
                vaultBoyController.move(nextAction);
            }
        }
    }
}
