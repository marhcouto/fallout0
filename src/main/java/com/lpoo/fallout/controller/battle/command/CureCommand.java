package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

public class CureCommand extends BattleCommand {

    public CureCommand(@NotNull TurnModel turn) {
        super(turn);
    }

    @Override
    public void activate() {
        getTurn().setOutcome(new Message("cure\napplied", BattleMenuModel.OPTION.DEFEND, true, true));

        Integer newHP = (int) ((double) getTurn().getAttackerStats().getStartingHealthPoints() * 0.2) + getTurn().getAttackerStats().getHealthPoints();
        newHP = Math.min(getTurn().getAttackerStats().getStartingHealthPoints(), newHP);
        getTurn().getAttackerStats().setHealthPoints(newHP);
    }

    @Override
    public void deactivate() {

    }
}
