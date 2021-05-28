package com.lpoo.fallout.model.battle;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BattleInfoTest {
    public BattleInfo info;
    public VaultBoy mockedVaultBoy;
    public Enemy mockedEnemy;

    @BeforeEach
    void setUp() {
        CharacterInfo mockedVaultBoyInfo = Mockito.mock(CharacterInfo.class);
        Mockito.when(mockedVaultBoyInfo.getWeaponDamage()).thenReturn(1);
        Mockito.when(mockedVaultBoyInfo.getAttributes()).thenReturn(new Attributes(1, 1, 1, 1));

        mockedVaultBoy = Mockito.mock(VaultBoy.class);
        Mockito.when(mockedVaultBoy.getLevel()).thenReturn(1);
        Mockito.when(mockedVaultBoy.getCharacterInfo()).thenReturn(mockedVaultBoyInfo);

        CharacterInfo mockedEnemyInfo = Mockito.mock(CharacterInfo.class);
        Mockito.when(mockedEnemyInfo.getAttributes()).thenReturn(new Attributes(1, 1, 1, 1));

        mockedEnemy = Mockito.mock(Enemy.class);
        Mockito.when(mockedEnemy.getCharacterInfo()).thenReturn(mockedEnemyInfo);
        Mockito.when(mockedEnemy.getLevel()).thenReturn(1);

        info = new BattleInfo(mockedVaultBoy, mockedEnemy);
    }

    @Test
    void testClassNotCopy() {
        BattleStats origAttackerStats = info.getTurn().getAttackerStats();
        BattleStats origDefenderStats = info.getTurn().getDefenderStats();
        info.changeTurn();

        Assertions.assertSame(origAttackerStats, info.getTurn().getDefenderStats());
        Assertions.assertSame(origDefenderStats, info.getTurn().getAttackerStats());
    }
}