package com.lpoo.fallout.controller.levelup;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.levelup.LevelUpModel;

import java.io.IOException;

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
            case RESET: {
                try {
                    new FileHandler().resetSavedGame();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                game.clearStates();
                break;
            }
            default: {
                new LevelUpMenuController(getModel()).step(game, action);
                break;
            }
        }
    }
}
