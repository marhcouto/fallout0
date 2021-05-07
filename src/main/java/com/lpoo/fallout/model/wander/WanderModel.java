package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.Enemy;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Wall;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WanderModel {
    private VaultBoy vaultBoy;
    private Map<Position, Wall> wallMap;
    private List <Enemy> enemies;

    public WanderModel(@NotNull VaultBoy vaultBoy) {
        this.vaultBoy = vaultBoy;
        this.wallMap = new HashMap<>();
        this.enemies = new ArrayList<>();
    }

    public void setWalls(@NotNull List<Wall> walls) {
        for (Wall wall: walls) {
            wallMap.put(wall.getPosition(), wall);
        }
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

    public Map<Position, Wall> getWalls() {
        return wallMap;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public boolean isEmpty(@NotNull Position position) {
        if (wallMap.containsKey(position))
            return false;
        for (Enemy enemy: enemies) {
            if (enemy.getPosition().equals(position))
                return false;
        }
        return true;
    }

}
