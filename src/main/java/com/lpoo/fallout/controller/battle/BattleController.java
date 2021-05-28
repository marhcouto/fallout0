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
        if (getModel().getBattleInfo().getTurn().getOutcome().succeeded()) {
            waitForMessage();
            getModel().getBattleInfo().changeTurn();
            getModel().notifyTurnChange();
        }
        if (!processDeath(game)) {
            if (getModel().getBattleInfo().isPlayerTurn())
                new BattleMenuController(this.getModel(), getModel().getMenuModel()).step(game, action);
            else
                new BattleMonsterController(getModel().getBattleInfo().getTurn(), this.getModel()).step(new Random());
            addCharacterInfoToMessage();
        }
    }

    private boolean processDeath(Game game) {
        Enemy deadCharacter = null;
        for (Map.Entry<Character, BattleStats> curElement: getModel().getBattleInfo().getAllCharacterStats().entrySet()) {
            if (curElement.getValue().getHealthPoints() <= 0) {
                if (curElement.getKey().equals(getModel().getBattleInfo().getVaultBoy())) {
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
        Integer expGain = (int) ((float) enemy.getLevel() / getModel().getBattleInfo().getVaultBoy().getLevel() * 50);
        Integer resultExp = expGain + getModel().getBattleInfo().getVaultBoy().getExpPoints();
        while(resultExp >= 100) {
            levelGain++;
            resultExp -= 100;
        }
        getModel().getBattleInfo().getVaultBoy().setLevel(getModel().getBattleInfo().getVaultBoy().getLevel() + levelGain);
        return expGain;
    }

    private void waitForMessage() {
        if (System.currentTimeMillis() < getModel().getBattleInfo().getTurn().getOutcome().getEndTime()) {
            try {
                Thread.sleep(getModel().getBattleInfo().getTurn().getOutcome().getEndTime() - System.currentTimeMillis());
            } catch (InterruptedException exception) {
                throw new RuntimeException("This thread should never be interrupted", exception);
            }
        }
    }

    private void addCharacterInfoToMessage() {
        if (getModel().getBattleInfo().isPlayerTurn()) {
            getModel().getBattleInfo().getTurn().getOutcome().setMessageDescriptor("Player\n" + getModel().getBattleInfo().getTurn().getOutcome().getMessageDescriptor());
        } else {
            getModel().getBattleInfo().getTurn().getOutcome().setMessageDescriptor("Enemy\n" + getModel().getBattleInfo().getTurn().getOutcome().getMessageDescriptor());
        }
    }
}
