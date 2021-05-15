package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuController;
import com.lpoo.fallout.controller.wander.WanderController;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.states.WanderState;

import java.io.IOException;

public class NextCommand extends MainMenuCommand {
    public NextCommand(MainMenuController controller) {
        super(controller);
    }

    @Override
    public void left() { }

    @Override
    public void right() { }

    @Override
    public void activate(Game game) {
        game.clearControllers();
        try {
            game.pushController(new WanderState(FileHandler.createWanderModel("gamestat", controller.getModel().getAttributes())));
        } catch (IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
