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
    private final Enemy enemyModel;
    private final Map<Character, BattleStats> characterStats;
    private boolean playerTurn;

    public BattleModel (@NotNull VaultBoy vaultBoy, @NotNull Enemy fightingEnemy) {
        this.vaultBoyModel = vaultBoy;
        this.enemyModel = fightingEnemy;
        this.characterStats = new HashMap<>();
        this.characterStats.put(vaultBoyModel, new BattleStats(vaultBoyModel));
        this.characterStats.put(enemyModel, new BattleStats(enemyModel));
        playerTurn = true;
        if (playerTurn) {
            curTurn = new TurnModel(characterStats.get(this.vaultBoyModel), characterStats.get(this.enemyModel));
        } else {
            curTurn = new TurnModel(characterStats.get(this.enemyModel), characterStats.get(this.vaultBoyModel));
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

    public VaultBoy getVaultBoy() {
        return vaultBoyModel;
    }

    public Enemy getFightingEnemy() {
        return enemyModel;
    }

    public Map<Character, BattleStats> getCharacterStats() {
        return characterStats;
    }
}