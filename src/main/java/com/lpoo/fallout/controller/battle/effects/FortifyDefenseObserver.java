package com.lpoo.fallout.controller.battle.effects;

import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.model.battle.BattleStats;
import org.jetbrains.annotations.NotNull;


public class FortifyDefenseObserver extends TurnEffect {
    float defenseBoost;
    Observable<TurnObserver> observable;
    BattleStats statsChanged;

    public FortifyDefenseObserver(@NotNull Observable<TurnObserver> observable, int activeTurns, BattleStats statsChanged, float defenseBoost) {
        super(activeTurns);
        this.defenseBoost = defenseBoost;
        this.statsChanged = statsChanged;
        this.observable = observable;

        statsChanged.setDodgeChance(statsChanged.getDodgeChance() + defenseBoost);
    }

    @Override
    public void notifyTurnChange() {
        if (getNumberOfTurnsAffected() > 0) {
            decrementTurnCounter();
        } else {
            statsChanged.setDodgeChance(statsChanged.getDodgeChance() - defenseBoost);
            observable.unsubscribe(this);
        }
    }
}
