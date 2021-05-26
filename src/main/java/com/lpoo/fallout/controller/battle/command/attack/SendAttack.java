package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.controller.battle.CommandHandler;
import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class SendAttack extends CommandHandler {
    SendAttack(@NotNull TurnModel model, @NotNull Random randomEngine) {
        super(model, randomEngine);
    }

    @Override
    public void handle() {
        float chance = randomEngine.nextFloat();
        if (chance >= model.getAttackerStats().getMissChance()) {
            nextCommandHandler.handle();
        }
    }
}
