package com.lpoo.fallout.controller.battle.command;

import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.Message;
import com.lpoo.fallout.model.battle.TurnModel;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class CureCommandTest {
    @Test
    void checkIfCureHappensWhenLifeLow() {
        VaultBoy mockedVaultBoy = Mockito.mock(VaultBoy.class);
        CharacterInfo characterInfo = Mockito.mock(CharacterInfo.class);
        Mockito.when(characterInfo.getNoPotions()).thenReturn(1);
        Mockito.when(mockedVaultBoy.getCharacterInfo()).thenReturn(characterInfo);
        TurnModel turnModel = Mockito.mock(TurnModel.class);

        BattleStats mockedStats = Mockito.mock(BattleStats.class);
        Mockito.when(mockedStats.getStartingHealthPoints()).thenReturn(10);
        Mockito.when(mockedStats.getHealthPoints()).thenReturn(5);

        Mockito.when(turnModel.getAttackerStats()).thenReturn(mockedStats);
        Mockito.when(turnModel.getAttackerStats()).thenReturn(mockedStats);

        ArgumentCaptor<Integer> healthCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> numberOfPotions = ArgumentCaptor.forClass(Integer.class);

        CureCommand cureCommand = new CureCommand(turnModel, mockedVaultBoy);
        cureCommand.activate();
        Mockito.verify(mockedStats).setHealthPoints(healthCaptor.capture());
        Mockito.verify(characterInfo).setNoPotions(numberOfPotions.capture());

        Assertions.assertTrue(healthCaptor.getValue() > 5);
        Assertions.assertEquals(0, (int) numberOfPotions.getValue());
        Mockito.verify(turnModel, Mockito.times(1)).setOutcome(Mockito.any(Message.class));
    }

    @Test
    void testCureIfHealthFull() {
        VaultBoy mockedVaultBoy = Mockito.mock(VaultBoy.class);
        CharacterInfo characterInfo = Mockito.mock(CharacterInfo.class);
        Mockito.when(characterInfo.getNoPotions()).thenReturn(1);
        Mockito.when(mockedVaultBoy.getCharacterInfo()).thenReturn(characterInfo);
        TurnModel turnModel = Mockito.mock(TurnModel.class);

        BattleStats mockedStats = Mockito.mock(BattleStats.class);
        Mockito.when(mockedStats.getStartingHealthPoints()).thenReturn(10);
        Mockito.when(mockedStats.getHealthPoints()).thenReturn(10);

        Mockito.when(turnModel.getAttackerStats()).thenReturn(mockedStats);
        Mockito.when(turnModel.getAttackerStats()).thenReturn(mockedStats);

        ArgumentCaptor<Integer> healthCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> numberOfPotions = ArgumentCaptor.forClass(Integer.class);

        CureCommand cureCommand = new CureCommand(turnModel, mockedVaultBoy);
        cureCommand.activate();
        Mockito.verify(mockedStats).setHealthPoints(healthCaptor.capture());
        Mockito.verify(characterInfo).setNoPotions(numberOfPotions.capture());

        Assertions.assertEquals(10, (int) healthCaptor.getValue());
        Assertions.assertEquals(0, (int) numberOfPotions.getValue());
        Mockito.verify(turnModel, Mockito.times(1)).setOutcome(Mockito.any(Message.class));
    }

}