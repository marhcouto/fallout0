package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.mainmenu.MainMenuController;
import com.lpoo.fallout.model.mainmenu.MainMenuModel;

public class IntelligenceCommand extends MainMenuCommand {
    public IntelligenceCommand(MainMenuController controller) {
        super(controller);
    }

    @Override
    public void left() {
        if (controller.getModel().getAttributes().getIntelligence() > 0) {
            controller.getModel().getAttributes().setIntelligence(controller.getModel().getAttributes().getIntelligence() - 1);
            controller.decrementUsedPoints();
        }
    }

    @Override
    public void right() {
        if (controller.incrementUsedPoints()) {
            controller.getModel().getAttributes().setIntelligence(controller.getModel().getAttributes().getIntelligence() + 1);
        }
    }

    @Override
    public void activate() { }
}
