package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.controller.battle.CommandHandler;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.TurnModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

class ReceiveAttackTest {
    BattleStats attackerStats;
    BattleStats defenderStats;
    CommandHandler mockedHandler;

    @BeforeEach
    void setUp() {
        attackerStats = Mockito.mock(BattleStats.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(attackerStats.getActions()).thenReturn(0);
        defenderStats = Mockito.mock(BattleStats.class);
        Mockito.when(defenderStats.getdodgeChance()).thenReturn((float) 0.20);
        mockedHandler = Mockito.mock(CommandHandler.class);
    }

    @Test
    void testMissFailure() {
        Random randomEngine = Mockito.mock(Random.class);
        Mockito.when(randomEngine.nextFloat()).thenReturn((float) 0.5);
        Mockito.when(randomEngine.nextDouble()).thenReturn(0.5);
        TurnModel model = new TurnModel(attackerStats, defenderStats);
        ReceiveAttack receiveAttack = new ReceiveAttack(model, randomEngine);
        receiveAttack.setNext(mockedHandler);

        receiveAttack.handle();

        Mockito.verify(mockedHandler, Mockito.times(1)).handle();
    }

    @Test
    void testMissSuccess() {
        Random randomEngine = Mockito.mock(Random.class);
        Mockito.when(randomEngine.nextFloat()).thenReturn((float) 0.05);
        Mockito.when(randomEngine.nextDouble()).thenReturn(0.05);
        TurnModel model = new TurnModel(attackerStats, defenderStats);
        ReceiveAttack receiveAttack = new ReceiveAttack(model, randomEngine);
        receiveAttack.setNext(mockedHandler);

        receiveAttack.handle();

        Mockito.verify(mockedHandler, Mockito.never()).handle();
    }
}