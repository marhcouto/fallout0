package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.Enemy;
import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Wall;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class WanderModel {
    private final VaultBoy vaultBoy;
    private List <Wall> walls;
    private List <Enemy> enemies;

    public WanderModel(VaultBoy vaultBoy) {
        this.vaultBoy = vaultBoy;
        this.walls = new LinkedList<>();
    }

    public void setWalls(@NotNull List<Wall> walls) {
        this.walls = walls;
    }

    public void setEnemies(@NotNull List <Enemy> enemies) {
        this.enemies = enemies;
    }

    public VaultBoy getVaultBoy() {
        return vaultBoy;
    }

    public List<Wall> getWalls() {
        return walls;
    }

}
