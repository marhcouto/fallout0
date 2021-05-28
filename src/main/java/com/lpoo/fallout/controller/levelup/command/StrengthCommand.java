package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class StrengthCommand extends LevelUpCommand {
    public StrengthCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {
        if (model.getNewAttributes().getStrength() > 0) {
            model.getNewAttributes().setStrength(model.getNewAttributes().getStrength() - 1);
            model.freeLevel();
        }
    }

    @Override
    public void right() {
        if (model.useLevel()) {
            model.getNewAttributes().setStrength(model.getNewAttributes().getStrength() + 1);
        }
    }

    @Override
    public void activate(Game requestData) {}
}
