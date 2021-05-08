package com.lpoo.fallout.model;

public abstract class Character extends Element {
    private Attributes attributes;
    private Weapon weapon;
    private Integer level;

    public Character(Position position, Attributes attributes, Integer level) {
        super(position);
        this.attributes = attributes;
        this.level = level;
    }

    public Character(Position position, Attributes attributes, Weapon weapon, Integer level) {
        super(position);
        this.attributes = attributes;
        this.weapon = weapon;
        this.level = level;
    }

    public void setLevel(Integer level) { this.level = level; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public Attributes getAttributes() { return attributes; }
    public Integer getLevel() { return level; }

    public boolean canUseWeapon(Weapon weapon) {
        return this.attributes.greaterThan(weapon.getRequiredAttributes());
    }
}
