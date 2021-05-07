package com.lpoo.fallout.view.Wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.view.Viewer;

import java.io.IOException;

public class WanderViewer implements Viewer {
    private final LanternaGUI gui;
    private final WanderModel model;

    public WanderViewer(LanternaGUI gui, WanderModel model) {
        this.gui = gui;
        this.model = model;
    }

    @Override
    public void draw() throws IOException {
        for (Wall wall: model.getWalls()) {
            gui.placeDrawable(wall.getImage(), wall.getPosition());
        }
        gui.placeDrawable(model.getVaultBoy().getImage(), model.getVaultBoy().getPosition());
        gui.draw();
    }
}
