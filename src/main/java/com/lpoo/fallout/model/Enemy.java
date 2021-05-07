package com.lpoo.fallout.model;

import com.lpoo.fallout.controller.wander.MovingEngine;

public abstract class Enemy extends Character {
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
    protected abstract LanternaDrawable imageCreator();
}
