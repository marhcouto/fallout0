package com.lpoo.fallout.controller.mainmenu.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StrengthCommandTest {
    /*StrengthCommand command;
    MainMenuOptionsController controller;

    @BeforeEach
    void setUp() {
        controller = Mockito.mock(MainMenuOptionsController.class);
        MainMenuModel model = new MainMenuModel();
        Mockito.when(controller.getModel()).thenReturn(model);
        Mockito.when(controller.incrementUsedPoints()).thenReturn(true);
        command = new StrengthCommand(controller);
    }

    @Test
    void leftEdge() {
        command.left();
        Mockito.verify(controller, Mockito.never()).decrementUsedPoints();
        Assertions.assertEquals(0, controller.getModel().getAttributes().getStrength());
    }

    @Test
    void rightNormal() {
        command.right();
        Mockito.verify(controller, Mockito.times(1)).incrementUsedPoints();
        Assertions.assertEquals(1, controller.getModel().getAttributes().getStrength());
    }

    @Test
    void leftNormal() {
        command.right();
        command.left();

        Mockito.verify(controller, Mockito.times(1)).incrementUsedPoints();
        Mockito.verify(controller, Mockito.times(1)).decrementUsedPoints();
        Assertions.assertEquals(0, controller.getModel().getAttributes().getStrength());
    }*/
}