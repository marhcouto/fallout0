package com.lpoo.fallout.controller.statsmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.OptionMenuController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;

public class StatsMenuOptionController extends OptionMenuController<StatsMenuModel> {
    public StatsMenuOptionController(StatsMenuModel model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action) {
        if (action == GUI.ACTION.ENTER) {

        } else {
            super.step(game, action);
        }
    }
}
