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
        switch (action) {
            case QUIT: {
                game.clearStates();
                break;
            }
            case ESCAPE: {
                game.popState();
                break;
            }
            default: {
                new StatsMenuOptionController(getModel()).step(game, action);
                break;
            }
        }
    }
}
