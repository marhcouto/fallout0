package com.lpoo.fallout.model.wander.element;

import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.CharacterInfo;
import com.lpoo.fallout.model.wander.Position;
import org.jetbrains.annotations.NotNull;

public class VaultBoy extends Character {
    private Integer expPoints;
    private boolean gameStarting;
    private boolean gameWon;
    private Integer unusedLevelPoints;

    public VaultBoy(@NotNull Position position) {
        super(position, new CharacterInfo(new Attributes(), 5, 8),1,2);
        this.expPoints = 0;
        this.gameStarting = true;
        this.gameWon = false;
        this.unusedLevelPoints = 1;
    }
    public VaultBoy(@NotNull Position position, @NotNull CharacterInfo characterInfo, @NotNull Integer level, @NotNull Integer attackRadius, Integer expPoints) {
        super(position, characterInfo, level, attackRadius);
        this.expPoints = expPoints;
        this.gameStarting = true;
        this.gameWon = false;
        this.unusedLevelPoints = 1;
    }

    public Integer calculateExpGain(Integer enemyLevel) {
        Integer levelGain = 0;
        Integer expGain = (int) ((float) enemyLevel / getLevel() * 50);
        expPoints += expGain;
        while(expPoints >= 100) {
            levelGain++;
            expPoints -= 100;
        }
        unusedLevelPoints = getUnusedLevelPoints() + levelGain;
        return expGain;
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

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
