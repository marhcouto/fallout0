package com.lpoo.fallout.model.battle;

import org.jetbrains.annotations.NotNull;

public class TurnModel {
    private BattleStats attackerStats;
    private BattleStats defenderStats;
    private Message outcome;

    public TurnModel (@NotNull BattleStats attackerStats, @NotNull BattleStats defenderStats) {
        outcome = new Message();
        this.attackerStats = attackerStats;
        this.defenderStats = defenderStats;
    }

    public @NotNull BattleStats getAttackerStats() {
        return attackerStats;
    }

    public @NotNull BattleStats getDefenderStats() {
        return defenderStats;
    }

    public Message getOutcome() {
        return outcome;
    }

    public void setOutcome(Message outcome) {
        this.outcome = outcome;
    }
}
