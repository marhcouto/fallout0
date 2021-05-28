package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Inventory;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.Weapon;
import org.jetbrains.annotations.NotNull;

public class VaultBoy extends Character {
    private Integer expPoints;
    private boolean gameStarting;

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes) {
        super(position, attributes, new Inventory(5, new Weapon(8, "Lincolns Repeater", new Attributes())),1,2);
        this.expPoints = 0;
        this.gameStarting = true;
    }
    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes, @NotNull Inventory inventory, @NotNull Integer level, @NotNull Integer attackRadius, Integer expPoints) {
        super(position, attributes, inventory, level, attackRadius);
        this.expPoints = expPoints;
        this.gameStarting = true;
    }

    public VaultBoy(Position position) {
        super(position);
    }

    public Integer getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(Integer expPoints) {
        this.expPoints = expPoints;
    }

    public boolean isGameStarting() {
        return gameStarting;
    }

    public void setGameStarting(boolean gameStarting) {
        this.gameStarting = gameStarting;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
