package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class NullHandler extends CommandHandler {
    NullHandler(@NotNull TurnModel model, @NotNull Random randomEngine) {
        super(model, randomEngine);
    }

    @Override
    public void handle() { }
}
