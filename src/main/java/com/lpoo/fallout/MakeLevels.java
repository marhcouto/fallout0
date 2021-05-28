package com.lpoo.fallout;

import java.io.IOException;

public class MakeLevels {
    public static void main(String[] args) {
        try {
            ArenaMaker.createFile(ArenaMaker.createWalls1(), ArenaMaker.createEnemies1(), ArenaMaker.createDoors1(), "arena1");
            ArenaMaker.createFile(ArenaMaker.createWalls2(), ArenaMaker.createEnemies2(), ArenaMaker.createDoors2(), "arena2");
            ArenaMaker.createFile(ArenaMaker.createWalls3(), ArenaMaker.createEnemies3(), ArenaMaker.createDoors3(), "arena3");
            ArenaMaker.createGameFile("arena1", ArenaMaker.createVaultBoy(), "gamestat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
