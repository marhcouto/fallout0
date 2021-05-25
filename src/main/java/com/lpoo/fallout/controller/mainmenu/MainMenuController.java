package com.lpoo.fallout.controller.mainmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.MainController;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;

public class MainMenuController extends MainController<MainMenuModel> {
    private final MainMenuOptionsController optionsController;

    public MainMenuController(MainMenuModel model) {
        super(model);
        this.optionsController = new MainMenuOptionsController(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT) {
            game.clearControllers();
        } else {
            optionsController.step(game, action);
        }
    }
}
