package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.Weapon;
import org.jetbrains.annotations.NotNull;

public abstract class Character extends Element {
    private Attributes attributes;
    private Weapon weapon;
    private Integer level;
    private Integer attackRadius;

    public Character(@NotNull Position position, @NotNull Attributes attributes, @NotNull Weapon weapon, @NotNull Integer level, @NotNull Integer attackRadius) {
        super(position);
        this.attributes = attributes;
        this.weapon = weapon;
        this.level = level;
        this.attackRadius = attackRadius;
    }

    public Character(Position position) {
        this(position, new Attributes(), new Weapon(), 0, 5);
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
    public Integer getAttackRadius() {
        return attackRadius;
    }

    public boolean insideAttackRadius(Character right) {
        double distanceBetweenPositions = this.getPosition().getDist(right.getPosition());
        return !(distanceBetweenPositions > (this.getAttackRadius() + right.getAttackRadius()));
    }

    public boolean canUseWeapon(Weapon weapon) {
        return this.attributes.greaterThan(weapon.getRequiredAttributes());
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        if (o == null) return false;

        Character e = (Character) o;
        return this.getPosition().equals(e.getPosition()) && this.getLevel().equals(e.getLevel()) &&
                this.getAttributes().equals(e.getAttributes()) && this.getWeapon().equals(e.getWeapon());
    }
}