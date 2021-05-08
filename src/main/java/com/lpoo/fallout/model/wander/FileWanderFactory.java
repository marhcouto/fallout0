package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.model.*;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.URL;
import java.util.*;

public class FileWanderFactory implements WanderFactory {
    private final String arenaName;
    private final VaultBoy vaultBoy;

    public FileWanderFactory(@NotNull String arenaName, @NotNull VaultBoy vaultBoy) {
        this.arenaName = arenaName;
        this.vaultBoy = vaultBoy;
    }

    @Override
    public WanderModel createWanderModel() {

        Map<Position, Wall> walls = new HashMap<>();
        List<Enemy> enemies = new ArrayList<>();

        try {
            this.readFromFile(walls, enemies);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new WanderModel(this.vaultBoy, walls, enemies);

    }

    private void readFromFile(Map<Position, Wall> walls, List<Enemy> enemies) throws IOException, ClassNotFoundException {

        // Walls
        FileInputStream wallsIS = new FileInputStream(new File("resources/arenas/" + arenaName + "/walls.bin"));
        ObjectInputStream wallsOIS = new ObjectInputStream(wallsIS);

        while(wallsIS.available() > 0) {
            Wall w = (Wall) wallsOIS.readObject();
            walls.put(w.getPosition(), w);
        }

        wallsOIS.close();

        // Enemies
        FileInputStream enemiesIS = new FileInputStream(new File("resources/arenas/" + arenaName + "/enemies.bin"));
        ObjectInputStream enemiesOIS = new ObjectInputStream(enemiesIS);

        while(enemiesIS.available() > 0) {
            enemies.add((Enemy) enemiesOIS.readObject());
        }

        enemiesOIS.close();

    }
}
