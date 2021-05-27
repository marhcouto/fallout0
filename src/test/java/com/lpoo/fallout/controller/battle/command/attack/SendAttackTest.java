package com.lpoo.fallout.controller.battle.command.attack;

import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.TurnModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

class SendAttackTest {
    BattleStats attackerStats;
    BattleStats defenderStats;
    CommandHandler mockedHandler;

    @BeforeEach
    void setUp() {
        attackerStats = Mockito.mock(BattleStats.class);
        Mockito.when(attackerStats.getMissChance()).thenReturn((float) 0.20);
        defenderStats = Mockito.mock(BattleStats.class, Mockito.CALLS_REAL_METHODS);
        mockedHandler = Mockito.mock(CommandHandler.class);
    }

    @Test
    void testSuccess() {
        Random randomEngine = Mockito.mock(Random.class);
        Mockito.when(randomEngine.nextFloat()).thenReturn((float) 0.5);
        Mockito.when(randomEngine.nextDouble()).thenReturn(0.5);
        TurnModel model = new TurnModel(attackerStats, defenderStats);
        SendAttack sendAttack = new SendAttack(model, randomEngine);
        sendAttack.setNext(mockedHandler);

        sendAttack.handle();

        Mockito.verify(mockedHandler, Mockito.times(1)).handle();
    }

    @Test
    void testFailure() {
        Random randomEngine = Mockito.mock(Random.class);
        Mockito.when(randomEngine.nextFloat()).thenReturn((float) 0.05);
        Mockito.when(randomEngine.nextDouble()).thenReturn(0.05);
        TurnModel model = new TurnModel(attackerStats, defenderStats);
        SendAttack sendAttack = new SendAttack(model, randomEngine);
        sendAttack.setNext(mockedHandler);

        sendAttack.handle();

        Mockito.verify(mockedHandler, Mockito.never()).handle();
    }
}