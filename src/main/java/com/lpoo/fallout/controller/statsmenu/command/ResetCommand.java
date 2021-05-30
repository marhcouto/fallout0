package com.lpoo.fallout.controller.statsmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.statsmenu.StatsMenuCommand;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;

import java.io.File;
import java.io.IOException;

public class ResetCommand extends StatsMenuCommand {
    private FileHandler fileHandler;

    public ResetCommand(StatsMenuModel model, FileHandler fileHandler) {
        super(model);
        this.fileHandler = fileHandler;
    }

    public ResetCommand(StatsMenuModel model) {
        this(model, new FileHandler());
    }

    @Override
    public void activate(Game requestData) {
        try {
            fileHandler.resetSavedGame();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        requestData.clearStates();
    }
}
