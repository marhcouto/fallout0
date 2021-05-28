package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;

public class CommitCommand extends LevelUpCommand {
    public CommitCommand(LevelUpModel model) {
        super(model);
    }

    @Override
    public void left() {}

    @Override
    public void right() {}

    @Override
    public void activate(Game requestData) {
        model.getVaultBoy().getAttributes().changeAttributes(model.getNewAttributes());
        model.getVaultBoy().setUnusedLevelPoints(model.getVaultBoy().getUnusedLevelPoints() - model.getUsedLevel());
        model.getVaultBoy().setLevel(model.getVaultBoy().getLevel() + model.getUsedLevel());
        requestData.popState();
    }
}
