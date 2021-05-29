package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.TurnModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class IntimidateCommandTest {
    BattleStats mockedDefenderStats;
    Float originalMiss;
    IntimidateCommand intimidateCommand;

    @BeforeEach
    void setUp() {
        BattleStats attackerStats = Mockito.mock(BattleStats.class);
        Mockito.when(attackerStats.getBaseDamage()).thenReturn(5);

        mockedDefenderStats = Mockito.mock(BattleStats.class);
        Mockito.when(mockedDefenderStats.getMissChance()).thenReturn((float) 0.25);
        originalMiss = (float) 0.25;

        TurnModel mockedModel = Mockito.mock(TurnModel.class);
        Mockito.when(mockedModel.getDefenderStats()).thenReturn(mockedDefenderStats);
        Mockito.when(mockedModel.getAttackerStats()).thenReturn(attackerStats);

        intimidateCommand = new IntimidateCommand(mockedModel);
    }

    @Test
    void checkChanges() {
        ArgumentCaptor<Float> missChanceCaptor = ArgumentCaptor.forClass(Float.class);

        intimidateCommand.activate();
        Mockito.verify(mockedDefenderStats).setMissChance(missChanceCaptor.capture());
        Assertions.assertTrue(missChanceCaptor.getValue() > originalMiss);
    }

    @Test
    void checkActivationAndDeactivation() {
        ArgumentCaptor<Float> missChanceCaptor = ArgumentCaptor.forClass(Float.class);

        intimidateCommand.activate();
        intimidateCommand.deactivate();
        Mockito.verify(mockedDefenderStats, Mockito.times(2)).setMissChance(missChanceCaptor.capture());

        Assertions.assertEquals(originalMiss, missChanceCaptor.getValue(), 0.001);
    }
}