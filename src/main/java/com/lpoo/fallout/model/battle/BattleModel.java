package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.controller.battle.Observable;
import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Character;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BattleModel implements Observable<TurnObserver> {
    private final HashSet<TurnObserver> observers;
    private TurnModel curTurn;
    private final Arena arena;
    private final BattleMenuModel menuModel;
    private final VaultBoy vaultBoyModel;
    private final Enemy enemyModel;
    private final Map<Character, BattleStats> characterStats;
    private boolean playerTurn;

    public BattleModel (@NotNull Arena arena, @NotNull VaultBoy vaultBoy, @NotNull Enemy fightingEnemy) {
        observers = new HashSet<>();
        this.vaultBoyModel = vaultBoy;
        this.enemyModel = fightingEnemy;
        this.characterStats = new HashMap<>();
        this.characterStats.put(vaultBoyModel, new BattleStats(vaultBoyModel));
        this.characterStats.put(enemyModel, new BattleStats(enemyModel));
        this.arena = arena;
        playerTurn = true;
        if (playerTurn) {
            curTurn = new TurnModel(characterStats.get(this.vaultBoyModel), characterStats.get(this.enemyModel));
        } else {
            curTurn = new TurnModel(characterStats.get(this.enemyModel), characterStats.get(this.vaultBoyModel));
        }

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

    public void changeTurn() {
        playerTurn = !playerTurn;
        curTurn = new TurnModel(curTurn.getDefenderStats(), curTurn.getAttackerStats());
        notifyTurnChange();
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public @NotNull TurnModel getTurn() {
        return curTurn;
    }

    public @NotNull VaultBoy getVaultBoy() {
        return vaultBoyModel;
    }

    public @NotNull Enemy getFightingEnemy() {
        return enemyModel;
    }

    public @NotNull Map<Character, BattleStats> getAllCharacterStats() {
        return characterStats;
    }

    public @NotNull BattleStats getCharacterStats(@NotNull Character character) {
        return characterStats.get(character);
    }

    private void notifyTurnChange() {
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