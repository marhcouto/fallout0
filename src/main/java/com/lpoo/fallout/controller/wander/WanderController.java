package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.gui.LanternaTerminal;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Door;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.states.BattleState;

import java.io.File;
import java.io.IOException;
import java.util.AbstractQueue;

public class WanderController extends MainController<WanderModel> {
    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;
    private boolean justEntered;

    public WanderController(WanderModel model) {
        super(model);
        this.justEntered = true;
        vaultBoyController = new VaultBoyController(getModel());
        enemyController = new EnemyController(getModel(), new RandomMovingEngine());
    }

    private Enemy checkFight() {
        AbstractQueue<Enemy> enemies = getModel().getArena().getOrderedEnemies(getModel().getVaultBoy().getPosition());
        while(!enemies.isEmpty()) {
            Enemy curEnemy = enemies.poll();
            if (curEnemy.insideAttackRadius(getModel().getVaultBoy()) &&
                    getModel().getArena().hasClearSight(getModel().getVaultBoy().getPosition(), curEnemy.getPosition())) {
                return curEnemy;
            }
        }
        return null;
    }

    private void tryOpenDoor() {
        Door door = getModel().getArena().getDoorMap().get(getModel().getVaultBoy().getPosition());
        if (door != null && !this.justEntered) {
            try {
                FileHandler.saveArena(getModel().getArena().getName(), getModel().getArena());
                getModel().setArena(new FileHandler().createArena(door.getArenaFileName()));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            getModel().getVaultBoy().setPosition(door.getCorrespondingPosition());
            this.justEntered = true;
        }
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        Enemy fightingEnemy = checkFight();
        if (fightingEnemy != null) {
            try {
                game.changeGui(new LanternaGUI(new LanternaTerminal(600, 300, 2)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.pushState(new BattleState(new BattleModel(getModel().getArena(), getModel().getVaultBoy(), fightingEnemy)));
        }

        switch (action) {
            case NONE: {
                break;
            }
            case QUIT: {
                game.clearStates();
                break;
            }
            default: {
                this.justEntered = false;
                vaultBoyController.move(action);
            }
        }
        this.tryOpenDoor();
        enemyController.moveEnemies(time);
    }
}
