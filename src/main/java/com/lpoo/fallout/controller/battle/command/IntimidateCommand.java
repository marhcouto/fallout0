package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;

public class IntimidateCommand extends BattleCommand {

    public IntimidateCommand(TurnModel turn) {
        super(turn);
    }

    @Override
    public void activate() {

        // Register message
        getTurn().setOutcome(new Message("intimidate\napplied", BattleMenuModel.OPTION.INTIMIDATE, true, true));

        float newMissChance = (float) Math.min( 0.10 * getTurn().getAttackerStats().getBaseDamage() + getTurn().getDefenderStats().getMissChance(), 0.5);
        getTurn().getDefenderStats().setMissChance(newMissChance);
    }

    @Override
    public void deactivate() {
        float newMissChance = (float) Math.max( getTurn().getDefenderStats().getMissChance() - 0.10 * getTurn().getAttackerStats().getBaseDamage(), 0.0);
        getTurn().getDefenderStats().setMissChance(newMissChance);
    }
}
