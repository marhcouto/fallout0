package com.lpoo.fallout.controller.statsmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.statsmenu.StatsMenuCommand;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;

public class SaveCommand extends StatsMenuCommand {
    public SaveCommand(StatsMenuModel model) {
        super(model);
    }

    @Override
    public void activate(Game requestData) {}
}
