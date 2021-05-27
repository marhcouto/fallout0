package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.model.battle.TurnModel;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public abstract class CommandHandler {
    protected CommandHandler nextCommandHandler;
    protected TurnModel model;
    protected Random randomEngine;

    protected CommandHandler(){};

    public CommandHandler(@NotNull TurnModel model, @NotNull Random randomEngine) {
        this.model = model;
        this.randomEngine = randomEngine;
        nextCommandHandler = new NullHandler(model, randomEngine);
    }

    public void setNext(@NotNull CommandHandler commandHandler) {
        nextCommandHandler = commandHandler;
    }

    public abstract void handle();
}
