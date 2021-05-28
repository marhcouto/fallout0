package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class LuckCommand extends LevelUpCommand {
    public LuckCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {
        if (getModel().getNewAttributes().getLuck() > 0) {
            getModel().getNewAttributes().setLuck(getModel().getNewAttributes().getLuck() - 1);
            getModel().freeLevel();
        }
    }

    @Override
    public void right() {
        if (getModel().useLevel()) {
            getModel().getNewAttributes().setLuck(getModel().getNewAttributes().getLuck() + 1);
        }
    }

    @Override
    public void activate(Game requestData) {}
}