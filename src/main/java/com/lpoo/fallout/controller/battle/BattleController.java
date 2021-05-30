package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.messagedisplay.MessageDisplayModel;
import com.lpoo.fallout.model.wander.element.Character;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.states.MessageDisplayState;
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

    public boolean processDeath(Game game) {
        Character deadCharacter = getModel().getBattleInfo().checkDeath();
        if (deadCharacter == getModel().getBattleInfo().getVaultBoy()) {
            game.clearStates();
            try {
                game.changeTerminalProperty(Game.DEFAULT_TERMINAL_SIZE, Game.DEFAULT_FONT_SIZE);
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                game.pushState(new MessageDisplayState(new MessageDisplayModel("VAULT BOY DIED!")));
            }
            return true;
        } else if (deadCharacter == getModel().getBattleInfo().getFightingEnemy()) {
            Integer expGain = getModel().getBattleInfo().getVaultBoy().calculateExpGain(deadCharacter.getLevel());
            try {
                game.changeTerminalProperty(Game.DEFAULT_TERMINAL_SIZE, Game.DEFAULT_FONT_SIZE);
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                game.popState();
                game.pushState(new MessageDisplayState(new MessageDisplayModel("ENEMY DIED! " + expGain + " EXP GAINED")));
            }
            getModel().getArena().removeEnemy((Enemy) deadCharacter);
            return true;
        }
        return false;
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
