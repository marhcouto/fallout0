package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.battle.command.BattleCommand;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class TurnEffectTest {

    @Test
    void testEffectDeactivation() {

        Observable<TurnObserver> mockedObservable = Mockito.mock(new Observable<TurnObserver>(){
            @Override
            public void subscribe(@NotNull TurnObserver newObserver) {}
            @Override
            public void unsubscribe(@NotNull TurnObserver oldObserver) {}
        }.getClass());
        BattleCommand mockedCommand = Mockito.mock(BattleCommand.class);
        TurnEffect effect = new TurnEffect(2, mockedCommand, mockedObservable);

        for (int i = 0; i < 2; i++) {
            effect.notifyTurnChange();
            Mockito.verify(mockedCommand, Mockito.never()).deactivate();
        }
        effect.notifyTurnChange();
        Mockito.verify(mockedCommand, Mockito.times(1)).deactivate();
    }

}