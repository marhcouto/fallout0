package com.lpoo.fallout.controller.statsmenu.levelup;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.statsmenu.levelup.LevelUpModel;

public class LevelUpController extends MainController<LevelUpModel> {
    public LevelUpController(LevelUpModel model) {
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
                new LevelUpMenuController(getModel()).step(game, action);
                break;
            }
        }
    }
}
