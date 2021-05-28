package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

public class BattleControllerTest {
    /*BattleController battleController;
    BattleModel battleModel;

    @BeforeEach
    void setUp() {
        VaultBoy vaultBoy = Mockito.mock(VaultBoy.class);
        Enemy enemy = Mockito.mock(Enemy.class);
        // Mockito.when(vaultBoy)
        this.battleModel = new BattleModel(Mockito.mock(Arena.class), vaultBoy, enemy);
        this.battleController = new BattleController(this.battleModel);
    }*/

    @Test
    void testCalculateExpGain() {
        VaultBoy vaultBoy = Mockito.mock(VaultBoy.class);
        Enemy enemy = Mockito.mock(Enemy.class);
        // Mockito.when(vaultBoy)
        BattleModel battleModel = new BattleModel(Mockito.mock(Arena.class), vaultBoy, enemy);
        BattleController battleController = new BattleController(battleModel);


    }
}
