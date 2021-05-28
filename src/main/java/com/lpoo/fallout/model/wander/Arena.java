package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.Door;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.*;

public class Arena implements Serializable {
    private final Map<Position, Wall> wallMap;
    private final Map<Position, Door> doorMap;
    private final List<Enemy> enemies;
    private final String name;

    public Arena(Map<Position, Wall> wallMap, Map<Position, Door> doorMap, List<Enemy> enemies, String name) {
        this.wallMap = wallMap;
        this.doorMap = doorMap;
        this.enemies = enemies;
        this.name = name;
    }

    public Arena(List<Wall> walls, List<Door> doors, List<Enemy> enemies, String name) {
        this.wallMap = new HashMap<>();
        this.doorMap = new HashMap<>();
        for (Wall wall: walls)
            wallMap.put(wall.getPosition(), wall);
        for (Door door : doors)
            doorMap.put(door.getPosition(), door);
        this.enemies = enemies;
        this.name = name;
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

    public boolean isSpaceEmpty(@NotNull Position position) {
        if (wallMap.containsKey(position))
            return false;
        for (Enemy enemy: enemies) {
            if (enemy.getPosition().equals(position))
                return false;
        }
        return true;
    }

    public void removeEnemy(Enemy oldEnemy) {
        for (Enemy enemy: enemies) {
            if (enemy.equals(oldEnemy)) {
                enemies.remove(oldEnemy);
                break;
            }
        }
    }

    public AbstractQueue<Enemy> getOrderedEnemies(Position position) {
        EnemyComparator comparator = new EnemyComparator(position);
        AbstractQueue<Enemy> sortedEnemies = new PriorityQueue<>(comparator);
        sortedEnemies.addAll(enemies);
        return sortedEnemies;
    }

    public Map<Position, Wall> getWallMap() {
        return wallMap;
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public Map<Position, Door> getDoorMap() {
        return doorMap;
    }
    public String getName() {
        return name;
    }
}
