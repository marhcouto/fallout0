package com.lpoo.fallout.view.renderers;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.LanternaDrawable;
import com.lpoo.fallout.model.wander.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class HealthBarRendererTest {
    LanternaGUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void testZeroHp() {
        HealthBarRenderer hp;

        Assertions.assertDoesNotThrow(() -> new HealthBarRenderer(0, new Position(10, 10)));
        hp = new HealthBarRenderer(10, new Position(10, 10));
        hp.buildImage();
        Assertions.assertDoesNotThrow(() -> hp.updateHP(0));
        hp.placeElement(gui);
        Mockito.verify(gui, Mockito.atLeast(1)).placeDrawable(Mockito.any(LanternaDrawable.class), Mockito.any(Position.class));
    }
}
