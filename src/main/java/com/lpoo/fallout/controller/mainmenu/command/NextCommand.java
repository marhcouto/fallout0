package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuOptionsController;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.states.WanderState;

import java.io.IOException;

public class NextCommand extends MainMenuCommand {
    FileHandler fileHandler;

    public NextCommand(MainMenuOptionsController controller, FileHandler fileHandler) {
        super(controller);
        this.fileHandler = fileHandler;
    }

    @Override
    public void left() { }

    @Override
    public void right() { }

    @Override
    public void activate(Game requestData) {
        requestData.clearStates();
        try {
            requestData.pushController(new WanderState(fileHandler.createWanderModel("gamestat", controller.getModel().getAttributes())));
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
