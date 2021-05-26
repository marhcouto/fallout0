package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.controller.Command;
import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.controller.battle.effects.FortifyDefenseObserver;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

public class DefendCommand implements Command<NullData> {
    private Observable<TurnObserver> observable;
    TurnModel turn;

    public DefendCommand(@NotNull Observable<TurnObserver> observable, @NotNull TurnModel turn) {
        this.turn = turn;
        this.observable = observable;
    }

    @Override
    public void activate(NullData requestData) {
        BattleStats changedStats = turn.getAttackerStats();

        float defenseBuff = (float) 0.50 * turn.getAttackerStats().getdodgeChance();
        observable.subscribe(new FortifyDefenseObserver(observable, 2, changedStats, defenseBuff));
    }
}