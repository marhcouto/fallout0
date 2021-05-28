package com.lpoo.fallout.controller.levelup.command;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.levelup.LevelUpModel;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CommitCommandTest {
    CommitCommand command;
    Game mockedGame;

    @BeforeEach
    void setUp() {
        Attributes vaultBoyAttributes = new Attributes(1, 1, 1, 1);
        VaultBoy vaultBoy = Mockito.mock(VaultBoy.class);
        Mockito.when(vaultBoy.getAttributes()).thenReturn(vaultBoyAttributes);
        LevelUpModel model = Mockito.mock(LevelUpModel.class);
        Mockito.when(model.getNewAttributes()).thenReturn(new Attributes(3, 3, 3, 3));
        Mockito.when(model.getVaultBoy()).thenReturn(vaultBoy);
        command = new CommitCommand(model);
        mockedGame = Mockito.mock(Game.class);
    }

    @Test
    void testVaultBoyChange() {
        command.activate(mockedGame);
        Assertions.assertEquals(4, command.getModel().getVaultBoy().getAttributes().getAgility());
        Assertions.assertEquals(4, command.getModel().getVaultBoy().getAttributes().getStrength());
        Assertions.assertEquals(4, command.getModel().getVaultBoy().getAttributes().getAgility());
        Assertions.assertEquals(4, command.getModel().getVaultBoy().getAttributes().getIntelligence());

        Mockito.verify(mockedGame, Mockito.times(1)).popState();
    }
}