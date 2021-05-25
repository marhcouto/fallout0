package com.lpoo.fallout.controller.mainmenu;

import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.option.OptionMenuModel;
import com.lpoo.fallout.model.option.mainmenu.MainMenuOptionModel;
import org.jetbrains.annotations.NotNull;

public class MainMenuOptionController {
    private MainMenuOptionModel model;

    public MainMenuOptionController(@NotNull MainMenuOptionModel model) {
        this.model = model;
    }

    public void step(GUI.ACTION action) {
        switch (action) {
            case UP: {
                model.move(OptionMenuModel.DIRECTION.UP);
                break;
            }
            case DOWN: {
                model.move(OptionMenuModel.DIRECTION.DOWN);
                break;
            }
            case LEFT: {

            }
            case RIGHT: {

            }
            default: {
                break;
            }
        }
    }
}
