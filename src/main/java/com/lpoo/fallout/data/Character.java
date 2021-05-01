package com.lpoo.fallout.data;

public class Character extends Element {
    private Attributes attributes;
    private Weapon weapon;

    public Character(Position position, Attributes attributes) {
        super(position);
        this.attributes = attributes;
    }

    public Character(Position position, Attributes attributes, Weapon weapon) {
        super(position);
        this.attributes = attributes;
        this.weapon = weapon;
    }

    public Attributes getAttributes() {
        return attributes;
    }
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean canUseWeapon(Weapon weapon) {
        return this.attributes.greaterThan(weapon.getRequiredAttributes());
    }
}
