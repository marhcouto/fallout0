package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.TurnModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class DefendCommandTest {
    BattleStats mockedStats;
    Float originalDodge;
    DefendCommand defendCommand;

    @BeforeEach
    void setUp() {
        mockedStats = Mockito.mock(BattleStats.class);
        Mockito.when(mockedStats.getDodgeChance()).thenReturn((float) 0.25);
        originalDodge = (float) 0.25;

        TurnModel mockedModel = Mockito.mock(TurnModel.class);
        Mockito.when(mockedModel.getAttackerStats()).thenReturn(mockedStats);

        defendCommand = new DefendCommand(mockedModel);
    }

    @Test
    void checkChanges() {
        ArgumentCaptor<Float> dodgeChanceCaptor = ArgumentCaptor.forClass(Float.class);

        defendCommand.activate();
        Mockito.verify(mockedStats).setDodgeChance(dodgeChanceCaptor.capture());
        Assertions.assertTrue(dodgeChanceCaptor.getValue() > originalDodge);
    }

    @Test
    void checkActivationAndDeactivation() {
        ArgumentCaptor<Float> dodgeChanceCaptor = ArgumentCaptor.forClass(Float.class);

        defendCommand.activate();
        defendCommand.deactivate();
        Mockito.verify(mockedStats, Mockito.times(2)).setDodgeChance(dodgeChanceCaptor.capture());

        Assertions.assertEquals(originalDodge, dodgeChanceCaptor.getValue(), 0.001);
    }
}