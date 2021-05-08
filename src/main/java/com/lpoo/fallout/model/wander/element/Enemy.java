package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.controller.wander.MovingEngine;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.Weapon;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

public class Enemy extends Character implements Serializable {
    private TYPE enemyType;

    public Enemy(@NotNull Position position, @NotNull Attributes attributes, @NotNull Weapon weapon, @NotNull Integer level, @NotNull Integer attackRadius, TYPE enemyType) {
        super(position, attributes, weapon, level, attackRadius);
        this.enemyType = enemyType;
    }

    public Enemy(Position position, TYPE enemyType) {
        super(position);
        this.enemyType = enemyType;
    }

    public TYPE getType() {
        return enemyType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        if (o == null) return false;

        Enemy e = (Enemy) o;
        return this.getPosition().equals(e.getPosition()) && this.getLevel().equals(e.getLevel()) &&
                this.getAttributes().equals(e.getAttributes()) && this.getWeapon().equals(e.getWeapon());
    }
    public enum TYPE { SCORPION, RAT }
}
