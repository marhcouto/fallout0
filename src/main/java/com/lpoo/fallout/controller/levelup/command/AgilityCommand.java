package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class AgilityCommand extends LevelUpCommand {
    public AgilityCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {
        if (model.getNewAttributes().getAgility() > 0) {
            model.getNewAttributes().setAgility(model.getNewAttributes().getAgility() - 1);
            model.freeLevel();
        }
    }

    @Override
    public void right() {
        if (model.useLevel()) {
            model.getNewAttributes().setAgility(model.getNewAttributes().getAgility() + 1);
        }
    }

    @Override
    public void activate(Game requestData) {}
}