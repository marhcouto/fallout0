package com.lpoo.fallout.controller.levelup;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.levelup.LevelUpModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LevelUpMenuControllerTest {
    private LevelUpController controller;
    private Game game;
    private LevelUpModel mockedModel;

    @BeforeEach
    void setUp() {
        VaultBoy vaultBoy = Mockito.mock(VaultBoy.class);
        CharacterInfo mockedInfo = Mockito.mock(CharacterInfo.class);
        Mockito.when(mockedInfo.getAttributes()).thenReturn(new Attributes(1, 1, 1, 1));
        Mockito.when(vaultBoy.getUnusedLevelPoints()).thenReturn(1);
        Mockito.when(vaultBoy.getCharacterInfo()).thenReturn(mockedInfo);
        mockedModel = Mockito.mock(LevelUpModel.class);
        Mockito.when(mockedModel.getVaultBoy()).thenReturn(vaultBoy);

        controller = new LevelUpController(mockedModel);
        game = Mockito.mock(Game.class);
    }

    @Test
    void sendOrderDown() {
        controller.step(game, GUI.ACTION.DOWN, 0);
        Mockito.verify(mockedModel, Mockito.times(1)).increaseSelectedIdx();
    }

    @Test
    void sendUpAlreadyTopSelected() {
        controller.step(game, GUI.ACTION.UP, 0);
        Mockito.verify(mockedModel, Mockito.times(1)).decreaseSelectedIdx();
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