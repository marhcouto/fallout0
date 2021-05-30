package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;

public class IntimidateCommand extends BattleCommand {
    private Float originalMissChance;

    public IntimidateCommand(TurnModel turn) {
        super(turn);
    }

    @Override
    public void activate() {

        // Register message
        getTurn().setOutcome(new Message("intimidate\napplied", true, true));

        originalMissChance = getTurn().getDefenderStats().getMissChance();
        float newMissChance = (float) Math.min( 0.10 * getTurn().getAttackerStats().getBaseDamage() + getTurn().getDefenderStats().getMissChance(), 0.5);
        getTurn().getDefenderStats().setMissChance(newMissChance);
    }

    @Override
    public void deactivate() {
        getTurn().getDefenderStats().setMissChance(originalMissChance);
    }
}
