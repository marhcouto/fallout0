package com.lpoo.fallout;

import java.io.IOException;

public class MakeLevels {
    public static void main(String[] args) {
        try {
            ArenaMaker.createFile(ArenaMaker.createWalls(), ArenaMaker.createEnemies(), "arena1");
            ArenaMaker.createGameFile("arena1", ArenaMaker.createVaultBoy(), "gamestat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
