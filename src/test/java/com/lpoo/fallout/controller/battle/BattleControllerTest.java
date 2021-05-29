package com.lpoo.fallout.controller.battle;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.terminal.Terminal;
import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.model.battle.BattleInfo;
import com.lpoo.fallout.model.battle.BattleModel;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.states.MessageDisplayState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockedConstruction;
import org.mockito.Mockito;

import java.io.IOException;

public class BattleControllerTest {
    Game mockedGame;
    BattleInfo mockedInfo;
    BattleController controller;
    VaultBoy mockedVaultBoy;

    @BeforeEach
    void setUp() {
        Arena mockedArena = Mockito.mock(Arena.class);

        mockedGame = Mockito.mock(Game.class);
        BattleModel mockedModel = Mockito.mock(BattleModel.class);
        mockedInfo = Mockito.mock(BattleInfo.class);
        Mockito.when(mockedModel.getBattleInfo()).thenReturn(mockedInfo);
        Mockito.when(mockedModel.getArena()).thenReturn(mockedArena);


        mockedVaultBoy = Mockito.mock(VaultBoy.class);
        Mockito.when(mockedVaultBoy.getLevel()).thenReturn(1);
        Mockito.when(mockedVaultBoy.getUnusedLevelPoints()).thenReturn(0);
        Mockito.when(mockedVaultBoy.getExpPoints()).thenReturn(0);
        Mockito.when(mockedInfo.getVaultBoy()).thenReturn(mockedVaultBoy);

        controller = new BattleController(mockedModel);
    }

    @Test
    void processVaultBoyDeath() throws IOException {
        Mockito.when(mockedInfo.checkDeath()).thenReturn(mockedVaultBoy);
        Mockito.when(mockedInfo.getVaultBoy()).thenReturn(mockedVaultBoy);

        controller.processDeath(mockedGame);

        Mockito.verify(mockedGame, Mockito.times(1)).clearStates();
        Mockito.verify(mockedGame, Mockito.times(1)).changeTerminalProperty(Mockito.any(TerminalSize.class), Mockito.anyInt());
        Mockito.verify(mockedGame, Mockito.times(1)).pushState(Mockito.any(MessageDisplayState.class));
    }

    @Test
    void processEnemyDeath() throws IOException {
        Enemy mockedEnemy = Mockito.mock(Enemy.class);
        Mockito.when(mockedInfo.checkDeath()).thenReturn(mockedEnemy);
        Mockito.when(mockedInfo.getFightingEnemy()).thenReturn(mockedEnemy);
        Mockito.when(mockedEnemy.getLevel()).thenReturn(1);

        controller.processDeath(mockedGame);

        Mockito.verify(mockedGame, Mockito.times(1)).popState();
        Mockito.verify(mockedGame, Mockito.times(1)).changeTerminalProperty(Mockito.any(TerminalSize.class), Mockito.anyInt());
        Mockito.verify(mockedGame, Mockito.times(1)).pushState(Mockito.any(MessageDisplayState.class));
    }
}
