package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.Enemy;
import com.lpoo.fallout.model.Hero;
import com.lpoo.fallout.model.Wall;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;

public class WanderModel {
    private Hero hero;
    private List <Wall> walls;
    private List <Enemy> enemies;

    public WanderModel() {
        this.walls = new LinkedList<>();
    }

    public void setWalls(@NotNull List<Wall> walls) {
        this.walls = walls;
    }

    public void setEnemies(@NotNull List <Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setHero(@NotNull Hero hero) {
        this.hero = hero;
    }

    public List<Wall> getWalls() {
        return walls;
    }

}
