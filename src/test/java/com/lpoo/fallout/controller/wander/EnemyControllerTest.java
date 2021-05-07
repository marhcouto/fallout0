package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.Enemy;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class EnemyControllerTest {
    Position enemyPosition;
    EnemyController controller;
    WanderModel model;

    @BeforeEach
    void setUp() {
        enemyPosition = new Position(0, 0);
        MovingEngine mockEngine = Mockito.mock(MovingEngine.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(mockEngine.move(enemyPosition)).thenReturn(new Position(1, 0));
        Enemy mockEnemy = Mockito.mock(Enemy.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(mockEnemy.getMovingEngine()).thenReturn(mockEngine);
        mockEnemy.setPosition(enemyPosition);
        model = Mockito.mock(WanderModel.class);
        Mockito.when(model.getEnemies()).thenReturn(Collections.singletonList(mockEnemy));
        Mockito.when(model.isEmpty(Mockito.any(Position.class))).thenReturn(true);
        controller = new EnemyController(model);
    }

    @Test
    void moveRequest() {
        controller.moveEnemies();
        Assertions.assertEquals(new Position(1, 0), model.getEnemies().get(0).getPosition());
    }
}