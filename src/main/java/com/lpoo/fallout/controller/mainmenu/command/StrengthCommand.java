package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuOptionsController;

public class StrengthCommand extends MainMenuCommand {
    public StrengthCommand(MainMenuOptionsController controller) {
        super(controller);
    }

    @Override
    public void left() {
        if (controller.getModel().getAttributes().getStrength() > 1) {
            controller.getModel().getAttributes().setStrength(controller.getModel().getAttributes().getStrength() - 1);
            controller.decrementUsedPoints();
        }
    }

    @Override
    public void right() {
        if (controller.incrementUsedPoints()) {
            controller.getModel().getAttributes().setStrength(controller.getModel().getAttributes().getStrength() + 1);
        }
    }

    @Override
    public void activate(Game requestData) { }
}
