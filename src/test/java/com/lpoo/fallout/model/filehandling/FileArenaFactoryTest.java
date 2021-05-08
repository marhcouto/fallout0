package com.lpoo.fallout.model.filehandling;

import com.lpoo.fallout.ArenaMaker;
import com.lpoo.fallout.model.wander.Arena;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileArenaFactoryTest {

    @Test
    public void getArenaFromFileTest() throws IOException, ClassNotFoundException {
        String arenaName = "arena1";
        Arena arena;

        FileArenaFactory arenaFactory = new FileArenaFactory(arenaName);
        Assertions.assertDoesNotThrow(() -> ArenaMaker.createFile(ArenaMaker.createWalls(), ArenaMaker.createEnemies(), arenaName));

        arena = new FileArenaFactory(arenaName).createArena();

        for (int i = 0; i < arena.getWallMap().size(); i++)
            Assertions.assertTrue(arena.getWallMap().containsValue(ArenaMaker.createWalls().get(i)));

        for (int i = 0; i < arena.getEnemies().size(); i++)
            Assertions.assertEquals(ArenaMaker.createEnemies().get(i), arena.getEnemies().get(i));

    }
}
