package com.lpoo.fallout.controller.statsmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.statsmenu.StatsMenuCommand;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;
import com.lpoo.fallout.model.statsmenu.levelup.LevelUpModel;
import com.lpoo.fallout.states.LevelUpState;

public class LevelUpCommand extends StatsMenuCommand {
    public LevelUpCommand(StatsMenuModel model) {
        super(model);
    }

    @Override
    public void activate(Game requestData) {
        requestData.pushState(new LevelUpState(new LevelUpModel(model.getVaultBoy())));
    }
}
