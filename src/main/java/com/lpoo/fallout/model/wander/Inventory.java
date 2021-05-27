package com.lpoo.fallout.model.wander;

import java.io.Serializable;

public class Inventory implements Serializable {
    private Integer noPotions;
    private Weapon weapon;

    public Inventory(Integer noPotions, Weapon weapon) {
        this.noPotions = noPotions;
        this.weapon = weapon;
    }

    public Integer getNoPotions() {
        return noPotions;
    }

    public void setNoPotions(Integer noPotions) {
        this.noPotions = noPotions;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
