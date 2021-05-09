package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.ArenaMaker;
import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.lpoo.fallout.model.wander.element.Enemy.TYPE.RAT;

public class FileHandlingTest {

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
                    new Attributes(randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10)),
                    new Weapon(randNumber.nextInt(40), "Alakazam",
                            new Attributes(randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10))),
                    randNumber.nextInt(30), 4, RAT));
        }
        return enemies;
    }

    private VaultBoy getRandomVaultBoy() {
        Random randNumber = new Random();
        return new VaultBoy(new Position(randNumber.nextInt(5) + 2, randNumber.nextInt(5) + 2),
                new Attributes(randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10), randNumber.nextInt(10)));
    }

    @Test
    public void getModelFromFilesTest1() throws IOException, ClassNotFoundException {

        List<Enemy> enemies1, enemies2;
        List<Wall> walls1, walls2;
        VaultBoy vaultBoy1, vaultBoy2;
        enemies1 = getRandomEnemies(); enemies2 = getRandomEnemies();
        walls1 = getRandomWalls(); walls2 = getRandomWalls();
        vaultBoy1 = getRandomVaultBoy(); vaultBoy2 = getRandomVaultBoy();

        String arenaName = "arenatest";
        String gameStatFile = "testgamestat";

        //1
        Assertions.assertDoesNotThrow(() -> ArenaMaker.createFile(walls1, enemies1, arenaName));
        Assertions.assertDoesNotThrow(() -> ArenaMaker.createGameFile(arenaName, vaultBoy1, gameStatFile));
        Assertions.assertDoesNotThrow(() -> FileHandler.createWanderModel(gameStatFile)); // Simplest solution because of scopes
        WanderModel wanderModel = FileHandler.createWanderModel(gameStatFile);

        for (int i = 0; i < wanderModel.getArena().getWallMap().size(); i++) // Test walls
            Assertions.assertTrue(wanderModel.getArena().getWallMap().containsValue(walls1.get(i)));
        for (int i = 0; i < wanderModel.getArena().getEnemies().size(); i++) // Test enemies
            Assertions.assertTrue(wanderModel.getArena().getEnemies().contains(enemies1.get(i)));
        Assertions.assertEquals(vaultBoy1, wanderModel.getVaultBoy()); // Test vaultBoy

        //2
        Assertions.assertDoesNotThrow(() -> ArenaMaker.createFile(walls2, enemies2, arenaName));
        Assertions.assertDoesNotThrow(() -> ArenaMaker.createGameFile(arenaName, vaultBoy2, gameStatFile));
        Assertions.assertDoesNotThrow(() -> FileHandler.createWanderModel(gameStatFile));
        wanderModel = FileHandler.createWanderModel(gameStatFile);

        for (int i = 0; i < wanderModel.getArena().getWallMap().size(); i++) // Test walls
            Assertions.assertTrue(wanderModel.getArena().getWallMap().containsValue(walls2.get(i)));
        for (int i = 0; i < wanderModel.getArena().getEnemies().size(); i++) // Test enemies
            Assertions.assertTrue(wanderModel.getArena().getEnemies().contains(enemies2.get(i)));
        Assertions.assertEquals(vaultBoy2, wanderModel.getVaultBoy()); // Test vaultBoy

        // Delete test files
        File file1 = new File("resources/" + gameStatFile + ".bin");
        Assertions.assertTrue(file1.delete());
        File file2 = new File("resources/arenas/" + arenaName + ".bin");
        Assertions.assertTrue(file2.delete());
    }

    @Test
    public void getModelFromFilesTest2() throws IOException, ClassNotFoundException {

        String arenaName1 = "arenatest1";
        String arenaName2 = "arenatest2";
        String gameStatFile = "testgamestat";

        List<Enemy> enemies1, enemies2;
        List<Wall> walls1, walls2;
        Map<Position, Wall> wallMap1 = new HashMap<>(), wallMap2 = new HashMap<>();
        VaultBoy vaultBoy1, vaultBoy2;
        enemies1 = getRandomEnemies(); enemies2 = getRandomEnemies();
        walls1 = getRandomWalls(); walls2 = getRandomWalls();
        vaultBoy1 = getRandomVaultBoy(); vaultBoy2 = getRandomVaultBoy();

        for (Wall wall : walls1)
            wallMap1.put(wall.getPosition(), wall);
        for (Wall wall : walls2)
            wallMap2.put(wall.getPosition(), wall);

        WanderModel wanderModel1 = new WanderModel(vaultBoy1, new Arena(wallMap1, enemies1, arenaName1));
        WanderModel wanderModel2 = new WanderModel(vaultBoy2, new Arena(wallMap2, enemies2, arenaName2));

        //1
        Assertions.assertDoesNotThrow(() -> FileHandler.saveModel(gameStatFile, wanderModel1));
        Assertions.assertDoesNotThrow(() -> FileHandler.createWanderModel(gameStatFile));
        WanderModel wanderModel3 = FileHandler.createWanderModel(gameStatFile);

        for (int i = 0; i < wanderModel3.getArena().getWallMap().size(); i++) // Test walls
            Assertions.assertTrue(wanderModel3.getArena().getWallMap().containsValue(walls1.get(i)));
        for (int i = 0; i < wanderModel3.getArena().getEnemies().size(); i++) // Test enemies
            Assertions.assertEquals(enemies1.get(i), wanderModel3.getArena().getEnemies().get(i));
        Assertions.assertEquals(wanderModel1.getVaultBoy(), wanderModel3.getVaultBoy()); // Test vaultBoy

        //2
        Assertions.assertDoesNotThrow(() -> FileHandler.saveModel(gameStatFile, wanderModel2));
        Assertions.assertDoesNotThrow(() -> FileHandler.createWanderModel(gameStatFile));
        WanderModel wanderModel4 = FileHandler.createWanderModel(gameStatFile);

        for (int i = 0; i < wanderModel4.getArena().getWallMap().size(); i++) // Test walls
            Assertions.assertTrue(wanderModel4.getArena().getWallMap().containsValue(walls2.get(i)));
        for (int i = 0; i < wanderModel4.getArena().getEnemies().size(); i++) // Test enemies
            Assertions.assertTrue(wanderModel4.getArena().getEnemies().contains(wanderModel2.getArena().getEnemies().get(i)));
        Assertions.assertEquals(wanderModel2.getVaultBoy(), wanderModel4.getVaultBoy()); // Test vaultBoy

        // Delete test files
        File file1 = new File("resources/" + gameStatFile + ".bin");
        Assertions.assertTrue(file1.delete());
        File file2 = new File("resources/arenas/" + arenaName1 + ".bin");
        Assertions.assertTrue(file2.delete());
        File file3 = new File("resources/arenas/" + arenaName2 + ".bin");
        Assertions.assertTrue(file3.delete());
    }
}
