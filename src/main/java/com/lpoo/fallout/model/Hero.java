package com.lpoo.fallout.model;

public class Hero extends Character {
    private Integer level;

    public Hero(Position position, Attributes attributes, Integer level) {
        super(position, attributes, level);
    }

    public Hero(Position position, Attributes attributes, Weapon weapon, Integer level) {
        super(position, attributes, weapon, level);
    }


}
