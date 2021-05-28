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
        getModel().getVaultBoy().getCharacterInfo().getAttributes().changeAttributes(getModel().getNewAttributes());
        getModel().getVaultBoy().setUnusedLevelPoints(getModel().getVaultBoy().getUnusedLevelPoints() - getModel().getUsedLevel());
        getModel().getVaultBoy().setLevel(getModel().getVaultBoy().getLevel() + getModel().getUsedLevel());
        requestData.popState();
    }
}
