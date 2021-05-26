package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Character;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BattleModel {
    private TurnModel curTurn;
    private final BattleMenuModel menuModel;
    private final VaultBoy vaultBoyModel;
    private final Enemy enemy;
    private boolean playerTurn;
    private final Random randomEngine;

    public BattleModel (@NotNull VaultBoy vaultBoy, @NotNull Enemy fightingEnemy, @NotNull Random randomEngine) {
        this.vaultBoyModel = vaultBoy;
        this.enemy = fightingEnemy;
        this.randomEngine = randomEngine;
        playerTurn = randomEngine.nextBoolean();
        if (playerTurn) {
            curTurn = new TurnModel(new BattleStats(vaultBoy, randomEngine), new BattleStats(enemy, randomEngine));
        } else {
            curTurn = new TurnModel(new BattleStats(enemy, randomEngine), new BattleStats(vaultBoy, randomEngine));
        }

        this.menuModel = new BattleMenuModel();
    }

    public BattleMenuModel getMenuModel() {
        return this.menuModel;
    }

    public void changeTurn() {
        playerTurn = !playerTurn;
        curTurn = new TurnModel(curTurn.getDefenderStats(), curTurn.getAttackerStats());
    }

    public boolean isPlayerTurn() {
        return playerTurn;
    }

    public @NotNull TurnModel getTurn() {
        return curTurn;
    }
}