package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Arena implements Serializable {
    private final Map<Position, Wall> wallMap;
    private final List<Enemy> enemies;
    private final String name;

    public Arena(Map<Position, Wall> wallMap, List<Enemy> enemies, String name) {
        this.wallMap = wallMap;
        this.enemies = enemies;
        this.name = name;
    }

    public Map<Position, Wall> getWallMap() {
        return wallMap;
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public String getName() {
        return name;
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
}
