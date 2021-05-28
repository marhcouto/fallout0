package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class IntelligenceCommand extends LevelUpCommand {
    public IntelligenceCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {
        if (getModel().getNewAttributes().getIntelligence() > 0) {
            getModel().getNewAttributes().setIntelligence(getModel().getNewAttributes().getIntelligence() - 1);
            getModel().freeLevel();
        }
    }

    @Override
    public void right() {
        if (getModel().useLevel()) {
            getModel().getNewAttributes().setIntelligence(getModel().getNewAttributes().getIntelligence() + 1);
        }
    }

    @Override
    public void activate(Game requestData) {}
}
