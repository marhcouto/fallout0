package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuOptionsController;

public class LuckCommand extends MainMenuCommand {
    public LuckCommand(MainMenuOptionsController controller) {
        super(controller);
    }

    @Override
    public void left() {
        if (controller.getModel().getAttributes().getLuck() > 1) {
            controller.getModel().getAttributes().setLuck(controller.getModel().getAttributes().getLuck() - 1);
            controller.decrementUsedPoints();
        }
    }

    @Override
    public void right() {
        if (controller.incrementUsedPoints()) {
            controller.getModel().getAttributes().setLuck(controller.getModel().getAttributes().getLuck() + 1);
        }
    }

    @Override
    public void activate(Game requestData) { }
}
