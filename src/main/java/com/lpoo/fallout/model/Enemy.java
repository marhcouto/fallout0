package com.lpoo.fallout.model;

public class Enemy extends Character {
    private MovingEngine movingEngine;

    public Enemy(Position position, Attributes attributes, Integer level) {
        super(position, attributes, level);
    }

    public Enemy(Position position, Attributes attributes, Weapon weapon, Integer level) {
        super(position, attributes, weapon, level);
    }

    @Override
    protected LanternaDrawable imageCreator() {
        return new LanternaDrawable("GREEN", "BLACK", "M");
    }
}
