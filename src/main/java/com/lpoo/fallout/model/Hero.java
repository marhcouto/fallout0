package com.lpoo.fallout.model;

public class Hero extends Character {
    private Integer level;

    public Hero(Position position, Attributes attributes) {
        super(position, attributes, 1);
    }

    public Hero(Position position, Attributes attributes, Weapon weapon, Integer level) {
        super(position, attributes, weapon, level);
    }

    @Override
    protected LanternaDrawable imageCreator() {
        return new LanternaDrawable("Red", "Black", "H");
    }
}
