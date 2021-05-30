package com.lpoo.fallout.controller.wander;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.messagedisplay.MessageDisplayModel;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;
import com.lpoo.fallout.model.levelup.LevelUpModel;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Door;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.states.BattleState;
import com.lpoo.fallout.states.LevelUpState;
import com.lpoo.fallout.states.MessageDisplayState;
import com.lpoo.fallout.states.StatsMenuState;


import java.io.IOException;
import java.util.AbstractQueue;

public class WanderController extends MainController<WanderModel> {
    private final VaultBoyController vaultBoyController;
    private final EnemyController enemyController;
    private boolean justEntered;
    private FileHandler fileHandler;


    public WanderController(WanderModel model, FileHandler saveFileClass) {
        super(model);
        this.justEntered = true;
        vaultBoyController = new VaultBoyController(getModel());
        enemyController = new EnemyController(getModel(), new RandomMovingEngine());
        this.fileHandler = saveFileClass;
    }

    public WanderController(WanderModel model) {
        this(model, new FileHandler());
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
                fileHandler.saveArena(getModel().getArena().getName(), getModel().getArena());
                getModel().setArena(fileHandler.createArena(door.getArenaFileName()));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            getModel().getVaultBoy().setPosition(door.getCorrespondingPosition());
            this.justEntered = true;
        }
    }

    private boolean checkShrine() {
        Position shrine = getModel().getArena().getShrine();
        if (shrine != null) {
            if (shrine.equals(getModel().getVaultBoy().getPosition()) && !getModel().getVaultBoy().isGameWon()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void step(Game game, LanternaGUI.ACTION action, long time) {
        if (this.checkShrine() && !getModel().getVaultBoy().isGameWon()) {
            try {
                fileHandler.saveModel("gamestat", getModel());
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.pushState(new MessageDisplayState(new MessageDisplayModel("GAME WON")));
            getModel().getVaultBoy().setGameWon(true);
        }
        if (getModel().getVaultBoy().isGameStarting()) {
            getModel().getVaultBoy().setGameStarting(false);
            getModel().getVaultBoy().setUnusedLevelPoints(5);
            try {
                fileHandler.saveModel("gamestat", getModel());
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.pushState(new LevelUpState(new LevelUpModel(getModel().getVaultBoy())));
        }
        Enemy fightingEnemy = checkFight();
        if (fightingEnemy != null) {
            try {
                game.changeTerminalProperty(new TerminalSize(600, 300), 3);
                fileHandler.saveModel("gamestat", getModel());
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
                try {
                    fileHandler.saveModel("gamestat", getModel());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                game.clearStates();
                break;
            }
            case UTIL_E: {
                game.pushState(new StatsMenuState(new StatsMenuModel(getModel().getVaultBoy())));
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
