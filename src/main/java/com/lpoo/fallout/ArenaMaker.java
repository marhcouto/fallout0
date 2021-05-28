package com.lpoo.fallout;

import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArenaMaker {

    public static void createFile(List<Wall> wallsList, List<Enemy> enemies, List<Door> doors, String arenaName) throws IOException {

        Arena arena = new Arena(wallsList, doors, enemies, arenaName);

        File file = new File("resources/arenas/" + arenaName + ".bin");
        if (!file.exists())
            file.createNewFile();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file, false));
        os.writeObject(arena);
        os.close();
    }

    public static VaultBoy createVaultBoy() {
        return new VaultBoy(new Position(5, 5), new Attributes(1,1,1,1));
    }

    public static void createGameFile(String arena, VaultBoy vaultBoy, String fileName) throws IOException {

        File file = new File("resources/" + fileName + ".bin");
        if (!file.exists())
            file.createNewFile();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(arena);
        os.writeObject(vaultBoy);
        os.close();
    }

    public static List<Door> createDoors1() {
        List<Door> doors = new ArrayList<>();

        // 1
        doors.add(new Door(new Position(25, 12), "arena2", new Position(1, 5)));

        return doors;
    }

    public static List<Door> createDoors2() {
        List<Door> doors = new ArrayList<>();

        // 2
        doors.add(new Door(new Position(1, 5), "arena1", new Position(25, 12)));
        doors.add(new Door(new Position(18, 1), "arena3", new Position(2, 15)));

        return doors;
    }

    public static List<Door> createDoors3() {
        List<Door> doors = new ArrayList<>();

        // 3
        doors.add(new Door(new Position(2, 15), "arena2", new Position(18,1)));
        return doors;
    }

    public static List<Wall> createWalls2() {
        List<Wall> walls = new ArrayList<>();
        // 2
        walls.add(new Wall(new Position(21, 12)));
        walls.add(new Wall(new Position(18, 0)));
        walls.add(new Wall(new Position(0, 5)));
        walls.add(new Wall(new Position(22, 12)));
        walls.add(new Wall(new Position(18, 13)));
        walls.add(new Wall(new Position(18, 12)));
        walls.add(new Wall(new Position(7, 12)));
        walls.add(new Wall(new Position(7, 13)));
        walls.add(new Wall(new Position(14, 14)));
        walls.add(new Wall(new Position(14, 13)));
        walls.add(new Wall(new Position(10, 11)));
        walls.add(new Wall(new Position(10, 12)));
        walls.add(new Wall(new Position(1, 1)));
        walls.add(new Wall(new Position(2, 1)));
        walls.add(new Wall(new Position(3, 1)));
        walls.add(new Wall(new Position(4, 1)));
        walls.add(new Wall(new Position(5, 1)));
        walls.add(new Wall(new Position(6, 1)));
        walls.add(new Wall(new Position(7, 1)));
        walls.add(new Wall(new Position(8, 1)));
        walls.add(new Wall(new Position(9, 1)));
        walls.add(new Wall(new Position(1, 1)));
        walls.add(new Wall(new Position(1, 2)));
        walls.add(new Wall(new Position(1, 3)));
        walls.add(new Wall(new Position(1, 4)));
        walls.add(new Wall(new Position(1, 6)));
        walls.add(new Wall(new Position(1, 7)));
        walls.add(new Wall(new Position(1, 8)));
        walls.add(new Wall(new Position(1, 9)));
        walls.add(new Wall(new Position(1, 10)));
        walls.add(new Wall(new Position(1, 11)));
        walls.add(new Wall(new Position(1, 12)));
        walls.add(new Wall(new Position(1, 13)));
        walls.add(new Wall(new Position(1, 14)));
        walls.add(new Wall(new Position(1, 15)));
        walls.add(new Wall(new Position(10, 2)));
        walls.add(new Wall(new Position(9, 3)));
        walls.add(new Wall(new Position(8, 4)));
        walls.add(new Wall(new Position(7, 5)));
        walls.add(new Wall(new Position(6, 6)));
        walls.add(new Wall(new Position(5, 7)));
        walls.add(new Wall(new Position(4, 8)));
        walls.add(new Wall(new Position(4, 9)));
        walls.add(new Wall(new Position(4, 10)));
        walls.add(new Wall(new Position(5, 10)));
        walls.add(new Wall(new Position(6,  10)));
        walls.add(new Wall(new Position(7, 10)));
        walls.add(new Wall(new Position(8, 10)));
        walls.add(new Wall(new Position(9, 10)));
        walls.add(new Wall(new Position(10, 10)));
        walls.add(new Wall(new Position(11, 10)));
        walls.add(new Wall(new Position(12, 10)));
        walls.add(new Wall(new Position(13, 10)));
        walls.add(new Wall(new Position(14, 10)));
        walls.add(new Wall(new Position(15, 10)));
        walls.add(new Wall(new Position(16, 10)));
        walls.add(new Wall(new Position(17, 10)));
        walls.add(new Wall(new Position(18, 10)));
        walls.add(new Wall(new Position(19, 10)));
        walls.add(new Wall(new Position(20, 10)));
        walls.add(new Wall(new Position(10, 15)));
        walls.add(new Wall(new Position(1, 15)));
        walls.add(new Wall(new Position(2, 15)));
        walls.add(new Wall(new Position(3, 15)));
        walls.add(new Wall(new Position(4, 15)));
        walls.add(new Wall(new Position(5, 15)));
        walls.add(new Wall(new Position(6, 15)));
        walls.add(new Wall(new Position(7, 15)));
        walls.add(new Wall(new Position(8, 15)));
        walls.add(new Wall(new Position(9, 15)));
        walls.add(new Wall(new Position(10, 15)));
        walls.add(new Wall(new Position(11, 15)));
        walls.add(new Wall(new Position(12, 15)));
        walls.add(new Wall(new Position(13, 15)));
        walls.add(new Wall(new Position(26, 12)));
        walls.add(new Wall(new Position(14, 15)));
        walls.add(new Wall(new Position(15, 15)));
        walls.add(new Wall(new Position(16, 15)));
        walls.add(new Wall(new Position(17, 15)));
        walls.add(new Wall(new Position(18, 15)));
        walls.add(new Wall(new Position(19, 15)));
        walls.add(new Wall(new Position(20, 15)));
        walls.add(new Wall(new Position(21, 15)));
        walls.add(new Wall(new Position(22, 15)));
        walls.add(new Wall(new Position(23, 15)));
        walls.add(new Wall(new Position(24, 15)));
        walls.add(new Wall(new Position(24, 14)));
        walls.add(new Wall(new Position(24, 13)));
        walls.add(new Wall(new Position(24, 12)));
        walls.add(new Wall(new Position(24, 11)));
        walls.add(new Wall(new Position(24, 10)));
        walls.add(new Wall(new Position(20, 9)));
        walls.add(new Wall(new Position(20, 8)));
        walls.add(new Wall(new Position(19, 7)));
        walls.add(new Wall(new Position(18, 6)));
        walls.add(new Wall(new Position(17, 5)));
        walls.add(new Wall(new Position(16, 4)));
        walls.add(new Wall(new Position(15, 3)));
        walls.add(new Wall(new Position(14, 2)));
        walls.add(new Wall(new Position(24, 9)));
        walls.add(new Wall(new Position(24, 8)));
        walls.add(new Wall(new Position(24, 7)));
        walls.add(new Wall(new Position(24, 6)));
        walls.add(new Wall(new Position(24, 5)));
        walls.add(new Wall(new Position(24, 4)));
        walls.add(new Wall(new Position(24, 3)));
        walls.add(new Wall(new Position(24, 2)));
        walls.add(new Wall(new Position(24, 1)));
        walls.add(new Wall(new Position(23, 1)));
        walls.add(new Wall(new Position(22, 1)));
        walls.add(new Wall(new Position(21, 1)));
        walls.add(new Wall(new Position(20, 1)));
        walls.add(new Wall(new Position(19, 1)));
        walls.add(new Wall(new Position(17, 1)));
        walls.add(new Wall(new Position(16, 1)));
        walls.add(new Wall(new Position(15, 1)));

        return walls;
    }

    public static List<Wall> createWalls3() {
        List<Wall> walls = new ArrayList<>();

        //3
        walls.add(new Wall(new Position(2, 16)));
        walls.add(new Wall(new Position(16, 7)));
        walls.add(new Wall(new Position(16, 8)));
        walls.add(new Wall(new Position(16, 9)));
        walls.add(new Wall(new Position(17, 5)));
        walls.add(new Wall(new Position(18, 5)));
        walls.add(new Wall(new Position(19, 5)));
        walls.add(new Wall(new Position(1, 10)));
        walls.add(new Wall(new Position(1, 15)));
        walls.add(new Wall(new Position(1, 14)));
        walls.add(new Wall(new Position(1, 13)));
        walls.add(new Wall(new Position(1, 12)));
        walls.add(new Wall(new Position(1, 11)));
        walls.add(new Wall(new Position(1, 10)));
        walls.add(new Wall(new Position(1, 9)));
        walls.add(new Wall(new Position(1, 8)));
        walls.add(new Wall(new Position(1, 7)));
        walls.add(new Wall(new Position(1, 6)));
        walls.add(new Wall(new Position(1, 5)));
        walls.add(new Wall(new Position(1, 4)));
        walls.add(new Wall(new Position(1, 3)));
        walls.add(new Wall(new Position(1, 2)));
        walls.add(new Wall(new Position(1, 1)));
        walls.add(new Wall(new Position(3, 15)));
        walls.add(new Wall(new Position(3, 14)));
        walls.add(new Wall(new Position(3, 13)));
        walls.add(new Wall(new Position(3, 12)));
        walls.add(new Wall(new Position(3, 11)));
        walls.add(new Wall(new Position(3, 10)));
        walls.add(new Wall(new Position(3, 9)));
        walls.add(new Wall(new Position(3, 8)));
        walls.add(new Wall(new Position(3, 7)));
        walls.add(new Wall(new Position(3, 6)));
        walls.add(new Wall(new Position(3, 5)));
        walls.add(new Wall(new Position(3, 4)));
        walls.add(new Wall(new Position(3, 3)));
        walls.add(new Wall(new Position(4, 3)));
        walls.add(new Wall(new Position(5, 3)));
        walls.add(new Wall(new Position(6, 3)));
        walls.add(new Wall(new Position(7, 3)));
        walls.add(new Wall(new Position(8, 3)));
        walls.add(new Wall(new Position(9, 3)));
        walls.add(new Wall(new Position(10, 3)));
        walls.add(new Wall(new Position( 2, 1)));
        walls.add(new Wall(new Position( 3, 1)));
        walls.add(new Wall(new Position( 4, 1)));
        walls.add(new Wall(new Position( 5, 1)));
        walls.add(new Wall(new Position( 6, 1)));
        walls.add(new Wall(new Position( 7, 1)));
        walls.add(new Wall(new Position( 8, 1)));
        walls.add(new Wall(new Position( 9, 1)));
        walls.add(new Wall(new Position( 10, 1)));
        walls.add(new Wall(new Position( 11, 1)));
        walls.add(new Wall(new Position( 12, 1)));
        walls.add(new Wall(new Position( 13, 1)));
        walls.add(new Wall(new Position( 14, 1)));
        walls.add(new Wall(new Position( 15, 1)));
        walls.add(new Wall(new Position( 16, 1)));
        walls.add(new Wall(new Position( 17, 1)));
        walls.add(new Wall(new Position( 18, 1)));
        walls.add(new Wall(new Position( 19, 1)));
        walls.add(new Wall(new Position( 20, 1)));
        walls.add(new Wall(new Position( 21, 1)));
        walls.add(new Wall(new Position( 22, 2)));
        walls.add(new Wall(new Position( 23, 3)));
        walls.add(new Wall(new Position( 24, 4)));
        walls.add(new Wall(new Position( 25, 5)));
        walls.add(new Wall(new Position(10, 4)));
        walls.add(new Wall(new Position(10, 5)));
        walls.add(new Wall(new Position(10, 6)));
        walls.add(new Wall(new Position(10, 7)));
        walls.add(new Wall(new Position(10, 8)));
        walls.add(new Wall(new Position(10, 9)));
        walls.add(new Wall(new Position(10, 10)));
        walls.add(new Wall(new Position(11, 11)));
        walls.add(new Wall(new Position(12, 12)));
        walls.add(new Wall(new Position(13, 13)));
        walls.add(new Wall(new Position(14, 14)));
        walls.add(new Wall(new Position(15, 15)));
        walls.add(new Wall(new Position(16, 15)));
        walls.add(new Wall(new Position(17, 15)));
        walls.add(new Wall(new Position(18, 15)));
        walls.add(new Wall(new Position(19, 15)));
        walls.add(new Wall(new Position(20, 15)));
        walls.add(new Wall(new Position(21, 15)));
        walls.add(new Wall(new Position(22, 15)));
        walls.add(new Wall(new Position(23, 15)));
        walls.add(new Wall(new Position(24, 15)));
        walls.add(new Wall(new Position(25, 15)));
        walls.add(new Wall(new Position(25, 14)));
        walls.add(new Wall(new Position(25, 13)));
        walls.add(new Wall(new Position(25, 12)));
        walls.add(new Wall(new Position(25, 11)));
        walls.add(new Wall(new Position(25, 10)));
        walls.add(new Wall(new Position(25, 9)));
        walls.add(new Wall(new Position(25, 8)));
        walls.add(new Wall(new Position(25, 7)));
        walls.add(new Wall(new Position(25, 6)));

        return walls;
    }
    public static List<Wall> createWalls1() {
        List<Wall> walls = new ArrayList<>();

        // 1
        walls.add(new Wall(new Position(2, 2)));
        walls.add(new Wall(new Position(3, 1)));
        walls.add(new Wall(new Position(4, 1)));
        walls.add(new Wall(new Position(5, 1)));
        walls.add(new Wall(new Position(6, 1)));
        walls.add(new Wall(new Position(7, 1)));
        walls.add(new Wall(new Position(8, 1)));
        walls.add(new Wall(new Position(9, 1)));
        walls.add(new Wall(new Position(10, 2)));
        walls.add(new Wall(new Position(11, 3)));
        walls.add(new Wall(new Position(12, 3)));
        walls.add(new Wall(new Position(13, 3)));
        walls.add(new Wall(new Position(14, 3)));
        walls.add(new Wall(new Position(15, 2)));
        walls.add(new Wall(new Position(16, 1)));
        walls.add(new Wall(new Position(17, 1)));
        walls.add(new Wall(new Position(18, 1)));
        walls.add(new Wall(new Position(19, 1)));
        walls.add(new Wall(new Position(20, 1)));
        walls.add(new Wall(new Position(21, 1)));
        walls.add(new Wall(new Position(22, 1)));
        walls.add(new Wall(new Position(23, 1)));
        walls.add(new Wall(new Position(24, 2)));
        walls.add(new Wall(new Position(1, 3)));
        walls.add(new Wall(new Position(1, 4)));
        walls.add(new Wall(new Position(1, 5)));
        walls.add(new Wall(new Position(1, 6)));
        walls.add(new Wall(new Position(1, 7)));
        walls.add(new Wall(new Position(1, 8)));
        walls.add(new Wall(new Position(1, 9)));
        walls.add(new Wall(new Position(1, 10)));
        walls.add(new Wall(new Position(1, 11)));
        walls.add(new Wall(new Position(1, 12)));
        walls.add(new Wall(new Position(1, 13)));
        walls.add(new Wall(new Position(2, 14)));
        walls.add(new Wall(new Position(1, 8)));
        walls.add(new Wall(new Position(2, 8)));
        walls.add(new Wall(new Position(3, 9)));
        walls.add(new Wall(new Position(4, 9)));
        walls.add(new Wall(new Position(5, 9)));
        walls.add(new Wall(new Position(6, 10)));
        walls.add(new Wall(new Position(7, 10)));
        walls.add(new Wall(new Position(8, 10)));
        walls.add(new Wall(new Position(9, 9)));
        walls.add(new Wall(new Position(10, 9)));
        walls.add(new Wall(new Position(11, 9)));
        walls.add(new Wall(new Position(12, 8)));
        walls.add(new Wall(new Position(13, 8)));
        walls.add(new Wall(new Position(25, 3)));
        walls.add(new Wall(new Position(25, 4)));
        walls.add(new Wall(new Position(25, 5)));
        walls.add(new Wall(new Position(25, 6)));
        walls.add(new Wall(new Position(25, 7)));
        walls.add(new Wall(new Position(25, 8)));
        walls.add(new Wall(new Position(25, 9)));
        walls.add(new Wall(new Position(25, 10)));
        walls.add(new Wall(new Position(25, 11)));
        walls.add(new Wall(new Position(25, 13)));
        walls.add(new Wall(new Position(24, 14)));
        walls.add(new Wall(new Position(3, 15)));
        walls.add(new Wall(new Position(4, 15)));
        walls.add(new Wall(new Position(5, 15)));
        walls.add(new Wall(new Position(6, 15)));
        walls.add(new Wall(new Position(7, 15)));
        walls.add(new Wall(new Position(8, 15)));
        walls.add(new Wall(new Position(9, 15)));
        walls.add(new Wall(new Position(10, 15)));
        walls.add(new Wall(new Position(11, 15)));
        walls.add(new Wall(new Position(12, 15)));
        walls.add(new Wall(new Position(13, 15)));
        walls.add(new Wall(new Position(14, 15)));
        walls.add(new Wall(new Position(15, 15)));
        walls.add(new Wall(new Position(16, 15)));
        walls.add(new Wall(new Position(17, 15)));
        walls.add(new Wall(new Position(18, 15)));
        walls.add(new Wall(new Position(19, 15)));
        walls.add(new Wall(new Position(20, 15)));
        walls.add(new Wall(new Position(21, 15)));
        walls.add(new Wall(new Position(22, 15)));
        walls.add(new Wall(new Position(23, 15)));

        return walls;
    }

    public static List<Enemy> createEnemies1() {
        List<Enemy> enemies = new ArrayList<>();

        // 1
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SCORPION, new Position(16, 3)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SCORPION, new Position(4, 13)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.RAT, new Position(14, 8)));

        return enemies;
    }

    public static List<Enemy> createEnemies2() {
        List<Enemy> enemies = new ArrayList<>();

        // 2
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SNAKE, new Position(20, 5)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SCORPION, new Position(20, 13)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.RAT, new Position(8, 13)));

        return enemies;
    }
    public static List<Enemy> createEnemies3() {
        List<Enemy> enemies = new ArrayList<>();

        // 3
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SNAKE, new Position(20, 8)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SNAKE, new Position(20, 7)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.RAT, new Position(2, 3)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SNAKE, new Position(20, 5)));
        enemies.add(new EnemyDefaultFactory().createEnemy(Enemy.TYPE.SNAKE, new Position(20, 6)));

        return enemies;
    }
}
