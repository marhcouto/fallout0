package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class NullHandler extends CommandHandler {
    public NullHandler(@NotNull TurnModel model, @NotNull Random randomEngine) { }

    @Override
    public void handle() { }
}
