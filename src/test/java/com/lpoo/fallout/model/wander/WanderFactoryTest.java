package com.lpoo.fallout.model.wander;

import com.lpoo.fallout.ArenaMaker;
import com.lpoo.fallout.model.Attributes;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class WanderFactoryTest {
    private VaultBoy vaultBoy;

    @BeforeEach
    public void createVaultBoy() {
        this.vaultBoy = new VaultBoy(new Position(9, 9), new Attributes(10, 10, 10, 10));
    }

    @Test
    public void fileWanderFactoryTest() {
        FileWanderFactory wf = new FileWanderFactory("arena1", this.vaultBoy);


        Assertions.assertDoesNotThrow(() -> ArenaMaker.createFile(ArenaMaker.createWalls(), ArenaMaker.createEnemies(), "arena1"),
                "An exception was thrown when it should have not been thrown");

        WanderModel wanderModel = wf.createWanderModel();

        for (int i = 0; i < wanderModel.getWalls().size(); i++)
            Assertions.assertEquals(ArenaMaker.createWalls().get(i), wanderModel.getWalls().get(i));

        for (int i = 0; i < wanderModel.getEnemies().size(); i++)
            Assertions.assertEquals(ArenaMaker.createEnemies().get(i), wanderModel.getEnemies().get(i));


    }
}
