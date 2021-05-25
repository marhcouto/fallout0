package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Character;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class BattleModel {
    private final BattleMenuModel menuModel;
    private final VaultBoy vaultBoyModel;
    private final Enemy enemy;
    private boolean playerTurn;
    private Map<Character, BattleStats> characterStats;

    public BattleModel (@NotNull VaultBoy vaultBoy, @NotNull Enemy fightingEnemy, @NotNull Random randomEngine) {
        characterStats = new HashMap<>();

        this.vaultBoyModel = vaultBoy;
        this.enemy = fightingEnemy;
        this.playerTurn = randomEngine.nextBoolean();

        characterStats.put(vaultBoy, new BattleStats(vaultBoy));
        characterStats.put(fightingEnemy, new BattleStats(fightingEnemy));

        this.menuModel = new BattleMenuModel();
    }

    public BattleMenuModel getMenuModel() {
        return this.menuModel;
    }

    public void changeTurn() {
        playerTurn = !playerTurn;
    }

    public TurnModel getTurn() {
        if (playerTurn) {
            return new TurnModel(new BattleStats(vaultBoyModel), new BattleStats(enemy));
        } else {
            return new TurnModel(new BattleStats(enemy), new BattleStats(vaultBoyModel));
        }
    }
}