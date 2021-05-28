package com.lpoo.fallout.controller.levelup;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.levelup.LevelUpModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LevelUpMenuControllerTest {
    private LevelUpController controller;
    private Game game;

    @BeforeEach
    void setUp() {
        VaultBoy vaultBoy = Mockito.mock(VaultBoy.class);
        Mockito.when(vaultBoy.getUnusedLevelPoints()).thenReturn(1);
        Mockito.when(vaultBoy.getAttributes()).thenReturn(new Attributes(1, 1, 1, 1));
        LevelUpModel mockedModel = Mockito.mock(LevelUpModel.class);
        Mockito.when(mockedModel.getVaultBoy()).thenReturn(vaultBoy);
        // Mockito.when(mockedModel.increaseSelectedIdx()).thenCallRealMethod();

        controller = new LevelUpController(mockedModel);
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
    void testEscape() {
        controller.step(game, GUI.ACTION.ESCAPE, 0);
        Mockito.verify(game, Mockito.times(1)).popState();
    }

    @Test
    void checkQuit() {
        controller.step(game, GUI.ACTION.QUIT, 0);
        Mockito.verify(game, Mockito.times(1)).clearStates();
    }
}