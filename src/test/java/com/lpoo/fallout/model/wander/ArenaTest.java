package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.Door;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class ArenaTest {
    private Arena arena;
    private Enemy enemyAdded;

    @BeforeEach
    void setUp() {

        Map<Position, Wall> walls = new HashMap<>();
        walls.put(new Position(0,0), new Wall(new Position(0, 0)));
        walls.put(new Position(1,1), new Wall(new Position(1, 1)));
        walls.put(new Position(4,4), new Wall(new Position(4, 4)));

        List<Enemy> enemies = new ArrayList<>();
        enemyAdded = new Enemy(new Position(2, 2), Enemy.TYPE.RAT);
        enemies.add(enemyAdded);

        this.arena = new Arena(walls, new HashMap<Position, Door>(), enemies, "Arena111", new Position(0, 0));
    }

    @Test
    void isSpaceEmpty() {
        Assertions.assertFalse(arena.isSpaceEmpty(new Position(0, 0)));
        Assertions.assertTrue(arena.isSpaceEmpty(new Position(1, 2)));
        Assertions.assertFalse(arena.isSpaceEmpty(new Position(2, 2)));
    }

    @Test
    void hasClearSight() {
        Assertions.assertTrue(arena.hasClearSight(new Position(3, 3), new Position(3, 4)));
        Assertions.assertTrue(arena.hasClearSight(new Position(3, 3), new Position(3, 10)));
        Assertions.assertTrue(arena.hasClearSight(new Position(3, -3), new Position(3, -10)));

        Assertions.assertFalse(arena.hasClearSight(new Position(4, 3), new Position(4, 5)));
        Assertions.assertFalse(arena.hasClearSight(new Position(3, 4), new Position(5, 4)));
        Assertions.assertFalse(arena.hasClearSight(new Position(5, 4), new Position(3, 4)));

        Assertions.assertFalse(arena.hasClearSight(new Position(5, 3), new Position(3, 5)));
    }

    @Test
    void removeEnemy() {
        arena.removeEnemy(enemyAdded);
        for (Enemy enemy: arena.getEnemies()) {
            Assertions.assertNotEquals(enemy, enemyAdded);
        }
    }
}