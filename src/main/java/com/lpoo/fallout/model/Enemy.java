package com.lpoo.fallout.model;

import com.lpoo.fallout.controller.wander.MovingEngine;

public abstract class Enemy extends Character {
    private MovingEngine movingEngine;
    private TYPE enemyType;

    public Enemy(Position position, Attributes attributes, Integer level, TYPE enemyType) {
        super(position, attributes, level);
        this.enemyType = enemyType;
    }

    public Enemy(Position position, Attributes attributes, Weapon weapon, Integer level, TYPE enemyType) {
        super(position, attributes, weapon, level);
        this.enemyType = enemyType;
    }

    TYPE getType() {
        return enemyType;
    }

    public MovingEngine getMovingEngine() {
        return movingEngine;
    }

    public enum TYPE { SCORPION, RAT }
}
