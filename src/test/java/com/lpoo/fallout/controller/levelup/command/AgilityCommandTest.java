package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.model.levelup.LevelUpModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AgilityCommandTest {
    private LevelUpModel mockedModel;
    private AgilityCommand command;

    @BeforeEach
    void setUp() {
        mockedModel = Mockito.mock(LevelUpModel.class);
        VaultBoy vaultBoyMock = Mockito.mock(VaultBoy.class);
        Mockito.when(vaultBoyMock.getUnusedLevelPoints()).thenReturn(1);
        Mockito.when(mockedModel.getVaultBoy()).thenReturn(vaultBoyMock);
        Attributes attributes = new Attributes(0, 0, 0, 0);
        Mockito.when(mockedModel.getNewAttributes()).thenReturn(attributes);
        Mockito.when(mockedModel.useLevel()).thenReturn(true);
        command = new AgilityCommand(mockedModel);
    }

    @Test
    void leftEdge() {
        command.left();
        Mockito.verify(mockedModel, Mockito.never()).freeLevel();
        Assertions.assertEquals(0, command.getModel().getNewAttributes().getAgility());
    }

    @Test
    void rightNormal() {
        command.right();
        Mockito.verify(mockedModel, Mockito.times(1)).useLevel();
        Assertions.assertEquals(1, command.getModel().getNewAttributes().getAgility());
    }

    @Test
    void leftNormal() {
        command.right();
        command.left();

        Mockito.verify(mockedModel, Mockito.times(1)).useLevel();
        Mockito.verify(mockedModel, Mockito.times(1)).freeLevel();
        Assertions.assertEquals(0, mockedModel.getNewAttributes().getAgility());
    }
}