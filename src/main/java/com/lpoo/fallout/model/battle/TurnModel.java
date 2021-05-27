package com.lpoo.fallout.model.battle;

import org.jetbrains.annotations.NotNull;

public class TurnModel {
    private BattleStats attackerStats;
    private BattleStats defenderStats;
    private int actions;

    public TurnModel (@NotNull BattleStats attackerStats, @NotNull BattleStats defenderStats) {
        this.attackerStats = attackerStats;
        this.defenderStats = defenderStats;
        this.actions = attackerStats.getActions();
    }

    public void registerAction() {
        this.actions--;
    }

    public int getActions() {
        return actions;
    }

    public @NotNull BattleStats getAttackerStats() {
        return attackerStats;
    }

    public @NotNull BattleStats getDefenderStats() {
        return defenderStats;
    }
}
