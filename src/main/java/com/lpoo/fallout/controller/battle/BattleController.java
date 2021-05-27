package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battleoutcome.BattleOutcomeModel;
import com.lpoo.fallout.model.wander.element.Character;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.states.BattleOutcomeState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
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
        if (!processDeath(game)) {
            if (getModel().isPlayerTurn())
                new BattleMenuController(this.getModel(), getModel().getMenuModel()).step(game, action);
            else
                new BattleMonsterController(getModel().getTurn(), this.getModel()).step(new Random());
            addCharacterInfoToMessage();
        }
    }

    private boolean processDeath(Game game) {
        Enemy deadCharacter = null;
        for (Map.Entry<Character, BattleStats> curElement: getModel().getAllCharacterStats().entrySet()) {
            if (curElement.getValue().getHealthPoints() <= 0) {
                if (curElement.getKey().equals(getModel().getVaultBoy())) {
                    game.clearStates();
                    game.pushState(new BattleOutcomeState(new BattleOutcomeModel("VAULT BOY DIED!")));
                } else {
                    deadCharacter = (Enemy) curElement.getKey();
                    Integer expGain = calculateExpGain(deadCharacter);
                    try {
                        game.changeGui(Game.getDefaultGUI());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    } finally {
                        game.popState();
                        game.pushState(new BattleOutcomeState(new BattleOutcomeModel("ENEMY DIED! " + expGain + " EXP GAINED")));
                    }
                }
            }
        }

        if (deadCharacter != null) {
            getModel().getArena().removeEnemy(deadCharacter);
            return true;
        }
        return false;
    }

    public Integer calculateExpGain(Enemy enemy) {
        Integer levelGain = 0;
        Integer expGain = (int) ((float) enemy.getLevel() / getModel().getVaultBoy().getLevel() * 50);
        Integer resultExp = expGain + getModel().getVaultBoy().getExpPoints();
        while(resultExp >= 100) {
            levelGain++;
            resultExp -= 100;
        }
        getModel().getVaultBoy().setLevel(getModel().getVaultBoy().getLevel() + levelGain);
        return expGain;
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
