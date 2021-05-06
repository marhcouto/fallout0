package com.lpoo.fallout.view.Wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.Wall;
import com.lpoo.fallout.view.Viewer;

import java.io.IOException;

public class WallViewer implements Viewer {
    private Wall wall;
    private LanternaGUI gui;

    WallViewer(LanternaGUI gui, Wall wall) {
        this.wall = wall;
        this.gui = gui;
    }

    @Override
    public void draw() throws IOException {
        gui.placeDrawable(new LanternaDrawable(wall.getPosition(), "#FF0000", "#000000", "O"));
    }
}
