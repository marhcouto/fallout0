package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuOptionsController;

public class IntelligenceCommand extends MainMenuCommand {
    public IntelligenceCommand(MainMenuOptionsController controller) {
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
    public void activate(Game requestData) { }
}
