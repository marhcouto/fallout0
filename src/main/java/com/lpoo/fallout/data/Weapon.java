package com.lpoo.fallout.data;

public class Weapon {
    private final String name;
    private final Integer damage;
    private final Attributes requiredAttributes;

    public Weapon(Integer damage, String name, Attributes requiredAttributes) {
        this.damage = damage;
        this.name = name;
        this.requiredAttributes = requiredAttributes;
    }

    public Integer getDamage() {
        return damage;
    }
    public Attributes getRequiredAttributes() { return requiredAttributes; }
    public String getName() {
        return name;
    }
}
