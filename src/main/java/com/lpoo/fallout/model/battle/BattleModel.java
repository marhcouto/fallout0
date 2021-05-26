package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Character;

import java.util.HashMap;
import java.util.Map;

public class BattleModel {
    private final VaultBoy vaultBoy;
    private final Enemy fightingEnemy;
    private Map<Character, BattleStats> characterStats;

    public BattleModel (VaultBoy vaultBoy, Enemy fightingEnemy) {
        characterStats = new HashMap<>();

        this.vaultBoy = vaultBoy;
        this.fightingEnemy = fightingEnemy;

        characterStats.put(vaultBoy, new BattleStats(vaultBoy));
        characterStats.put(fightingEnemy, new BattleStats(fightingEnemy));
    }

    public VaultBoy getVaultBoy() {
        return vaultBoy;
    }

    public Enemy getFightingEnemy() {
        return fightingEnemy;
    }

    public Map<Character, BattleStats> getCharacterStats() {
        return characterStats;
    }
}