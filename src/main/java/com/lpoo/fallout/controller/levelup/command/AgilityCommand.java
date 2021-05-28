package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class AgilityCommand extends LevelUpCommand {
    public AgilityCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {
        if (getModel().getNewAttributes().getAgility() > 0) {
            getModel().getNewAttributes().setAgility(getModel().getNewAttributes().getAgility() - 1);
            getModel().freeLevel();
        }
    }

    @Override
    public void right() {
        if (getModel().useLevel()) {
            getModel().getNewAttributes().setAgility(getModel().getNewAttributes().getAgility() + 1);
        }
    }

    @Override
    public void activate(Game requestData) {}
}