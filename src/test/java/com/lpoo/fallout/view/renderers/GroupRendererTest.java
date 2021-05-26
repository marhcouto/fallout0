package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class GroupRendererTest {
    LanternaGUI gui;
    WordRenderer renderer;


    @BeforeEach
    void makeWordRenderer() {
        gui = Mockito.mock(LanternaGUI.class);
        renderer = new WordRenderer("OLA", new Position(10, 10));
    }

    @Test
    void testWordRenderer() {
        Assertions.assertDoesNotThrow(() -> renderer.buildImage());
        renderer.placeElement(gui);
        Mockito.verify(gui, Mockito.atLeast(10)).placeDrawable(Mockito.any(LanternaDrawable.class), Mockito.any(Position.class));
    }
}
