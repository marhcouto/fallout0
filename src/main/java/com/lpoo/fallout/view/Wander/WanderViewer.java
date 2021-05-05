package com.lpoo.fallout.view.Wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.view.Viewer;

import java.io.IOException;

public class WanderViewer implements Viewer {
    private final LanternaGUI gui;
    private final WanderModel model;

    WanderViewer(LanternaGUI gui, WanderModel model) {
        this.gui = gui;
        this.model = model;
    }

    @Override
    public void draw() throws IOException {
        for (Wall wall: model.getWalls()) {
            gui.placeDrawable(new LanternaDrawable(wall.getPosition(), "#FF0000", "#000000", "O"));
        }
        gui.draw();
    }
}
