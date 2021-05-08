package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.ArenaMaker;
import com.lpoo.fallout.model.wander.Arena;
import com.lpoo.fallout.model.wander.Attributes;
import com.lpoo.fallout.model.wander.Position;
import com.lpoo.fallout.model.wander.WanderModel;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileModelFactoryTest {

    @BeforeEach
    public void createRandom() {

    }

    private List<Wall> getRandomWalls() {
        List<Wall> walls = new ArrayList<>();
        Random randNumber = new Random();
        int numberWalls = randNumber.nextInt(20) + 5;

        for (int i = 0; i < numberWalls; i++)
            walls.add(new Wall(new Position(randNumber.nextInt(20) + 2, randNumber.nextInt(20) + 2)));

        return walls;
    }

    private List<Enemy> getRandomEnemies() {
        List<Enemy> enemies = new ArrayList<>();
        Random randNumber = new Random();
        int numberEnemies = randNumber.nextInt(5) + 2;

        for (int i = 0; i < numberEnemies; i++) {
            enemies.add(new Enemy(new Position(randNumber.nextInt(20) + 2, randNumber.nextInt(20) + 2),
                    new Attributes(randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10)), ))
        }
    }

    @Test
    public void getModelFromFilesTest() throws IOException, ClassNotFoundException {
        String arenaName = "arena1";
        WanderModel wanderModel;
        Arena arena;

        FileArenaFactory arenaFactory = new FileArenaFactory(arenaName);
        Assertions.assertDoesNotThrow(() -> ArenaMaker.createFile(ArenaMaker.createWalls(),
                ArenaMaker.createEnemies(), arenaName));
        Assertions.assertDoesNotThrow(() -> ArenaMaker.createGameFile(arenaName, ArenaMaker.createVaultBoy()));

        wanderModel = new FileWanderModelFactory().createWanderModel();

        for (int i = 0; i < wanderModel.getArena().getWallMap().size(); i++)
            Assertions.assertTrue(wanderModel.getArena().getWallMap().containsValue(ArenaMaker.createWalls().get(i)));

        for (int i = 0; i < wanderModel.getArena().getEnemies().size(); i++)
            Assertions.assertEquals(ArenaMaker.createEnemies().get(i), wanderModel.getArena().getEnemies().get(i));
    }
}
