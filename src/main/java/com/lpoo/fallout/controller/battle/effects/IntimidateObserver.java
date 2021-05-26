package com.lpoo.fallout.controller.battle.effects;

import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.model.battle.BattleStats;

public class IntimidateObserver extends TurnEffect {
    float missChanceBuff;
    BattleStats statsChanged;
    Observable<TurnObserver> observable;

    public IntimidateObserver (Observable<TurnObserver> observable, int activeTurns, BattleStats statsChanged, float missChanceBuff) {
        super(activeTurns);
        this.statsChanged = statsChanged;
        this.missChanceBuff = missChanceBuff;
        this.observable = observable;

        statsChanged.setMissChance(statsChanged.getMissChance() + missChanceBuff);
    }

    @Override
    public void notifyTurnChange() {
        if (getNumberOfTurnsAffected() > 0) {
            decrementTurnCounter();
        } else {
            statsChanged.setMissChance(statsChanged.getMissChance() + missChanceBuff);
            observable.unsubscribe(this);
        }
    }
}
