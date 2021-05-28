package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Inventory;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.Weapon;
import org.jetbrains.annotations.NotNull;

public class VaultBoy extends Character {
    private Integer expPoints;
    private boolean gameStarting;
    private Integer unusedLevelPoints;

    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes) {
        super(position, attributes, new Inventory(5, new Weapon(8, "Lincolns Repeater", new Attributes())),1,2);
        this.expPoints = 0;
        this.gameStarting = true;
        this.unusedLevelPoints = 1;
    }
    public VaultBoy(@NotNull Position position, @NotNull Attributes attributes, @NotNull Inventory inventory, @NotNull Integer level, @NotNull Integer attackRadius, Integer expPoints) {
        super(position, attributes, inventory, level, attackRadius);
        this.expPoints = expPoints;
        this.gameStarting = true;
        this.unusedLevelPoints = 1;
    }

    public Integer calculateExpGain(Integer enemyLevel) {
        Integer levelGain = 0;
        Integer expGain = (int) ((float) enemyLevel / getLevel() * 50);
        Integer resultExp = expGain + getExpPoints();
        while(resultExp >= 100) {
            levelGain++;
            resultExp -= 100;
        }
        unusedLevelPoints = getLevel() + levelGain;
        return expGain;
    }

    public VaultBoy(Position position) {
        super(position);
    }

    public Integer getExpPoints() {
        return expPoints;
    }

    public Integer getUnusedLevelPoints() {
        return unusedLevelPoints;
    }

    public void setUnusedLevelPoints(Integer unusedLevelPoints) {
        if (unusedLevelPoints >= 0) {
            this.unusedLevelPoints = unusedLevelPoints;
        }
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
