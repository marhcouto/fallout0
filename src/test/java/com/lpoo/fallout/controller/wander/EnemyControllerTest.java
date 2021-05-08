package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.model.wander.element.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

class EnemyControllerTest {
    WanderModel model;
    EnemyController controller;

    @BeforeEach
    void setUp() {
        Enemy enemy = new Enemy(new Position(0, 1), Enemy.TYPE.RAT);
        model = Mockito.mock(WanderModel.class);
        Mockito.when(model.getEnemies()).thenReturn(Collections.singletonList(enemy));
        MovingEngine movingEngine= Mockito.mock(MovingEngine.class);
        Mockito.when(movingEngine.move(Mockito.any(Position.class))).thenReturn(new Position(0, 0));
        controller = new EnemyController(model, movingEngine, 0);
    }

    @Test
    void doesNotColideWithWall() {
        Mockito.when(model.isEmpty(Mockito.any(Position.class))).thenReturn(true);
        controller.moveEnemies();
        Assertions.assertEquals(new Position(0, 0), model.getEnemies().get(0).getPosition());
    }

    @Test
    void collisionWithWall() {
        Mockito.when(model.isEmpty(Mockito.any(Position.class))).thenReturn(false);
        Position originalPosition = model.getEnemies().get(0).getPosition();
        controller.moveEnemies();
        Assertions.assertEquals(originalPosition, model.getEnemies().get(0).getPosition());
    }
}