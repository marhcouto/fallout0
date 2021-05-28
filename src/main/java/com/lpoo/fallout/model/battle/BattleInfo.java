package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.messagedisplay.MessageDisplayModel;
import com.lpoo.fallout.model.wander.element.Character;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.states.MessageDisplayState;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BattleInfo {
    private TurnModel curTurn;
    private final VaultBoy vaultBoy;
    private final Enemy fightingEnemy;
    private final Map<Character, BattleStats> characterStats;
    private boolean playerTurn;

    public BattleInfo(VaultBoy vaultBoy, Enemy fightingEnemy) {
        this.vaultBoy = vaultBoy;
        this.fightingEnemy = fightingEnemy;
        this.characterStats = new HashMap<>();
        this.characterStats.put(vaultBoy, new BattleStats(vaultBoy));
        this.characterStats.put(fightingEnemy, new BattleStats(fightingEnemy));
        this.playerTurn = true;
        curTurn = new TurnModel(characterStats.get(this.vaultBoy), characterStats.get(this.fightingEnemy));
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

    public @NotNull VaultBoy getVaultBoy() {
        return vaultBoy;
    }

    public @NotNull Enemy getFightingEnemy() {
        return fightingEnemy;
    }

    public @NotNull Map<Character, BattleStats> getAllCharacterStats() {
        return characterStats;
    }

    public @NotNull BattleStats getCharacterStats(@NotNull Character character) {
        return characterStats.get(character);
    }

    public Character checkDeath() {
        for (Map.Entry<Character, BattleStats> curElement: characterStats.entrySet()) {
            if (curElement.getValue().getHealthPoints() <= 0)
                return curElement.getKey();
        }
        return null;
    }
}
