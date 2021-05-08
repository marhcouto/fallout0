package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.Enemy;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Wall;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class WanderModel {
    private VaultBoy vaultBoy;
    private List <Wall> walls;
    private List <Enemy> enemies;

    public WanderModel(@NotNull VaultBoy vaultBoy) {
        this.vaultBoy = vaultBoy;
        this.walls = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public WanderModel(@NotNull VaultBoy vaultBoy, @NotNull List<Wall> walls, @NotNull List<Enemy> enemies) {
        this.vaultBoy = vaultBoy;
        this.walls = walls;
        this.enemies = enemies;
    }

    public void setWalls(@NotNull List<Wall> walls) {
        this.walls = walls;
    }

    public void setEnemies(@NotNull List <Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setVaultBoy(@NotNull VaultBoy vaultBoy) {
        this.vaultBoy = vaultBoy;
    }

    public VaultBoy getVaultBoy() {
        return vaultBoy;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public boolean isEmpty(@NotNull Position position) {
        for (Enemy enemy: enemies) {
            if (enemy.getPosition().equals(position))
                return false;
        }
        for (Wall wall: walls) {
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;
    }

}
