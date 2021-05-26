package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.controller.battle.CommandHandler;
import com.lpoo.fallout.model.battle.BattleStats;
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
        if (chance >= model.getAttackerStats().getCritRatio()) {
            model.getDefenderStats().setHealthPoints(model.getDefenderStats().getHealthPoints() - model.getAttackerStats().getBaseDamage());
        } else {
            int damage = (int) Math.round(model.getAttackerStats().getBaseDamage() * BattleStats.CRIT_MULTIPLIER);
            model.getDefenderStats().setHealthPoints(model.getDefenderStats().getHealthPoints() - damage);
        }
    }
}
