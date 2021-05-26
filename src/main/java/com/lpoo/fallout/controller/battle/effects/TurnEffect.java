package com.lpoo.fallout.controller.battle.effects;

import com.lpoo.fallout.controller.battle.TurnObserver;

import java.util.Objects;
import java.util.UUID;

public abstract class TurnEffect implements TurnObserver {
    UUID uniqueID;
    int numberOfTurnsAffected;

    public TurnEffect(int numberOfTurnsAffected) {
        uniqueID = UUID.randomUUID();
        this.numberOfTurnsAffected = numberOfTurnsAffected;
    }

    public int getNumberOfTurnsAffected() {
        return numberOfTurnsAffected;
    }

    public void decrementTurnCounter() {
        numberOfTurnsAffected--;
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
