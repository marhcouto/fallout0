package com.lpoo.fallout.view.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.*;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
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
        Arena arena = new Arena(Arrays.asList(new Wall(new Position(0, 0)), new Wall(new Position(1, 1))),
                Arrays.asList(new Enemy(new Position(4, 4), Enemy.TYPE.RAT), new Enemy(new Position(2, 2), Enemy.TYPE.RAT)),
        "Teste");
        WanderModel model = new WanderModel(new VaultBoy(new Position(1, 0)), arena);
        gui = Mockito.mock(LanternaGUI.class);
        viewer = new WanderViewer(model);
    }

    @Test
    void countPlaceDrawable() throws IOException {
        viewer.draw(gui);
        /*
            There are 3 elements in the model, so, placeDrawable must be called 3 times
         */
        Mockito.verify(gui, Mockito.times(5)).placeDrawable(Mockito.any(LanternaDrawable.class), Mockito.any(Position.class));
        /*
            The commit function must be called just once. It's only called at the end of all placements
         */
        Mockito.verify(gui, Mockito.times(1)).draw();
    }
}