package com.lpoo.fallout.model.wander;

import java.io.Serializable;

public class Weapon implements Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        if (o == null) return false;

        Weapon e = (Weapon) o;
        return this.getName().equals(e.getName());
    }
}
