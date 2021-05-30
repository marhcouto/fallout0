package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.battle.command.BattleCommand;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class TurnEffectTest {

    @Test
    void testEffectDeactivation() {
        BattleCommand mockedCommand = Mockito.mock(BattleCommand.class);
        TurnEffect effect = new TurnEffect(2, mockedCommand);

        for (int i = 0; i < 2; i++) {
            effect.notifyTurnChange();
            Mockito.verify(mockedCommand, Mockito.never()).deactivate();
        }
        effect.notifyTurnChange();
        Mockito.verify(mockedCommand, Mockito.times(1)).deactivate();
    }
}