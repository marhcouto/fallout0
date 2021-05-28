package com.lpoo.fallout.controller.statsmenu.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.controller.statsmenu.StatsMenuCommand;
import com.lpoo.fallout.model.filehandling.FileHandler;
import com.lpoo.fallout.model.statsmenu.StatsMenuModel;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.WanderModel;

import java.io.IOException;

public class ResetCommand extends StatsMenuCommand {
    public ResetCommand(StatsMenuModel model) {
        super(model);
    }

    @Override
    public void activate(Game requestData) {
        FileHandler fileHandler = new FileHandler();
        try {
            WanderModel wanderModel = fileHandler.createWanderModel("gamestatinit");
            Arena arena1 = fileHandler.createArena("arena1init");
            Arena arena2 = fileHandler.createArena("arena2init");
            Arena arena3 = fileHandler.createArena("arena3init");
            FileHandler.saveModel("gamestat", wanderModel);
            FileHandler.saveArena("arena1", arena1);
            FileHandler.saveArena("arena2", arena2);
            FileHandler.saveArena("arena3", arena3);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        requestData.clearStates();
    }
}
