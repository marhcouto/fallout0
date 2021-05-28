package com.lpoo.fallout.controller.statsmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;

public abstract class StatsMenuCommand {
    protected StatsMenuModel model;

    public StatsMenuCommand(StatsMenuModel model) {
        this.model = model;
    }

    public abstract void activate(Game requestData);
}
