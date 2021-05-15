package com.lpoo.fallout.controller.mainmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.mainmenu.MainMenuController;

public abstract class MainMenuCommand {
    protected MainMenuController controller;

    public MainMenuCommand(MainMenuController controller) {
        this.controller = controller;
    }

    public abstract void left();
    public abstract void right();
    public abstract void activate(Game game);
}
