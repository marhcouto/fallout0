package com.lpoo.fallout.controller.statsmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;

public class StatsMenuController extends MainController<StatsMenuModel> {
    public StatsMenuController(StatsMenuModel model) {
        super(model);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT) {
            game.clearStates();
        } else {
            new StatsMenuOptionController(getModel()).step(game, action);
        }
    }
}
