package com.lpoo.fallout.controller.battle.effects;

import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.model.battle.BattleStats;

public class HealthRegen extends TurnEffect {
    private Observable<TurnObserver> observable;
    private BattleStats target;
    private int healValue;

    HealthRegen(Observable<TurnObserver> observable, BattleStats target, int healValue, int turnsAffected) {
        super(turnsAffected);
        this.observable = observable;
        this.target = target;
        this.healValue = healValue;
    }

    @Override
    public void notifyTurnChange() {
        if (getNumberOfTurnsAffected() > 0) {
            target.setHealthPoints(target.getHealthPoints() + healValue);
            decrementTurnCounter();
        } else {
            observable.unsubscribe(this);
        }
    }
}
