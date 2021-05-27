package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.battle.command.BattleCommand;

import java.util.*;

public class TurnEffect implements TurnObserver {
    private Observable<TurnObserver> observable;
    private final BattleCommand command;
    private final UUID uniqueID;
    private int numberOfTurnsAffected;

    public TurnEffect(int numberOfTurnsAffected, BattleCommand command, Observable<TurnObserver> observable) {
        this.observable = observable;
        this.uniqueID = UUID.randomUUID();
        this.numberOfTurnsAffected = numberOfTurnsAffected;
        this.command = command;
        this.start();
    }

    public int getNumberOfTurnsAffected() {
        return numberOfTurnsAffected;
    }

    public void decrementTurnCounter() {
        numberOfTurnsAffected--;
    }

    private void start() {
        observable.subscribe(this);
        command.activate();
    }

    @Override
    public void notifyTurnChange() {
        if (getNumberOfTurnsAffected() > 0) {
            decrementTurnCounter();
        } else {
            command.deactivate();
            observable.unsubscribe(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurnEffect that = (TurnEffect) o;
        return uniqueID.equals(that.uniqueID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueID);
    }
}
