package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.Position;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class Character extends Element {
    private final UUID id;
    private final CharacterInfo characterInfo;
    private Integer level;
    private final Integer attackRadius;

    public Character(@NotNull Position position, @NotNull CharacterInfo characterInfo, @NotNull Integer level, @NotNull Integer attackRadius) {
        super(position);
        this.id = UUID.randomUUID();
        this.characterInfo = characterInfo;
        this.level = level;
        this.attackRadius = attackRadius;
    }

    public Character(Position position) {
        this(position, new CharacterInfo(new Attributes(), 5, 4), 1, 2);
    }

    public void setLevel(Integer level) { this.level = level; }
    public @NotNull CharacterInfo getCharacterInfo() {
        return characterInfo;
    }
    public Integer getLevel() {
        return level;
    }
    public Integer getAttackRadius() {
        return attackRadius;
    }


    public boolean insideAttackRadius(Character right) {
        double distanceBetweenPositions = this.getPosition().getDist(right.getPosition());
        return !(distanceBetweenPositions > (this.getAttackRadius() + right.getAttackRadius()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Character character = (Character) o;
        return id.equals(character.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
