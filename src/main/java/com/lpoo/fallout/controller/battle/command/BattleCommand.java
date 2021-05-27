package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

public abstract class BattleCommand {
    private TurnModel turn;

    public BattleCommand(@NotNull TurnModel turn) {
        this.turn = turn;
    }

    public TurnModel getTurn() {
        return turn;
    }

    public abstract void activate();
    public abstract void deactivate();
}
