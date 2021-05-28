package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.jetbrains.annotations.NotNull;

public class CureCommand extends BattleCommand {
    private final VaultBoy vaultBoy;

    public CureCommand(@NotNull TurnModel turn, VaultBoy vaultBoy) {
        super(turn);
        this.vaultBoy = vaultBoy;
    }

    @Override
    public void activate() {

        if (vaultBoy.getCharacterInfo().getNoPotions() > 0) {
            getTurn().setOutcome(new Message("cure\napplied", true, true));

            Integer newHP = (int) ((double) getTurn().getAttackerStats().getStartingHealthPoints() * 0.2) + getTurn().getAttackerStats().getHealthPoints();
            newHP = Math.min(getTurn().getAttackerStats().getStartingHealthPoints(), newHP);
            getTurn().getAttackerStats().setHealthPoints(newHP);
            vaultBoy.getCharacterInfo().setNoPotions(vaultBoy.getCharacterInfo().getNoPotions() - 1);
        } else {
            getTurn().setOutcome(new Message("you have\nno potions", false, true));
        }
    }

    @Override
    public void deactivate() {

    }
}
