package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

public class DefendCommand extends BattleCommand {
    private Float originalDodgeChance;

    public DefendCommand(@NotNull TurnModel turn) {
        super(turn);
    }

    @Override
    public void activate() {
        getTurn().setOutcome(new Message("defend\napplied", true, true));

        originalDodgeChance = getTurn().getAttackerStats().getDodgeChance();
        float newDodgeChance = (float) Math.min(getTurn().getAttackerStats().getDodgeChance() * 1.25, 1.0);
        getTurn().getAttackerStats().setDodgeChance(newDodgeChance);
    }

    @Override
    public void deactivate() {
        float newDodgeChance = originalDodgeChance;
        getTurn().getAttackerStats().setDodgeChance(newDodgeChance);
    }
}
