package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WanderModelTest {
    WanderModel model;

    @BeforeEach
    void setUp() {
        model = new WanderModel(new VaultBoy(new Position(1, 0)));
        model.setWalls(Arrays.asList(new Wall(new Position(0, 0)), new Wall(new Position(1, 1)), new Wall(new Position(4, 4))));
        model.setEnemies(Arrays.asList(new Enemy(new Position(2, 2), Enemy.TYPE.RAT)));
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(model.isEmpty(new Position(0, 0)));
        Assertions.assertTrue(model.isEmpty(new Position(1, 2)));
        Assertions.assertFalse(model.isEmpty(new Position(2, 2)));
    }

    @Test
    void hasClearSight() {
        Assertions.assertTrue(model.hasClearSight(new Position(3, 3), new Position(3, 4)));
        Assertions.assertTrue(model.hasClearSight(new Position(3, 3), new Position(3, 10)));
        Assertions.assertTrue(model.hasClearSight(new Position(3, -3), new Position(3, -10)));

        Assertions.assertFalse(model.hasClearSight(new Position(4, 3), new Position(4, 5)));
        Assertions.assertFalse(model.hasClearSight(new Position(3, 4), new Position(5, 4)));
        Assertions.assertFalse(model.hasClearSight(new Position(5, 4), new Position(3, 4)));

        Assertions.assertFalse(model.hasClearSight(new Position(5, 3), new Position(3, 5)));
    }
}