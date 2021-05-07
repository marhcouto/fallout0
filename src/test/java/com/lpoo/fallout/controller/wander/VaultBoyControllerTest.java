package com.lpoo.fallout.controller.wander;

import com.lpoo.fallout.gui.LanternaGUI;
import com.lpoo.fallout.model.Attributes;
import com.lpoo.fallout.model.Position;
import com.lpoo.fallout.model.VaultBoy;
import com.lpoo.fallout.model.Wall;
import com.lpoo.fallout.model.wander.WanderModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

class VaultBoyControllerTest {
    VaultBoyController controller;
    WanderModel model;

    @BeforeEach
    void setUp() {
        VaultBoy vaultBoy = new VaultBoy(new Position(1, 0), new Attributes(0, 0, 0, 0));
        model = Mockito.mock(WanderModel.class, Mockito.CALLS_REAL_METHODS);
        model.setWalls(Arrays.asList(new Wall(new Position(0, 0))));
        model.setVaultBoy(vaultBoy);
        model.setEnemies(new ArrayList<>());
        controller = new VaultBoyController(model);
    }

    @Test
    void action() {
        Assertions.assertEquals(new Position(1, 0), model.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.RIGHT);
        Assertions.assertEquals(new Position(2, 0), model.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.DOWN);
        Assertions.assertEquals(new Position(2, 1), model.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.UP);
        Assertions.assertEquals(new Position(2, 0), model.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.LEFT);
        Assertions.assertEquals(new Position(1, 0), model.getVaultBoy().getPosition());
        controller.action(LanternaGUI.ACTION.NONE);
        Assertions.assertEquals(new Position(1, 0), model.getVaultBoy().getPosition());
    }

    @Test
    void bug1() {
        /*
            Vault Boy was ignoring walls
         */
        VaultBoyController vbController = new VaultBoyController(model);
        vbController.moveVaultBoy(model.getVaultBoy().getPosition().left());
        Assertions.assertEquals(new Position(1, 0), model.getVaultBoy().getPosition());
    }
}