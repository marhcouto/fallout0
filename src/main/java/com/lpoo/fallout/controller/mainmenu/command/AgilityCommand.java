package com.lpoo.fallout.controller.mainmenu.command;


import com.lpoo.fallout.controller.mainmenu.MainMenuController;

public class AgilityCommand extends MainMenuCommand {
    public AgilityCommand(MainMenuController controller) {
        super(controller);
    }

    @Override
    public void left() {
        if (controller.getModel().getAttributes().getAgility() > 0) {
            controller.getModel().getAttributes().setAgility(controller.getModel().getAttributes().getAgility() - 1);
            controller.decrementUsedPoints();
        }
    }

    @Override
    public void right() {
        if (controller.incrementUsedPoints()) {
            controller.getModel().getAttributes().setAgility(controller.getModel().getAttributes().getAgility() + 1);
        }
    }

    @Override
    public void activate() { }
}
