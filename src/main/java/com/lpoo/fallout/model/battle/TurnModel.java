package com.lpoo.fallout.model.battle;

import org.jetbrains.annotations.NotNull;

public class TurnModel {
    private BattleStats attackerStats;
    private BattleStats defenderStats;

    public TurnModel (@NotNull BattleStats attackerStats, @NotNull BattleStats defenderStats) {
        this.attackerStats = attackerStats;
        this.defenderStats = defenderStats;
    }

    public @NotNull BattleStats getAttackerStats() {
        return attackerStats;
    }

    public @NotNull BattleStats getDefenderStats() {
        return defenderStats;
    }
}
