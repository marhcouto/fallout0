package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

public class DefendCommand extends BattleCommand {

    public DefendCommand(@NotNull TurnModel turn) {
        super(turn);
    }

    @Override
    public void activate() {
        getTurn().setOutcome(new Message("defend\napplied", true, true));

        float newDodgeChance = (float) Math.min(getTurn().getAttackerStats().getDodgeChance() * 1.25, 1.0);
        System.out.println("NEW DODGE CHANCE:" + newDodgeChance);
        getTurn().getAttackerStats().setDodgeChance(newDodgeChance);
    }

    @Override
    public void deactivate() {
        float newDodgeChance = (float) Math.max(getTurn().getAttackerStats().getDodgeChance() * 0.75, 0.0);
        getTurn().getAttackerStats().setDodgeChance(newDodgeChance);
    }
}
