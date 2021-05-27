package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.wander.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WordRendererTest {
    LanternaGUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(LanternaGUI.class);
    }


    @Test
    void checkWordRenderer() {
        WordRenderer wordRenderer = new WordRenderer("My", new Position(10, 10));
    }
}
