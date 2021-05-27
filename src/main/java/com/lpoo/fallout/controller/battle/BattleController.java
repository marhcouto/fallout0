package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.BattleModel;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class BattleController extends MainController<BattleModel> implements Observable<TurnObserver>{
    private final HashSet<TurnObserver> observers;

    public BattleController(BattleModel model)  {
        super(model);
        observers = new HashSet<>();
    }

    public void subscribe(@NotNull TurnObserver newObserver) {
        observers.add(newObserver);
    }

    public void unsubscribe(@NotNull TurnObserver oldObserver) {
        observers.remove(oldObserver);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT) {
            game.clearStates();
        } else if (getModel().isPlayerTurn()) {
            new BattleMenuController(this, getModel().getMenuModel()).step(game, action);
        }

        if (getModel().getTurn().getOutcome().succeeded() && System.currentTimeMillis() > getModel().getTurn().getOutcome().getEndTime()) {
            notifyTurnChange();
            getModel().changeTurn();
        }
    }

    private void notifyTurnChange() {
        for (TurnObserver observer: observers) {
            observer.notifyTurnChange();
        }
    }
}
