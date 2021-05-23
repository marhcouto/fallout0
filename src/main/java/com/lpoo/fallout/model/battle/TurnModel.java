package com.lpoo.fallout.model.battle;

public class TurnModel {
    private BattleStats attackerStats;
    private BattleStats defenderStats;

    public TurnModel (BattleStats attackerStats, BattleStats defenderStats) {
        this.attackerStats = attackerStats;
        this.defenderStats = defenderStats;
    }

    public BattleStats getAttackerStats() {
        return attackerStats;
    }

    public BattleStats getDefenderStats() {
        return defenderStats;
    }
}
