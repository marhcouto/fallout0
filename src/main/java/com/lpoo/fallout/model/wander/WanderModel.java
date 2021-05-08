package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class WanderModel {
    private VaultBoy vaultBoy;
    private Map<Position, Wall> wallMap;
    private List <Enemy> enemies;

    public WanderModel(@NotNull VaultBoy vaultBoy) {
        this.vaultBoy = vaultBoy;
        this.wallMap = new HashMap<>();
        this.enemies = new ArrayList<>();
    }

    public WanderModel(@NotNull VaultBoy vaultBoy, @NotNull Map<Position, Wall> walls, @NotNull List<Enemy> enemies) {
        this.vaultBoy = vaultBoy;
        this.wallMap = walls;
        this.enemies = enemies;
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

    public boolean hasClearSight(Position pos1, Position pos2) {
        if (pos1.getRow() != pos2.getRow() && pos1.getColumn() != pos2.getColumn()) {
            return false;
        }
        if (pos1.getRow() == pos2.getRow()) {
            int from = Math.min(pos1.getColumn(), pos2.getColumn());
            int to = Math.max(pos1.getColumn(), pos2.getColumn());
            for (int i = from; i < to; i++) {
                if (wallMap.containsKey(new Position(i, pos1.getRow())))
                    return false;
            }
        } else {
            int from = Math.min(pos1.getRow(), pos2.getRow());
            int to = Math.max(pos1.getRow(), pos2.getRow());
            for (int i = from; i < to; i++) {
                if (wallMap.containsKey(new Position(pos1.getColumn(), i)))
                    return false;
            }
        }
        return true;
    }

    public AbstractQueue<Enemy> getOrderedEnemies(Position position) {
        EnemyComparator comparator = new EnemyComparator(position);
        AbstractQueue<Enemy> sortedEnemies = new PriorityQueue<>(comparator);
        sortedEnemies.addAll(enemies);
        return sortedEnemies;
    }

}
