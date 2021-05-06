package com.lpoo.fallout.model;

import org.jetbrains.annotations.NotNull;

public class VaultBoy extends Character {
    private Integer level;

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes) {
        super(position, attributes, 1);
    }

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes, @NotNull Weapon weapon, @NotNull Integer level) {
        super(position, attributes, weapon, level);
    }

    @Override
    protected LanternaDrawable imageCreator() {
        return new LanternaDrawable("Red", "Black", "H");
    }
}
