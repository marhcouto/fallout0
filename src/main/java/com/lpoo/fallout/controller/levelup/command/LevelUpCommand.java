package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public abstract class LevelUpCommand {
    protected final LevelUpModel model;

    public LevelUpCommand(LevelUpModel model) {
        this.model = model;
    }

    public abstract void activate(Game requestData);
    public abstract void left();
    public abstract void right();
}
