package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class LuckCommand extends LevelUpCommand {
    public LuckCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {
        if (model.getNewAttributes().getLuck() > 0) {
            model.getNewAttributes().setLuck(model.getNewAttributes().getLuck() - 1);
            model.freeLevel();
        }
    }

    @Override
    public void right() {
        if (model.useLevel()) {
            model.getNewAttributes().setLuck(model.getNewAttributes().getLuck() + 1);
        }
    }

    @Override
    public void activate(Game requestData) {}
}