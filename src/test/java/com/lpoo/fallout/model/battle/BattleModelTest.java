package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.controller.battle.TurnObserver;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BattleModelTest {
    BattleModel model;

    @BeforeEach
    void setUp() {
        CharacterInfo mockedVaultBoyInfo = Mockito.mock(CharacterInfo.class);
        Mockito.when(mockedVaultBoyInfo.getWeaponDamage()).thenReturn(1);
        Mockito.when(mockedVaultBoyInfo.getAttributes()).thenReturn(new Attributes(1, 1, 1, 1));

        VaultBoy mockedVaultBoy = Mockito.mock(VaultBoy.class);
        Mockito.when(mockedVaultBoy.getLevel()).thenReturn(1);
        Mockito.when(mockedVaultBoy.getCharacterInfo()).thenReturn(mockedVaultBoyInfo);

        CharacterInfo mockedEnemyInfo = Mockito.mock(CharacterInfo.class);
        Mockito.when(mockedEnemyInfo.getAttributes()).thenReturn(new Attributes(1, 1, 1, 1));

        Enemy mockedEnemy = Mockito.mock(Enemy.class);
        Mockito.when(mockedEnemy.getCharacterInfo()).thenReturn(mockedEnemyInfo);
        Mockito.when(mockedEnemy.getLevel()).thenReturn(1);

        Arena mockedArena = Mockito.mock(Arena.class);
        model = new BattleModel(mockedArena, mockedVaultBoy, mockedEnemy);
    }

    @Test
    void checkSubscription() {
        TurnObserver observer1 = Mockito.mock(TurnObserver.class);
        TurnObserver observer2 = Mockito.mock(TurnObserver.class);

        model.subscribe(observer1);
        model.subscribe(observer2);

        model.notifyTurnChange();

        Mockito.verify(observer1, Mockito.times(1)).notifyTurnChange();
        Mockito.verify(observer2, Mockito.times(1)).notifyTurnChange();
    }

    @Test
    void checkUnsubscribe() {
        TurnObserver observer1 = Mockito.mock(TurnObserver.class);
        TurnObserver observer2 = Mockito.mock(TurnObserver.class);

        model.subscribe(observer1);
        model.subscribe(observer2);

        model.notifyTurnChange();

        Mockito.verify(observer1, Mockito.times(1)).notifyTurnChange();
        Mockito.verify(observer2, Mockito.times(1)).notifyTurnChange();

        model.unsubscribe(observer1);

        model.notifyTurnChange();

        Mockito.verify(observer1, Mockito.times(1)).notifyTurnChange();
        Mockito.verify(observer2, Mockito.times(2)).notifyTurnChange();
    }
}