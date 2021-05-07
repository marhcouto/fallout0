package com.lpoo.fallout.view.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.*;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class WanderViewerTest {
    WanderViewer viewer;
    LanternaGUI gui;

    @BeforeEach
    void setUp() {
        WanderModel model = new WanderModel(new VaultBoy(new Position(1, 0), new Attributes(0, 0, 0, 0)));
        model.setWalls(Arrays.asList(new Wall(new Position(0, 0)), new Wall(new Position(1, 1))));
        gui = Mockito.mock(LanternaGUI.class);
        viewer = new WanderViewer(gui, model);
    }

    @Test
    void countPlaceDrawable() throws IOException {
        viewer.draw();
        /*
            There are 3 elements in the model, so, placeDrawable must be called 3 times
         */
        Mockito.verify(gui, Mockito.times(3)).placeDrawable(Mockito.any(LanternaDrawable.class));
        /*
            The commit function must be called just once. It's only called at the end of all placements
         */
        Mockito.verify(gui, Mockito.times(1)).draw();
    }
}