package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuController;
import com.lpoo.fallout.controller.mainmenu.MainMenuOptionsController;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.states.WanderState;

import java.io.IOException;

public class NextCommand extends MainMenuCommand {
    public NextCommand(MainMenuOptionsController controller) {
        super(controller);
    }

    @Override
    public void left() { }

    @Override
    public void right() { }

    @Override
    public void activate(Game requestData) {
        requestData.clearControllers();
        try {
            requestData.pushController(new WanderState(FileHandler.createWanderModel("gamestat", controller.getModel().getAttributes())));
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
