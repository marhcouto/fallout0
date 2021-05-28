package com.lpoo.fallout.controller.battle;

import com.lpoo.fallout.controller.Game;
import com.lpoo.fallout.gui.GUI;
import com.lpoo.fallout.model.battle.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class BattleMenuControllerTest {
    private BattleMenuController controller;
    private BattleStats attackerStats;
    private BattleStats enemyStats;
    private Game mockedGame;

    @BeforeEach
    void setUp() {
        attackerStats = Mockito.mock(BattleStats.class);
        enemyStats = Mockito.mock(BattleStats.class);
        mockedGame = Mockito.mock(Game.class);

        BattleModel mockedModel = Mockito.mock(BattleModel.class);
        BattleInfo mockedBattleInfo = Mockito.mock(BattleInfo.class);
        Mockito.when(mockedBattleInfo.getTurn()).thenReturn(new TurnModel(attackerStats, enemyStats));
        Mockito.when(mockedModel.getBattleInfo()).thenReturn(mockedBattleInfo);

        controller = new BattleMenuController(mockedModel, new BattleMenuModel());
    }

    @Test
    void testUpCommand() {
        controller.step(mockedGame, GUI.ACTION.UP);
        Assertions.assertEquals(0, controller.getModel().getSelectedIdx());
    }

    @Test
    void testDownCommand() {
        controller.step(mockedGame, GUI.ACTION.DOWN);
        Assertions.assertEquals(1, controller.getModel().getSelectedIdx());
    }

    @Test
    void testLeftCommandLimit() {
        controller.step(mockedGame, GUI.ACTION.UP);
        Assertions.assertEquals(0, controller.getModel().getSelectedIdx());
    }

    @Test
    void testRightCommandLimit() {
        controller.step(mockedGame, GUI.ACTION.RIGHT);
        Assertions.assertEquals(2, controller.getModel().getSelectedIdx());
    }

    @Test
    void testRightLimit() {
        for (int i = 0; i < (BattleMenuModel.OPTION.values().length / 2); i++) {
            controller.step(mockedGame, GUI.ACTION.RIGHT);
        }

        controller.step(mockedGame, GUI.ACTION.DOWN);
        Assertions.assertEquals(BattleMenuModel.OPTION.values().length - 1, controller.getModel().getSelectedIdx());
    }

    @Test
    void testLeftAfterRight() {
        controller.step(mockedGame, GUI.ACTION.RIGHT);
        controller.step(mockedGame, GUI.ACTION.LEFT);

        Assertions.assertEquals(0, controller.getModel().getSelectedIdx());
    }
}