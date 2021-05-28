package com.lpoo.fallout.controller.mainmenu;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MainMenuControllerTest {
    /*private MainMenuController controller;
    private Game game;

    @BeforeEach
    void setUp() {
        controller = new MainMenuController(new MainMenuModel());
        game = Mockito.mock(Game.class);
    }

    @Test
    void sendOrderDown() {
        controller.step(game, GUI.ACTION.DOWN, 0);
        Assertions.assertEquals(1, controller.getModel().getSelectedIdx());
    }

    @Test
    void sendUpAlreadyTopSelected() {
        controller.step(game, GUI.ACTION.UP, 0);
        Assertions.assertEquals(0, controller.getModel().getSelectedIdx());
    }

    @Test
    void checkQuit() {
        controller.step(game, GUI.ACTION.QUIT, 0);
        Mockito.verify(game, Mockito.times(1)).clearStates();
    }*/
}