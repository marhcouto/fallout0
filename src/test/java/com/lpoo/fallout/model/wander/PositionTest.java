package com.lpoo.fallout.model.wander;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    Position position;

    @BeforeEach
    void setUp() {
        position = new Position(0, 0);
    }

    @Test
    void left() {
        Assertions.assertEquals(new Position(-1, 0), position.left());
    }

    @Test
    void down() {
        Assertions.assertEquals(new Position(0, 1), position.down());
    }

    @Test
    void up() {
        Assertions.assertEquals(new Position(0, -1), position.up());
    }

    @Test
    void right() {
        Assertions.assertEquals(new Position(1, 0), position.right());
    }

    @Test
    void getDist() {
        Position pos2 = new Position(1, 1);
        Assertions.assertEquals(Math.sqrt(2), position.getDist(pos2), 0.05);
    }
}