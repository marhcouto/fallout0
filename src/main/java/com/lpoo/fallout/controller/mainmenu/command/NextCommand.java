package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.mainmenu.MainMenuController;
import com.lpoo.fallout.controller.wander.WanderController;

public class NextCommand extends MainMenuCommand {
    public NextCommand(MainMenuController controller) {
        super(controller);
    }

    @Override
    public void left() { }

    @Override
    public void right() { }

    @Override
    public void activate() {
        controller.getGame().clearControllers();
        try {
            controller.getGame().pushController(new WanderController(controller.getGame(), controller.getModel().getAttributes()));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error changing states");
        }
    }
}
