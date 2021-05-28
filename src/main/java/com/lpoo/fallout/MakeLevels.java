package com.lpoo.fallout;

import java.io.IOException;

public class MakeLevels {
    public static void main(String[] args) {
        try {
            ArenaMaker.createFile(ArenaMaker.createWalls2(), ArenaMaker.createEnemies2(), ArenaMaker.createDoors2(), "arena2");
            ArenaMaker.createGameFile("arena2", ArenaMaker.createVaultBoy(), "gamestat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
