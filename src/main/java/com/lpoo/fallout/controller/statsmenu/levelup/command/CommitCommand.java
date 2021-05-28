package com.lpoo.fallout.controller.statsmenu.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.statsmenu.levelup.LevelUpModel;
import com.lpoo.fallout.model.wander.Attributes;

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
        try {
            model.getVaultBoy().getAttributes().changeAttributes(model.getNewAttributes());
        } catch (Attributes.InvalidAttributesForChangeException exception) {
            throw new RuntimeException("Should not reach here", exception);
        }
        model.getVaultBoy().setUnusedLevelPoints(model.getVaultBoy().getUnusedLevelPoints() - model.getUsedLevel());
        model.getVaultBoy().setLevel(model.getVaultBoy().getLevel() + model.getUsedLevel());
        requestData.popState();
    }
}
