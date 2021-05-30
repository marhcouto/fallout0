package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BattleModel implements Observable<TurnObserver> {
    private final HashSet<TurnObserver> observers;
    private final Arena arena;
    private final BattleInfo battleInfo;
    private final BattleMenuModel menuModel;

    public BattleModel (@NotNull Arena arena, @NotNull VaultBoy vaultBoy, @NotNull Enemy fightingEnemy) {
        observers = new HashSet<>();
        this.arena = arena;
        this.battleInfo = new BattleInfo(vaultBoy, fightingEnemy);
        this.menuModel = new BattleMenuModel();
    }

    public void subscribe(@NotNull TurnObserver newObserver) {
        observers.add(newObserver);
    }

    public void unsubscribe(@NotNull TurnObserver oldObserver) {
        observers.remove(oldObserver);
    }

    public @NotNull BattleMenuModel getMenuModel() {
        return this.menuModel;
    }

    public @NotNull Arena getArena() {
        return arena;
    }

    public @NotNull BattleInfo getBattleInfo() {
        return battleInfo;
    }

    public void notifyTurnChange() {
        List<TurnObserver> toRemoveList = new ArrayList<>();
        for (TurnObserver observer: observers) {
            if (observer.notifyTurnChange()) {
                toRemoveList.add(observer);
            }
        }
        for (TurnObserver observer : toRemoveList)
            unsubscribe(observer);
    }
}