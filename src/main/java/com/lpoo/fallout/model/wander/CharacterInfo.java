package com.lpoo.fallout.model.wander;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class CharacterInfo implements Serializable {
    private Integer noPotions;
    private final Integer weaponDamage;
    private final Attributes attributes;

    public CharacterInfo(@NotNull Attributes attributes, @NotNull Integer noPotions, @NotNull Integer weaponDamage) {
        this.noPotions = noPotions;
        this.weaponDamage = weaponDamage;
        this.attributes = attributes;
    }

    public Integer getNoPotions() {
        return noPotions;
    }

    public void setNoPotions(Integer noPotions) {
        this.noPotions = noPotions;
    }

    public Integer getWeaponDamage() {
        return weaponDamage;
    }

    public Attributes getAttributes() {
        return attributes;
    }
}
