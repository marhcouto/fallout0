package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.Weapon;
import org.jetbrains.annotations.NotNull;

public class VaultBoy extends Character {

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes) {
        super(position, attributes, new Weapon(1, "Fist", new Attributes(0,0,0,0)), 1);
    }

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes, @NotNull Weapon weapon, @NotNull Integer level) {
        super(position, attributes, weapon, level);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
