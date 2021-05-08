package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.Weapon;
import org.jetbrains.annotations.NotNull;

public class VaultBoy extends Character {
    private Integer level;

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes) {
        super(position, attributes, 1);
    }

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes, @NotNull Weapon weapon, @NotNull Integer level) {
        super(position, attributes, weapon, level);
    }
}
