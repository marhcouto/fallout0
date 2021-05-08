package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.Enemy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyComparatorTest {

    @Test
    void compare() {
        EnemyComparator enemyComparator = new EnemyComparator(new Position(0 , 0));

        Assertions.assertEquals(0, enemyComparator.compare(new Enemy(new Position(0, 1), Enemy.TYPE.RAT), new Enemy(new Position(1, 0), Enemy.TYPE.RAT)));
        Assertions.assertEquals(0, enemyComparator.compare(new Enemy(new Position(1, 1), Enemy.TYPE.RAT), new Enemy(new Position(-1, -1), Enemy.TYPE.RAT)));

        Assertions.assertEquals(-1, enemyComparator.compare(new Enemy(new Position(1, 1), Enemy.TYPE.RAT), new Enemy(new Position(2, 2), Enemy.TYPE.RAT)));
        Assertions.assertEquals(1, enemyComparator.compare(new Enemy(new Position(2, 2), Enemy.TYPE.RAT), new Enemy(new Position(1, 1), Enemy.TYPE.RAT)));
    }
}