package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.Hero;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.Wall;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomWanderFactory implements WanderFactory {
    private Integer width;
    private Integer height;
    private Integer numberOfEnemies;

    public RandomWanderFactory(Integer width, Integer height, Integer numberOfEnemies) {
        this.width = width;
        this.height = height;
        this.numberOfEnemies = numberOfEnemies;
    }

    @Override
    public WanderModel createWanderModel() {
        Random randomEngine = new Random();
        WanderModel newModel = new WanderModel(new HeroCreator().createHero());
        newModel.setWalls(buildWalls());
        return newModel;
    }

    public List<Wall> buildWalls() {
        List<Wall> newWalls = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            newWalls.add(new Wall(new Position(0, i)));
            newWalls.add(new Wall(new Position(width - 1, i)));
        }
        for (int i = 1; i < width - 1; i++) {
            newWalls.add(new Wall(new Position(i, 0)));
            newWalls.add(new Wall(new Position(i, height - 1)));
        }

        return newWalls;
    }
}
