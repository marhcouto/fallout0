package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Command;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuOptionsController;

public abstract class MainMenuCommand {
    protected MainMenuOptionsController controller;

    public MainMenuCommand(MainMenuOptionsController controller) {
        this.controller = controller;
    }

    public abstract void activate(Game requestData);
    public abstract void left();
    public abstract void right();
}
