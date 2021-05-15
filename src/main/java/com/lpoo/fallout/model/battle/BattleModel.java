package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;

public class BattleModel {
    private final VaultBoy vaultBoy;
    private final Enemy fightingEnemy;

    public BattleModel (VaultBoy vaultBoy, Enemy fightingEnemy) {
        this.vaultBoy = vaultBoy;
        this.fightingEnemy = fightingEnemy;
    }
}
