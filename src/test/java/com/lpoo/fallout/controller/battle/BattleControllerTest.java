package com.lpoo.fallout.controller.battle;

import com.googlecode.lanterna.TerminalSize;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.battle.BattleInfo;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.states.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.io.IOException;

public class BattleControllerTest {
    BattleController battleController;
    BattleModel battleModel;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testDeath() throws IOException {
        Game game = Mockito.mock(Game.class);
        VaultBoy vaultBoy = Mockito.mock(VaultBoy.class);
        Enemy enemy = Mockito.mock(Enemy.class);
        Arena arena = Mockito.mock(Arena.class);
        BattleModel battleModel = Mockito.mock(BattleModel.class);
        BattleInfo battleInfo = Mockito.mock(BattleInfo.class);
        BattleController battleController = new BattleController(battleModel);

        Mockito.when(battleInfo.getVaultBoy()).thenReturn(vaultBoy);
        Mockito.when(battleModel.getArena()).thenReturn(arena);
        Mockito.when(battleModel.getBattleInfo()).thenReturn(battleInfo);
        Mockito.when(battleModel.getBattleInfo().checkDeath()).thenReturn(vaultBoy);
        Assertions.assertTrue(battleController.processDeath(game));
        Mockito.verify(game, Mockito.times(1)).clearStates();
        Mockito.verify(game, Mockito.times(1)).changeTerminalProperty(Mockito.any(TerminalSize.class),
                Mockito.any(Integer.class));
        Mockito.verify(game, Mockito.times(1)).pushState(Mockito.any(State.class));

        Mockito.when(battleModel.getBattleInfo().checkDeath()).thenReturn(enemy);

        Assertions.assertTrue(battleController.processDeath(game));
        Mockito.verify(game, Mockito.times(1)).popState();
        Mockito.verify(game, Mockito.times(1)).changeTerminalProperty(Mockito.any(TerminalSize.class),
                Mockito.any(Integer.class));
        Mockito.verify(game, Mockito.times(1)).pushState(Mockito.any(State.class));
        Mockito.verify(vaultBoy, Mockito.times(1)).calculateExpGain(Mockito.any(Integer.class));
        Mockito.verify(arena, Mockito.times(1)).removeEnemy(enemy);
    }
}
