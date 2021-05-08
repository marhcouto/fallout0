package com.lpoo.fallout.model;

import com.lpoo.fallout.controller.wander.MovingEngine;

import java.io.Serializable;

public class Enemy extends Character implements Serializable {
    private MovingEngine movingEngine;

    public Enemy(Position position, Attributes attributes, Integer level) {
        super(position, attributes, level);
    }

    public Enemy(Position position, Attributes attributes, Weapon weapon, Integer level) {
        super(position, attributes, weapon, level);
    }

    public MovingEngine getMovingEngine() {
        return movingEngine;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        if (o == null) return false;

        Enemy e = (Enemy) o;
        return this.getPosition().equals(e.getPosition()) && this.getLevel().equals(e.getLevel()) &&
                this.getAttributes().equals(e.getAttributes()) && this.getWeapon().equals(e.getWeapon());
    }
}
