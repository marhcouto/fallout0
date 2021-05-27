package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Character;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class BattleController extends MainController<BattleModel> {

    public BattleController(@NotNull BattleModel model)  {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT)
            game.clearStates();
        if (getModel().getTurn().getOutcome().succeeded()) {
            waitForMessage();
            getModel().changeTurn();
        }
        if (getModel().isPlayerTurn())
            new BattleMenuController(this.getModel(), getModel().getMenuModel()).step(game, action);
        else
            new BattleMonsterController(getModel().getTurn(), this.getModel()).step(new Random());

        addCharacterInfoToMessage();
        processDeath(game);
    }

    private void processDeath(Game game) {
        Enemy deadCharacter = null;
        for (Map.Entry<Character, BattleStats> curElement: getModel().getAllCharacterStats().entrySet()) {
            if (curElement.getValue().getHealthPoints() <= 0) {
                if (curElement.getKey().equals(getModel().getVaultBoy())) {
                    game.clearStates();
                } else {
                    deadCharacter = (Enemy) curElement.getKey();
                    try {
                        game.changeGui(Game.getDefaultGUI());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    } finally {
                        game.popState();
                    }
                }
            }
        }

        if (deadCharacter != null) {
            getModel().getArena().removeEnemy(deadCharacter);
        }
    }

    private void waitForMessage() {
        if (System.currentTimeMillis() < getModel().getTurn().getOutcome().getEndTime()) {
            try {
                Thread.sleep(getModel().getTurn().getOutcome().getEndTime() - System.currentTimeMillis());
            } catch (InterruptedException exception) {
                throw new RuntimeException("This thread should never be interrupted", exception);
            }
        }
    }

    private void addCharacterInfoToMessage() {
        if (getModel().isPlayerTurn()) {
            getModel().getTurn().getOutcome().setMessageDescriptor("Player\n" + getModel().getTurn().getOutcome().getMessageDescriptor());
        } else {
            getModel().getTurn().getOutcome().setMessageDescriptor("Enemy\n" + getModel().getTurn().getOutcome().getMessageDescriptor());
        }
    }
}
