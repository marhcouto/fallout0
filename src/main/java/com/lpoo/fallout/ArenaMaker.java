package com.lpoo.fallout;

import com.lpoo.fallout.model.wander.*;
import com.lpoo.fallout.model.wander.element.Enemy;
import com.lpoo.fallout.model.wander.element.VaultBoy;
import com.lpoo.fallout.model.wander.element.Wall;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArenaMaker {

    public static void createFile(List<Wall> wallsList, List<Enemy> enemies, String arenaName) throws IOException {

        Map<Position, Wall> walls = new HashMap<>();

        for (Wall wall : wallsList)
            walls.put(wall.getPosition(), wall);

        Arena arena = new Arena(walls, enemies, arenaName);

        File file = new File("resources/arenas/" + arenaName + ".bin");
        if (!file.exists())
            file.createNewFile();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file, false));
        os.writeObject(arena);
        os.close();


        /*// Walls
        File wallsFile = new File("resources/arenas/" + arenaName + "/walls.bin");
        if (!wallsFile.exists())
            wallsFile.createNewFile();
        ObjectOutputStream wallsOS = new ObjectOutputStream(new FileOutputStream(wallsFile, false));

        for (Wall wall : walls)
            wallsOS.writeObject(wall);

        wallsOS.close();

        // Enemies
        File enemiesFile = new File("resources/arenas/" + arenaName + "/enemies.bin");
        if (!enemiesFile.exists())
            enemiesFile.createNewFile();
        ObjectOutputStream enemiesOS = new ObjectOutputStream(new FileOutputStream(enemiesFile, false));

        for (Enemy enemy : enemies)
            enemiesOS.writeObject(enemy);

        enemiesOS.close();*/
    }

    public static VaultBoy createVaultBoy() {
        return new VaultBoy(new Position(5, 5), new Attributes(1,1,1,1));
    }

    public static void createGameFile(String arena, VaultBoy vaultBoy) throws IOException {

        File file = new File("resources/gamestat.bin");
        if (!file.exists())
            file.createNewFile();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(arena);
        os.writeObject(vaultBoy);
        os.close();
    }

    public static List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        walls.add(new Wall(new Position(1, 1)));
        walls.add(new Wall(new Position(2, 1)));
        walls.add(new Wall(new Position(3, 1)));
        walls.add(new Wall(new Position(4, 1)));
        walls.add(new Wall(new Position(5, 1)));
        walls.add(new Wall(new Position(6, 1)));
        walls.add(new Wall(new Position(7, 1)));
        walls.add(new Wall(new Position(8, 1)));
        walls.add(new Wall(new Position(9, 1)));
        walls.add(new Wall(new Position(10, 1)));
        walls.add(new Wall(new Position(1, 2)));
        walls.add(new Wall(new Position(1, 3)));
        walls.add(new Wall(new Position(1, 4)));
        walls.add(new Wall(new Position(1, 5)));
        walls.add(new Wall(new Position(1, 6)));
        walls.add(new Wall(new Position(1, 7)));
        walls.add(new Wall(new Position(1, 8)));
        walls.add(new Wall(new Position(1, 9)));
        walls.add(new Wall(new Position(1, 10)));
        walls.add(new Wall(new Position(10, 2)));
        walls.add(new Wall(new Position(10, 3)));
        walls.add(new Wall(new Position(10, 4)));
        walls.add(new Wall(new Position(10, 5)));
        walls.add(new Wall(new Position(10, 6)));
        walls.add(new Wall(new Position(10, 7)));
        walls.add(new Wall(new Position(10, 8)));
        walls.add(new Wall(new Position(10, 9)));
        walls.add(new Wall(new Position(10, 10)));
        walls.add(new Wall(new Position(2, 10)));
        walls.add(new Wall(new Position(3, 10)));
        walls.add(new Wall(new Position(4, 10)));
        walls.add(new Wall(new Position(5, 10)));
        walls.add(new Wall(new Position(6, 10)));
        walls.add(new Wall(new Position(7, 10)));
        walls.add(new Wall(new Position(8, 10)));
        walls.add(new Wall(new Position(9, 10)));





        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Walls:");

        // Input cycle
        while(true) {
            System.out.println("Column:");
            Integer column, row;
            try {
                column = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Row:");
            try {
                row = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            walls.add(new Wall(new Position(column, row)));

            System.out.println("Over?");
            try {
                if (scanner.next().equals("yes")) break;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
        }
        scanner.close();*/

        return walls;
    }
    public static List<Enemy> createEnemies() {
        List<Enemy> enemies = new ArrayList<>();

        enemies.add(new Enemy(new Position(2, 2), new Attributes(1, 2, 3, 4),
                new Weapon(10, "Avocado", new Attributes(0, 0, 0, 0)), 4, Enemy.TYPE.RAT));
        enemies.add(new Enemy(new Position(2, 3), new Attributes(1, 2, 3, 4),
                new Weapon(10, "Avocado", new Attributes(0, 0, 0, 0)), 4, Enemy.TYPE.RAT));
        enemies.add(new Enemy(new Position(3, 3), new Attributes(1, 2, 3, 4),
                new Weapon(10, "Avocado", new Attributes(0, 0, 0, 0)), 4, Enemy.TYPE.RAT));
        enemies.add(new Enemy(new Position(7, 9), new Attributes(1, 2, 3, 4),
                new Weapon(10, "Avocado", new Attributes(0, 0, 0, 0)), 4, Enemy.TYPE.RAT));
        enemies.add(new Enemy(new Position(7, 2), new Attributes(1, 2, 3, 4),
                new Weapon(10, "Avocado", new Attributes(0, 0, 0, 0)), 4, Enemy.TYPE.RAT));
        enemies.add(new Enemy(new Position(4, 8), new Attributes(1, 2, 3, 4),
                new Weapon(10, "Avocado", new Attributes(0, 0, 0, 0)), 4, Enemy.TYPE.SCORPION));



        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Enemies:");

        // Input cycle
        while(true) {
            Integer column, row, strength1, agility1, inteligence1, luck1, level,
                    damage, strength2, agility2, inteligence2, luck2;
            String enemyName, weaponName;

            System.out.println("Enemy:");
            *//*System.out.println("Name:");
            try {
                enemyName = scanner.next();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }*//*
            System.out.println("Column:");
            try {
                column = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Row:");
            try {
                row = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Strength:");
            try {
                strength1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Agility:");
            try {
                agility1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Inteligence:");
            try {
                inteligence1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Luck:");
            try {
                luck1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Level:");
            try {
                level = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }

            System.out.println("Weapon:");
            System.out.println("Damage:");
            try {
                damage = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Name:");
            try {
                weaponName = scanner.next();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Strength:");
            try {
                strength2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Agility:");
            try {
                agility2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Inteligence:");
            try {
                inteligence2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("Luck:");
            try {
                luck2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }


            Weapon w1 = new Weapon(damage, weaponName, new Attributes(strength2, agility2, inteligence2, luck2));
            enemies.add(new Enemy(new Position(column, row), new Attributes(strength1, agility1, inteligence1, luck1), w1, level));

            System.out.println("Over?");
            try {
                if (scanner.next().equals("yes")) break;
            } catch (InputMismatchException e) {
                e.printStackTrace();
                break;
            }
        }
        scanner.close();*/
        return enemies;
    }
}
