package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.controller.Command;
import com.lpoo.fallout.controller.battle.BattleController;
import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.controller.battle.effects.IntimidateObserver;
import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;

public class IntimidateCommand implements Command<NullData> {
    private Observable<TurnObserver> observable;
    TurnModel turn;

    public IntimidateCommand(Observable<TurnObserver> observable, TurnModel turn) {
        this.turn = turn;
        this.observable = observable;
    }

    @Override
    public void activate(NullData requestData) {
        turn.setOutcome(new Message("intimidate\napplied", BattleMenuModel.OPTION.INTIMIDATE, true, true));
        BattleStats changedStats = turn.getDefenderStats();

        float missChanceBuff = (float) 0.10 * turn.getAttackerStats().getBaseDamage();
        observable.subscribe(new IntimidateObserver(observable, 2, changedStats, missChanceBuff));
    }
}
