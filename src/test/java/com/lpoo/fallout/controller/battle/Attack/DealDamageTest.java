package com.lpoo.fallout.controller.battle.Attack;

import com.lpoo.fallout.controller.battle.CommandHandler;
import com.lpoo.fallout.model.battle.BattleStats;
import com.lpoo.fallout.model.battle.TurnModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Random;

class DealDamageTest {
    BattleStats attackerStats;
    BattleStats defenderStats;
    CommandHandler mockedHandler;

    @BeforeEach
    void setUp() {
        attackerStats = Mockito.mock(BattleStats.class);
        Mockito.when(attackerStats.getCritRatio()).thenReturn((float) 0.15);
        Mockito.when(attackerStats.getBaseDamage()).thenReturn(50);
        defenderStats = Mockito.mock(BattleStats.class);
        Mockito.when(defenderStats.getHealthPoints()).thenReturn(100);
        mockedHandler = Mockito.mock(CommandHandler.class);
    }

    @Test
    void testCriticalFailure() {
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        Random randomEngine = Mockito.mock(Random.class);
        Mockito.when(randomEngine.nextFloat()).thenReturn((float) 0.5);
        Mockito.when(randomEngine.nextDouble()).thenReturn(0.5);
        TurnModel model = new TurnModel(attackerStats, defenderStats);
        DealDamage dealDamage = new DealDamage(model, randomEngine);
        dealDamage.setNext(mockedHandler);

        dealDamage.handle();

        Mockito.verify(defenderStats).setHealthPoints(argumentCaptor.capture());
        Assertions.assertEquals(100 - attackerStats.getBaseDamage(), argumentCaptor.getValue(), 0.0001);
    }

    @Test
    void testCriticalSuccess() {
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);

        Random randomEngine = Mockito.mock(Random.class);
        Mockito.when(randomEngine.nextFloat()).thenReturn((float) 0.05);
        Mockito.when(randomEngine.nextDouble()).thenReturn(0.05);
        TurnModel model = new TurnModel(attackerStats, defenderStats);
        DealDamage dealDamage = new DealDamage(model, randomEngine);
        dealDamage.setNext(mockedHandler);

        dealDamage.handle();

        Mockito.verify(defenderStats).setHealthPoints(argumentCaptor.capture());
        Assertions.assertEquals(100 - BattleStats.CRIT_MULTIPLIER * attackerStats.getBaseDamage(), argumentCaptor.getValue(), 0.0001);
    }
}