package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class StrengthCommand extends LevelUpCommand {
    public StrengthCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {
        if (getModel().getNewAttributes().getStrength() > 0) {
            getModel().getNewAttributes().setStrength(getModel().getNewAttributes().getStrength() - 1);
            getModel().freeLevel();
        }
    }

    @Override
    public void right() {
        if (getModel().useLevel()) {
            getModel().getNewAttributes().setStrength(getModel().getNewAttributes().getStrength() + 1);
        }
    }

    @Override
    public void activate(Game requestData) {}
}
