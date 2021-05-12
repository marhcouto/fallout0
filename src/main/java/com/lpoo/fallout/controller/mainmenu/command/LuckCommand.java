package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.mainmenu.MainMenuController;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;

public class LuckCommand extends MainMenuCommand {
    public LuckCommand(MainMenuController controller) {
        super(controller);
    }

    @Override
    public void left() {
        if (controller.getModel().getAttributes().getLuck() > 0) {
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
    public void activate() { }
}
