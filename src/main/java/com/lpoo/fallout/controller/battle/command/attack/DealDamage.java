package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.model.battle.BattleMenuModel;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class DealDamage extends CommandHandler {
    DealDamage(@NotNull TurnModel model, @NotNull Random randomEngine) {
        super(model, randomEngine);
    }

    @Override
    public void handle() {
        float chance = randomEngine.nextFloat();
        Integer damageDealt;
        if (chance >= model.getAttackerStats().getCritRatio()) {
            damageDealt = model.getAttackerStats().getBaseDamage();
            model.getDefenderStats().setHealthPoints(model.getDefenderStats().getHealthPoints() - model.getAttackerStats().getBaseDamage());
        } else {
            damageDealt = Math.round(model.getAttackerStats().getBaseDamage() * BattleStats.CRIT_MULTIPLIER);
        }
        model.setOutcome(new Message("Dealt " + damageDealt, BattleMenuModel.OPTION.ATTACK, true, true));
        model.getDefenderStats().setHealthPoints(model.getDefenderStats().getHealthPoints() - damageDealt);
    }
}
